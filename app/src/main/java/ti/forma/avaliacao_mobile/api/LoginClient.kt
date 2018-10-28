package ti.forma.avaliacao_mobile.api

import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ti.forma.avaliacao_mobile.model.Login.LoginResponse
import ti.forma.avaliacao_mobile.model.Login.User

class LoginClient{

    fun login(user: User, callBackResponse: LoginResponse<User>) {

        val call = RetrofitInitializer().loginService().login(user)

        call.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User?>?, response: Response<User?>?) {
                response?.body()?.let {
                    user.token = it.token
                    callBackResponse.success(user)
                }?: run {
                    user.token = ""
                    callBackResponse.success(user)
                }
            }

            override fun onFailure(call: Call<User?>?, t: Throwable) {
                callBackResponse.error("Login inválido :(")
            }
        })
    }
}