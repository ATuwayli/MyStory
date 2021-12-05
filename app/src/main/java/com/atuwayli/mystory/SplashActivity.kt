package com.atuwayli.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import java.util.logging.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        moveToLoginScreen()
    }

    private fun moveToLoginScreen() {
        android.os.Handler().postDelayed(
            {
                startActivity(Intent(this,LoginActivity::class.java))
                finish()
            }, 3000)
    }
}