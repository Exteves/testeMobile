package ti.forma.avaliacao_mobile.model.Uniforme

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface UniformeService {
    @Headers(
        "Accept: application/json",
        "Content-type:application/json"
    )
    @GET("monitores/uniformes")
    fun getUniformes(
        @Header("Authorization") authToken : String
    ) : Call<List<Uniforme>>
}