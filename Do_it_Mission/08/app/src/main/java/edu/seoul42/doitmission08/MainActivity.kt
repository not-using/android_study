package edu.seoul42.doitmission08

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var idInputBox : EditText
    lateinit var passwordInputBox : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginButton = findViewById<Button>(R.id.loginButton)
        idInputBox = findViewById<EditText>(R.id.idInputBox)
        passwordInputBox = findViewById<EditText>(R.id.passwordInputBox)

        loginButton.setOnClickListener {
            if (idInputBox.length() > 0 && passwordInputBox.length() > 0) {
                var newIntent = Intent(applicationContext, MenuActivity::class.java)
                startActivityForResult(newIntent, 101)
            } else {
                Toast.makeText(applicationContext, getString(R.string.message_not_enough), Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK) {
            val departure = data?.getStringExtra("from")
            val destination = getString(R.string.menu_login)
            Toast.makeText(applicationContext, "$departure -> $destination", Toast.LENGTH_SHORT).show()
        }
    }

}
