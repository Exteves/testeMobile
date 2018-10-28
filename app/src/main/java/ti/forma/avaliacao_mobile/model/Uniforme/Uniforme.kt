package ti.forma.avaliacao_mobile.model.Uniforme
import com.google.gson.annotations.SerializedName

data class Uniforme(

	@field:SerializedName("codigoIt")
	val codigoIt: Int? = null,

	@field:SerializedName("codigo")
	val codigo: String? = null,

	@field:SerializedName("rowTot")
	val rowTot: Int? = null,

	@field:SerializedName("disponibilidade")
	val disponibilidade: Int? = null,

	@field:SerializedName("uniforme")
	val uniforme: String? = null,

	@field:SerializedName("monitor")
	val monitor: Any? = null,

	@field:SerializedName("categoriaId")
	val categoriaId: Int? = null,

	@field:SerializedName("tamanhoId")
	val tamanhoId: String? = null,

	@field:SerializedName("movimentacoes")
	val movimentacoes: Int? = null,

	@field:SerializedName("tamanho")
	val tamanho: String? = null,

	@field:SerializedName("codigoTag")
	val codigoTag: String? = null,

	@field:SerializedName("rowNum")
	val rowNum: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("sexo")
	val sexo: String? = null,

	@field:SerializedName("dataCadastro")
	val dataCadastro: String? = null
)