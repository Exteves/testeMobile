package ti.forma.avaliacao_mobile

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ti.forma.avaliacao_mobile.api.LoginClient
import ti.forma.avaliacao_mobile.model.LoginResponse
import ti.forma.avaliacao_mobile.model.User
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin.setOnClickListener {
            val username = username.text
            val password = password.text

            val user = User(username.toString(), password.toString())

            LoginClient().login(user, object : LoginResponse<User>{
                override fun success(user: User) {
                    Toast.makeText(this@MainActivity, user.token, Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}
