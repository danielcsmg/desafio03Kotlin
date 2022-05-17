package carrinho

import produtos.Produto

class Carrinho() {
    val produtos: MutableMap<Produto, Int> = mutableMapOf()

    fun adicionarProduto(produto: Produto, qtd: Int){
        val qtdTotal = produtos[produto] ?: 0
        produtos[produto] = qtd + qtdTotal
        mostrarCarrinho()
    }

    fun editarProduto(produto: Produto, qtd: Int){
        produtos[produto] = qtd
        mostrarCarrinho()
    }

    fun removerProduto(produto: Produto){
        produtos[produto] = 0
        mostrarCarrinho()
    }

    fun mostrarCarrinho(){
        if (produtos.isEmpty()){
            println("Não há produtos por aqui!")
            return
        }
        produtos.forEach{ (produto, qtd) ->
            if (qtd > 0) {
                println(produto.mostrarDetalheProduto(qtd))
            }
        }
    }

    fun mostrarTotaldeCompras(){
        println("Valor total: ${getTotalDeCompras()}")
    }

    fun getTotalDeCompras(): Double{
        var total = 0.0
        produtos.forEach{
            val qtd = it.value
            val valorProduto = it.key.getPreco()
            val totalPorProduto = qtd * valorProduto
            total += totalPorProduto
        }
        return total
    }
}