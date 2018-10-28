package ti.forma.avaliacao_mobile.ui.activity

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_menu.*
import ti.forma.avaliacao_mobile.R
import ti.forma.avaliacao_mobile.api.PingClient
import ti.forma.avaliacao_mobile.model.Ping.Ping
import ti.forma.avaliacao_mobile.model.Ping.PingResponse
import ti.forma.avaliacao_mobile.session.SessionManager
import java.util.*
import kotlin.concurrent.schedule

class menu : AppCompatActivity() {

    private lateinit var session : SessionManager
    private lateinit var email : String
    private lateinit var token : String
    private lateinit var user : HashMap<String, String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        session = SessionManager(this)
        session.checkLogin()
        user = session.getUserDetails()
        email = user.get(SessionManager.KEY_USERNAME)!!
        this.token = user.get(SessionManager.KEY_TOKEN)!!

        fun testConnection() {
        Handler().postDelayed({
            PingClient().testConnection(this.token, "{}", object : PingResponse<Ping>{
                override fun successPing(ping: Ping) {
                    status.text = ping.mensagem
                    if (ping.sucesso!!){
                        status.setTextColor(Color.GREEN)}
                    else{
                        status.setTextColor(Color.RED)
                        session.LogoutUser()
                    }

                    Toast.makeText(this@menu, ping.mensagem, Toast.LENGTH_SHORT).show()
                }

                override fun errorPing(s: String) {
                    Toast.makeText(this@menu, s, Toast.LENGTH_SHORT).show()
                }

            })
            testConnection()
        }, 30000)
        }

        testConnection()

        btnLogout.setOnClickListener {
            Toast.makeText(this@menu, "Obrigado e até logo! :)", Toast.LENGTH_SHORT).show()
            session.LogoutUser()
        }
        btnListarUniformes.setOnClickListener {
            val i = Intent(this, uniforme_list::class.java)
            startActivity(i)
        }
    }
}
