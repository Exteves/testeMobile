package ti.forma.avaliacao_mobile.model

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginConnection{
    @POST("smartPass/ping")
    fun testConnection(@Body EmptyJson : String ) : Call<String>
}