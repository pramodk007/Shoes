package com.androiddev.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androiddev.shoes.R
import com.androiddev.startingScreen.IntroScreen
import kotlinx.coroutines.*
import com.airbnb.lottie.LottieAnimationView

class SplashScreen : AppCompatActivity() {

    val activityScope = CoroutineScope(Dispatchers.Main)
    var lottieAnimationView: LottieAnimationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        lottieAnimationView = findViewById(R.id.lottieAnimationView);

        activityScope.launch {
            delay(3000)
            var intent = Intent(this@SplashScreen, IntroScreen::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onPause() {
        activityScope.cancel()
        super.onPause()
    }
}