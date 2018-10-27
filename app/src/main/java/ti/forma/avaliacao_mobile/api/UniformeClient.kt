package ti.forma.avaliacao_mobile.api

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ti.forma.avaliacao_mobile.model.Uniforme
import ti.forma.avaliacao_mobile.model.UniformeResponse

class UniformeClient{
    fun getUniformes(token : String ,callBackResponse : UniformeResponse<List<Uniforme>>){
        val call = RetrofitInitializer().uniformeService().getUniformes(token)

        call.enqueue(object : Callback<List<Uniforme>?>{
            override fun onFailure(call: Call<List<Uniforme>?>?, t: Throwable) {
                callBackResponse.erroUniformeList("Não foi possível listar os uniformes ='(")
            }

            override fun onResponse(call: Call<List<Uniforme>?>?, response: Response<List<Uniforme>?>?) {
                response?.body()?.let {
                    val uniformListing : List<Uniforme> = it
                    callBackResponse.successUniforme(uniformListing)
                }
            }

        })
    }
}