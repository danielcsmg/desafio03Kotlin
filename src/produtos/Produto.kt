package produtos

abstract class Produto(private val codigo: Int, private val nome: String ,private val preco: Double) {

    fun getCodigo(): Int{
        return codigo
    }

    fun getNome(): String{
        return nome
    }

    fun getPreco(): Double{
        return preco
    }

    fun mostrarDetalheProduto(qtd: Int): String{
        return "Cód: ${getCodigo()} | $qtd x ${getNome()} - R$${"%.2f".format(getPreco())}"
    }
}