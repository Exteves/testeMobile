package ti.forma.avaliacao_mobile.model.Login

interface LoginResponse<T> {
    fun success(token : User)

    fun error(s: String)
}