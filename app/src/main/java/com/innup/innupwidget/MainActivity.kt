package com.innup.innupwidget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.innup.widget.titlebar.TitleBarView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TitleBarView>(R.id.title_bar).setLeftTextOnClickListener {
            finish()
        }
    }
}