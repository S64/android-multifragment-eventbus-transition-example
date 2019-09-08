package jp.s64.android.example.multifragmenteventbustransition

import android.content.Intent
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onStart() {
        super.onStart()

        Handler().postDelayed(
            {
                startActivity(
                    Intent(this@SplashActivity, MainActivity::class.java)
                )
                finish()
            },
            1000 * 3
        )
    }

}
