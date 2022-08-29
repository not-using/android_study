package edu.seoul42.doitmission07

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        fun setButtonListener (buttonTypeStringId: Int) {
            val intent = Intent()
            val buttonType = getString(buttonTypeStringId)
            intent.putExtra("type", buttonType)
            setResult(RESULT_OK, intent)
            finish()

        }

        var customerButton = findViewById<Button>(R.id.customerButton)
        customerButton.setOnClickListener {
            setButtonListener(R.string.menu_customer)
        }

        var salesButton = findViewById<Button>(R.id.salesButton)
        salesButton.setOnClickListener {
            setButtonListener(R.string.menu_sales)
        }

        var productButton = findViewById<Button>(R.id.productButton)
        productButton.setOnClickListener {
            setButtonListener(R.string.menu_product)
        }

    }
}