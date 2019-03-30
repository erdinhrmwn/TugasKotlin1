package com.example.tugaskotlin1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import org.jetbrains.anko.toast

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)
        var username = intent.getStringExtra("username")
        var uname: TextView = findViewById(R.id.tv_log)
        toast("Anda berhasil login")
        uname.text = username
    }
}