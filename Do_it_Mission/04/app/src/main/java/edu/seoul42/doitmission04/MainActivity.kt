package edu.seoul42.doitmission04

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var byteCountTextView = findViewById<TextView>(R.id.byteCount)
        var editTextView = findViewById<EditText>(R.id.textArea)
        editTextView.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                byteCountTextView.text = "0 / 80 바이트"
            }
            override fun afterTextChanged(s: Editable) {
                byteCountTextView.text = "${s.length} / 80 바이트"
            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                byteCountTextView.text = "${s.length} / 80 바이트"

            }
        })

        var sendButton = findViewById<Button>(R.id.sendButton)
        sendButton.setOnClickListener {
            val toast = Toast(sendButton.context)
            toast.setText(editTextView.text.toString())
            toast.show()
        }
    }

    fun onChangeText () {

    }

}