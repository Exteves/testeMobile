package ti.forma.avaliacao_mobile.model.Ping

interface PingResponse<T> {
    fun successPing(ping: Ping)

    fun errorPing(s: String)
}