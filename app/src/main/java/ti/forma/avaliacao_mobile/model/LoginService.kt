package ti.forma.avaliacao_mobile.model

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService{
    @POST("login")
    fun login(@Body user : User) : Call<User>
}