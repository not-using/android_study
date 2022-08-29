package edu.seoul42.doitmission08

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        fun <T> setActivityResult (activityClass:Class<T>) {
            val intent = Intent(applicationContext, activityClass)
            startActivityForResult(intent, 101)
        }

        val customerButton = findViewById<Button>(R.id.customerButton)
        customerButton.setOnClickListener { setActivityResult(CustomerActivity::class.java)}
        val salesButton = findViewById<Button>(R.id.salesButton)
        salesButton.setOnClickListener { setActivityResult(SalesActivity::class.java) }
        val productButton = findViewById<Button>(R.id.productButton)
        productButton.setOnClickListener { setActivityResult(ProductActivity::class.java) }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK) {
            val departure = data?.getStringExtra("from")
            val destination = data?.getStringExtra("to")
            val login = getString(R.string.menu_login)
            if (destination == login) {
                val intent = Intent()
                intent.putExtra("to", destination)
                intent.putExtra("from", departure)
                setResult(RESULT_OK, intent)
                finish()
            } else {
                Toast.makeText(applicationContext, "$departure -> $destination", Toast.LENGTH_SHORT).show()
            }
        }
    }
}