package ti.forma.avaliacao_mobile.api

import android.util.Log
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ti.forma.avaliacao_mobile.model.LoginResponse
import ti.forma.avaliacao_mobile.model.User

class LoginClient{

    fun login(user: User, callBackResponse: LoginResponse<User>) {

        val call = RetrofitInitializer().loginService().login(user)

        call.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User?>?, response: Response<User?>?) {

                response?.body()?.let {
                    val tk = it
                    user.token = tk.token
                    callBackResponse.success(user)
                }
            }

            override fun onFailure(call: Call<User?>?, t: Throwable) {

                Log.e("Deu ruim.", t?.message)
            }
        })
    }
}