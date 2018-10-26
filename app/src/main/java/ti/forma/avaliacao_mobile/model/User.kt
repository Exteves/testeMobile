package ti.forma.avaliacao_mobile.model

class User (
    val email : String,
    val senha : String
){
    lateinit var token : String
}