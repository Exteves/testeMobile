package ti.forma.avaliacao_mobile.model

import retrofit2.Call
import retrofit2.http.*

interface LoginService{
    @POST("monitores/login")
    fun login(@Body user : User) : Call<User>
}