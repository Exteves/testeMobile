package ti.forma.avaliacao_mobile.model

interface UniformeResponse<T> {
    fun successUniforme(uniformeList : List<Uniforme>)

    fun erroUniformeList(s: String)
}