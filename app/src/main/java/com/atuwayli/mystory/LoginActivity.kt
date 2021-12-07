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
        array.add(User("user1@test.com", "12345"))
        array.add(User("user2@test.com", "123456"))
        btnLogin?.setOnClickListener {
            val username = etUsername?.text.toString()
            val pssword = etPassword?.text.toString()

            val user = User(username, pssword)
            for (userArray in array) {
                if (userArray.email == user.email &&
                    userArray.password == user.password &&
                    checkBox?.isChecked == true){
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this, "Welcome ${user.email}", Toast.LENGTH_SHORT).show()
                    break
                }else{
                    Toast.makeText(this, "Check your date", Toast.LENGTH_SHORT).show()
                }
            }
        }


//        btnLogin?.setOnClickListener {
//            if(etUsername?.text?.isEmpty() == true
//                || etPassword?.text?.isEmpty() == true
//                || checkBox?.isChecked != true){
//                Toast.makeText(this, "Enter your date", Toast.LENGTH_SHORT).show()
//            } else{
//                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
//
//            }
//        }

    }


}