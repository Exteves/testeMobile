package ti.forma.avaliacao_mobile.api

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ti.forma.avaliacao_mobile.model.Ping.Ping
import ti.forma.avaliacao_mobile.model.Ping.PingResponse

class PingClient {
    fun testConnection(token : String, emptyJson: String, callBackResponse : PingResponse<Ping>){
        val call = RetrofitInitializer().pingService().testConnection(token, emptyJson)

        call.enqueue(object : Callback<Ping>{
            override fun onFailure(call: Call<Ping>?, t: Throwable) {
                callBackResponse.errorPing("Não foi possível exibir o tempo... :/")
            }

            override fun onResponse(call: Call<Ping>?, response: Response<Ping>?) {
                response?.body()?.let {
                    val ping : Ping = it
                    callBackResponse.successPing(ping)
                }
            }

        })
    }
}