package edu.seoul42.doitmission03

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ScrollView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var imageView : ImageView = findViewById(R.id.imageView1)
        var image = getDrawable(R.drawable.x9791163032625);
        val imgWidth : Int = image?.intrinsicWidth ?: 500
        val imgHeight : Int = image?.intrinsicHeight ?: 500

        imageView.setImageDrawable(image)
        imageView.layoutParams.width = imgWidth
        imageView.layoutParams.height = imgHeight

    }

    fun onButtonClicked(view : View) {
        switchImage()
    }

    private fun switchImage() {

        var imageView1 : ImageView = findViewById(R.id.imageView1)
        var imageView2 : ImageView = findViewById(R.id.imageView2)

        var prevImageView = if (imageView1.drawable != null) imageView1 else imageView2
        var newImageView = if (prevImageView === imageView1) imageView2 else imageView1

        val image = getDrawable(R.drawable.x9791163032625)
        newImageView.setImageDrawable(image)
        newImageView.layoutParams.width = prevImageView.layoutParams.width
        newImageView.layoutParams.height = prevImageView.layoutParams.height

        prevImageView.setImageDrawable(null)
    }
}