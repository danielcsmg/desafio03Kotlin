import carrinho.Carrinho
import menus.CabecalhoMenu.Menu.opcaoPagamento
import menus.CabecalhoMenu.Menu.opcoesBebidas
import menus.CabecalhoMenu.Menu.opcoesLanches
import menus.CabecalhoMenu.Menu.opcoesPedido
import menus.CabecalhoMenu.Menu.opcoesPricipal
import produtos.Produto
import produtosCadastrados.ProdutosCadastrados
import kotlin.system.exitProcess

class Menu {
    private val carrinho = Carrinho()
    private val produtosCadastrados = ProdutosCadastrados()

    init {
        menuPedido()
    }

    private fun menuOpcoes(){
        while (true) {
            opcoesPricipal()
            val opc = readln().toIntOrNull()
            when(opc){
                1 -> menuPedido()
                2 -> {
                    alterarPedido()
                    continue
                }
                3 -> {
                    carrinho.mostrarCarrinho()
                    continue
                }
                4 -> removerPedido()
                5 -> finalizarPedido()
                0 -> {
                    println("Pedido cancelado. :(")
                    exitProcess(0)
                }
                else -> println("Opção inválida! Digite novamente.")
            }
        }
    }

    private fun menuPedido(){
        while (true){
            opcoesPedido()
            val opcao = readln().toIntOrNull()
            when (opcao){
                1 -> {
                    menuLanche()
                    return
                }
                2 -> {
                    menuBebida()
                    return
                }
                0 -> {
                    println("Pedido cancelado. :(")
                    exitProcess(0)
                }
                else -> println("Opção inválida! Tente novamente.")
            }
        }
    }

    private fun menuLanche(){
        while (true) {
            opcoesLanches()
            val opcao = readln().toIntOrNull()
            when (opcao) {
                1 -> {
                    fazerPedido(escolherProduto("X-Burguer"))
                    return
                }
                2 -> {
                    fazerPedido(escolherProduto("X-Salada"))
                    return
                }
                0 -> {
                    println("Pedido cancelado. :(")
                    exitProcess(0)
                }
                else -> println("Opção inválida! Tente novamente.")
            }
        }
    }

    private fun menuBebida() {
        while (true) {
            opcoesBebidas()
            val opcao = readln().toIntOrNull()
            when (opcao) {
                1 -> {
                    fazerPedido(escolherProduto("Refrigerante"))
                    return
                }
                2 -> {
                    fazerPedido(escolherProduto("Suco"))
                    return
                }
                0 -> {
                    println("Pedido cancelado. :(")
                    exitProcess(0)
                }
                else -> println("Opção inválida! Tente novamente.")
            }
        }
    }

    private fun fazerPedido(produto: Produto){
        val qtd = getQuantidade()
        carrinho.adicionarProduto(produto, qtd)
        menuOpcoes()
    }

    private fun alterarPedido() {
        while (true) {
            val codigo = getCode()
            carrinho.produtos.forEach { (produto, _) ->
                if (codigo == produto.getCodigo()) {
                    val novaQtd = getQuantidade()
                    carrinho.editarProduto(produto, novaQtd)
                    println("Pedido alterado!")
                    return
                }
            }
            println("Produto não encontrado no carrinho.")
            println("Tente um código diferente.")
            carrinho.mostrarCarrinho()
        }
    }

    private fun removerPedido() {
        while (true) {
            val codigo = getCode()
            carrinho.produtos.forEach { (produto, qtdProduto) ->
                if (codigo == produto.getCodigo() && qtdProduto > 0) {
                    carrinho.removerProduto(produto)
                    println("Pedido removido!")
                    return
                }
            }
            println("Produto não encontrado no carrinho.")
            println("Tente um código diferente.")
            carrinho.mostrarCarrinho()
        }
    }

    private fun getQuantidade(): Int {
        while (true){
            println("Digite a quantidade de produtos:")
            val qtd = readln().toIntOrNull() ?: -1
            if(qtd < 0){
                println("Valor inválido! Tente novamente.")
                continue
            }
            return qtd
        }
    }

    private fun getCode(): Int {
        while (true){
            println("Digite o código do produto:")
            val code = readln().toIntOrNull() ?: -1
            if(code < 0){
                println("Valor inválido! Tente novamente.")
                continue
            }
            return code
        }
    }

    private fun finalizarPedido(){
        carrinho.mostrarCarrinho()
        carrinho.mostrarTotaldeCompras()
        while (true) {
            opcaoPagamento()
            val opcao = readln().toIntOrNull()
            when (opcao){
                1, 2, 3 -> {
                    println("Pedido finalizado. Bom apetite! ;D")
                    exitProcess(0)
                }
                4 -> {
                    pagarEmDinheiro()
                    exitProcess(0)
                }
                0 -> {
                    println("Pedido cancelado. :(")
                    exitProcess(0)
                }
                else -> println("Opção inválida! Tente novamente.")
            }
        }
    }

    private fun pagarEmDinheiro(){
        while (true){
            val valorEmDinheiro = inserirValor()
            val valorDoPedido = carrinho.getTotalDeCompras()
            if(valorEmDinheiro < valorDoPedido){
                println("Quantia insuficiente! Tente novamente.")
                return
            }
            val troco = valorEmDinheiro - valorDoPedido
            println("Seu troco é R$${"%.2f".format(troco)}")
            println("Pedido finalizado. Bom apetite! ;D")
            return
        }

    }

    private fun inserirValor(): Double {
        while (true){
            println("Digite o valor do pagamento:")
            val pagamento = readln().toDoubleOrNull() ?: -1.0
            if (pagamento < 0.0){
                println("Você inseriu uma entrada inválida. Tente novamente.")
                continue
            }
            return pagamento
        }
    }

    private fun escolherProduto(nome: String): Produto{
        produtosCadastrados.lanches.forEach{
            if(nome == it.getNome()){
                return it
            }
        }

        produtosCadastrados.bebidas.forEach{
            if(nome == it.getNome()){
                return it
            }
        }
        throw RuntimeException("Código não encontrado!")
    }
}