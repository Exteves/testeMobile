package ti.forma.avaliacao_mobile.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_uniforme_list.*
import ti.forma.avaliacao_mobile.R
import ti.forma.avaliacao_mobile.api.UniformeClient
import ti.forma.avaliacao_mobile.model.Uniforme
import ti.forma.avaliacao_mobile.model.UniformeResponse
import ti.forma.avaliacao_mobile.session.SessionManager
import ti.forma.avaliacao_mobile.ui.adapter.UniformeAdapter

class uniforme_list : AppCompatActivity() {

    private lateinit var session : SessionManager
    private lateinit var email : String
    private lateinit var token : String
    private lateinit var user : HashMap<String, String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uniforme_list)

        session = SessionManager(applicationContext)
        session.checkLogin()
        user = session.getUserDetails()
        email = user.get(SessionManager.KEY_USERNAME)!!
        this.token = user.get(SessionManager.KEY_TOKEN)!!
        val layoutManager = LinearLayoutManager(this)

        val recyclerView = rv_uniformes
        UniformeClient().getUniformes(this.token, object : UniformeResponse<List<Uniforme>>{
            override fun successUniforme(uniformeList: List<Uniforme>) {
                recyclerView.adapter = UniformeAdapter(uniformeList, this@uniforme_list)
                recyclerView.layoutManager = layoutManager
            }

            override fun erroUniformeList(s: String) {
                Toast.makeText(this@uniforme_list, s, Toast.LENGTH_SHORT).show()
            }

        })
    }
}
