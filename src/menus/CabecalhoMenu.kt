package menus

class CabecalhoMenu {
    companion object Menu{
        fun opcoesPricipal(){
            println("Digite uma opção:")
            println("[1] Adicionar mais itens;")
            println("[2] para alterar o pedido;")
            println("[3] para mostrar o pedido;")
            println("[4] para remover um pedido;")
            println("[5] para pagar;")
            println("[0] para sair.")
            println()
        }


        fun opcoesPedido(){
            println("Digite sua opção de compra:")
            println("[1] para Lanche;")
            println("[2] para Bebida;")
            println("[0] para Sair.")
        }

        fun opcoesLanches(){
            println("Qual opção de Lanche")
            println("[1] X-Burguer R$ 10,00")
            println("[2] X-Salada RS 12,00")
            println("[0] Sair")
        }

        fun opcoesBebidas(){
            println("Qual opção de Bebida")
            println("[1] Refrigerante R$ 8,00")
            println("[2] Suco R$ 6,00")
            println("[0] Sair")
        }

        fun opcaoPagamento(){
            println("Selecione uma forma de pagamento:")
            println("[1] para Cartão de Crédito;")
            println("[2] para Cartão de Débito;")
            println("[3] para Vale-Alimentação;")
            println("[4] para Dinheiro.")
            println("[0] para Sair.")
        }
    }
}