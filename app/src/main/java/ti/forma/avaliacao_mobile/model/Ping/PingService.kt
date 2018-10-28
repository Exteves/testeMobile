package ti.forma.avaliacao_mobile.model.Ping

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface PingService{
    @Headers(
        "Accept: application/json",
        "Content-type:application/json"
    )
    @POST("smartPass/ping")
    fun testConnection(
        @Header("Authorization") authToken : String,
        @Body emptyJson : String
    ) : Call<Ping>
}