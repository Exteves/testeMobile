package ti.forma.avaliacao_mobile.model.Ping

import com.google.gson.annotations.SerializedName

data class Ping(
	@field:SerializedName("mensagem")
	val mensagem: String? = null,

	@field:SerializedName("sucesso")
	val sucesso: Boolean? = null
)