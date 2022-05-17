package produtosCadastrados

import produtos.XBurguer
import produtos.Refrigerante
import produtos.Suco
import produtos.XSalada

class ProdutosCadastrados {
    val lanches = arrayListOf(
        XBurguer(),
        XSalada(),
    )

    val bebidas = arrayListOf(
        Refrigerante(),
        Suco(),
    )
}