package edu.seoul42.doitmission07

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val getResult =
//            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//                if (result.resultCode == Activity.RESULT_OK) {
//                    val type = result.data?.getStringExtra("type") ?: ""
//                    Toast.makeText(applicationContext, type + getString(R.string.message_selected), Toast.LENGTH_LONG).show()
//                }
//            }

        var button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            var intent = Intent(applicationContext, MenuActivity::class.java)
//            getResult.launch(intent)
            startActivityForResult(intent, 201)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 201 && resultCode == RESULT_OK) {
            var type = data?.getStringExtra("type") ?: ""
            Toast.makeText(applicationContext, type + getString(R.string.message_selected), Toast.LENGTH_LONG).show()

        }
    }
}