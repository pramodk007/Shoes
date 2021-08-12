package com.androiddev.startingScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.androiddev.shoes.R
import com.androiddev.view.ShoesActivity

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        val signIn: Button = findViewById(R.id.signIn_login)
        val signUp: Button = findViewById(R.id.signIn_signUp)
        signIn.setOnClickListener {
            startActivity(Intent(this@SignInActivity, ShoesActivity::class.java))
        }
        signUp.setOnClickListener {
            startActivity(Intent(this@SignInActivity,SignUpActivity::class.java))
        }
    }
}