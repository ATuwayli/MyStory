package com.atuwayli.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class LoginActivity : AppCompatActivity() {

    private var etUsername: EditText? = null
    private var etPassword: EditText? = null
    private var btnLogin: Button? = null
    private var checkBox: CheckBox? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        connectViews()
        login()
    }


    private fun connectViews() {
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        checkBox = findViewById(R.id.checkBox)
    }

    private fun login() {
        val array: ArrayList<User> = ArrayList()
        array.add(User("test@test.com", "1234"))

        btnLogin?.setOnClickListener {
            val username = etUsername?.text.toString()
            val password = etPassword?.text.toString()

            val user = User(username, password)
            for (userArray in array) {
                if (userArray.email == user.email &&
                    userArray.password == user.password &&
                    checkBox?.isChecked() == true ){
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("email",userArray.email)
                    startActivity(intent)
                    //Toast.makeText(this, "Welcome ${user.email}", Toast.LENGTH_SHORT).show()
                    finish()

                    break

                } else if (etUsername?.text?.isEmpty() == true) {
                    etUsername?.setError("here your email")
                } else if (etPassword?.text?.isEmpty() == true) {
                    etPassword?.setError("here your password")
                } else if (checkBox?.isChecked() != true){
                    checkBox?.setError("Please checked terms")
                } else if (userArray.email != user.email ||
                            userArray.password != user.password){
                    Toast.makeText(this, "Wrong entry information", Toast.LENGTH_SHORT).show()
                }

                }
            }
        }
}