package ti.forma.avaliacao_mobile.model

interface LoginResponse<T> {
    fun success(token : User)
}