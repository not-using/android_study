package edu.seoul42.doitmission08

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CustomerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer)

        fun setButtonListener (buttonTypeStringId: Int) {
            val intent = Intent()
            intent.putExtra("to", getString(buttonTypeStringId))
            intent.putExtra("from", getString(R.string.menu_customer))
            setResult(RESULT_OK, intent)
            finish()
        }

        val menuButton = findViewById<Button>(R.id.goToMenuButton)
        menuButton.setOnClickListener { setButtonListener(R.string.menu_main) }

        val loginButton = findViewById<Button>(R.id.goToLoginButton)
        loginButton.setOnClickListener { setButtonListener(R.string.menu_login) }
    }
}