package com.androiddev.startingScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.androiddev.shoes.R

class IntroScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro_screen)
        val signIn:Button = findViewById(R.id.btn_sign_in)
        val signUp:Button = findViewById(R.id.btn_sign_up)
        signIn.setOnClickListener {
            startActivity(Intent(this@IntroScreen,SignInActivity::class.java))
        }
        signUp.setOnClickListener {
            startActivity(Intent(this@IntroScreen,SignUpActivity::class.java))
        }
    }
}