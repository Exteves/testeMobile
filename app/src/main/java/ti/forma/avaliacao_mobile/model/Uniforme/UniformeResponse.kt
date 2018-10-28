package ti.forma.avaliacao_mobile.model.Uniforme

interface UniformeResponse<T> {
    fun successUniforme(uniformeList : List<Uniforme>)

    fun erroUniformeList(s: String)
}