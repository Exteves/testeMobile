package ti.forma.avaliacao_mobile.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_menu.*
import ti.forma.avaliacao_mobile.R
import ti.forma.avaliacao_mobile.session.SessionManager

class menu : AppCompatActivity() {

    private lateinit var session : SessionManager
    private lateinit var email : String
    private lateinit var token : String
    private lateinit var user : HashMap<String, String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        session = SessionManager(this)

        btnLogout.setOnClickListener {
            Toast.makeText(this@menu, "Obrigado e até logo! :)", Toast.LENGTH_SHORT).show()
            session.LogoutUser()
        }
        btnListarUniformes.setOnClickListener {
            var i = Intent(this, uniforme_list::class.java)
            startActivity(i)
        }
    }
}
