package com.androiddev.startingScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.androiddev.shoes.R
import com.androiddev.view.ShoesActivity

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val signIn: Button = findViewById(R.id.singUp_signIn)
        val signUp: Button = findViewById(R.id.singUp_signUp)
        signIn.setOnClickListener {
            startActivity(Intent(this@SignUpActivity, SignInActivity::class.java))
        }
        signUp.setOnClickListener {
            startActivity(Intent(this@SignUpActivity,ShoesActivity::class.java))
        }
    }
}