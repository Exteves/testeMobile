package ti.forma.avaliacao_mobile.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ti.forma.avaliacao_mobile.api.LoginClient
import ti.forma.avaliacao_mobile.model.LoginResponse
import ti.forma.avaliacao_mobile.model.User
import android.widget.Toast
import ti.forma.avaliacao_mobile.R
import ti.forma.avaliacao_mobile.session.SessionManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val session = SessionManager(applicationContext)

        if (session.isLoggedIn()){
            var i: Intent = Intent(applicationContext, menu::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(i)
            finish()
        }

        btnLogin.setOnClickListener {
            val username = username.text
            val password = password.text

            val user = User(username.toString(), password.toString())

            LoginClient().login(user, object : LoginResponse<User>{
                override fun error(s: String) {
                    Toast.makeText(this@MainActivity, s, Toast.LENGTH_SHORT).show()
                }

                override fun success(user: User) {
                    Toast.makeText(this@MainActivity, user.token, Toast.LENGTH_SHORT).show()
                    session.createLoginSession(user.email, user.token)
                    val i = Intent(this@MainActivity, uniforme_list::class.java)
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(i)
                    finish()
                }
            })
        }
    }
}
