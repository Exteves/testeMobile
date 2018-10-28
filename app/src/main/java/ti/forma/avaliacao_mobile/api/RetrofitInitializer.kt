package ti.forma.avaliacao_mobile.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ti.forma.avaliacao_mobile.model.Login.LoginService
import ti.forma.avaliacao_mobile.model.Ping.PingService
import ti.forma.avaliacao_mobile.model.Uniforme.UniformeService

class RetrofitInitializer{
    private val url = "http://saga-t.formahomolog.com.br/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun loginService () : LoginService = retrofit.create(LoginService::class.java)

    fun uniformeService() : UniformeService = retrofit.create(UniformeService::class.java)

    fun pingService() : PingService = retrofit.create(PingService::class.java)
}