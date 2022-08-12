package mobi.appcent.flightapplication.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import mobi.appcent.flightapplication.R
import mobi.appcent.flightapplication.utils.Constant

class LoginActivity : AppCompatActivity() {
    private var isRemember = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            if (Constant.email == etEmail.text.toString() && Constant.password == etPassword.text.toString()) {
                if (isRemember) {
                    rememberMe()
                }
                val loginIntent = Intent(this, HomeActivity::class.java)
                startActivity(loginIntent)
                finish()
            } else {
                Toast.makeText(
                    this,
                    Constant.loginError,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        cbRememberMe.setOnCheckedChangeListener { _, isChecked ->
            isRemember = isChecked
        }
    }

    private fun rememberMe(){
        val sharedPreferences = getSharedPreferences("MySharedPreferences", Context.MODE_PRIVATE)
        val infoEdit = sharedPreferences.edit()
        infoEdit.putString(Constant.email,etEmail.text.toString())
        infoEdit.putString(Constant.password,etPassword.text.toString())
        infoEdit.putBoolean("isRemember",isRemember)
        infoEdit.commit()
    }
}