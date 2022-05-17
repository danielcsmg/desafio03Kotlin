package carrinho

import produtos.Produto
import produtos.XBurguer

class Itens {
    private val itens = mutableMapOf<Produto, Int>()

    fun mostrarItens(){
        itens.forEach{
            println("${it.key.mostrarDetalheProduto(it.value)} - ${it.key.getPreco()*it.value}")
        }
    }


}