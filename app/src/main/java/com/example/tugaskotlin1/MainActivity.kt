package com.example.tugaskotlin1

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LoginView().setContentView(this)

        var btn: Button = findViewById(R.id.btn)
        var uname: EditText = findViewById(R.id.et_username)
        var passwd: EditText = findViewById(R.id.et_password)
        btn.setOnClickListener {
            val username = uname.text.toString().trim()
            val password = passwd.text.toString().trim()
            HandleLogin(username, password)
        }
    }

    private fun HandleLogin(username: String, password: String) {
        if (username.equals("admin") && password.equals("erdin")) {
            info { "Data username : $username, Data password : $password, Status login : Berhasil" }
            startActivity(intentFor<Home>("username" to username))
            finish()
        } else {
            error { "Data username : $username, Data password : $password, Status login : Gagal" }
            alert(title = "Warning", message = "Username atau password salah") {
                positiveButton(buttonText = "Tutup") {
                    //
                }
                isCancelable = false
            }.show()
        }
    }

    class LoginView() : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout {
                lparams {
                    width = matchParent
                    height = matchParent
                    padding = 30
                    margin = 15
                }
                imageView {
                    setImageResource(R.mipmap.android)
                }.lparams(width = matchParent, height = dip(250)) {
                    margin = 15
                }
                textView {
                    id = R.id.tv_username
                    text = "Email"
                    textAlignment = TextView.TEXT_ALIGNMENT_TEXT_START
                    typeface = Typeface.DEFAULT_BOLD
                    visibility = View.VISIBLE
                }.lparams(width = matchParent, height = wrapContent) {
                    margin = 15
                    bottomMargin = 0
                }
                editText {
                    id = R.id.et_username
                    hint = "Username"
                    inputType = InputType.TYPE_CLASS_TEXT
                    visibility = View.VISIBLE
                }.lparams(width = matchParent, height = wrapContent) {
                    topMargin = 0
                    margin = 15
                }
                textView {
                    id = R.id.tv_password
                    text = "Password"
                    textAlignment = TextView.TEXT_ALIGNMENT_TEXT_START
                    typeface = Typeface.DEFAULT_BOLD
                    visibility = View.VISIBLE
                }.lparams(width = matchParent, height = wrapContent) {
                    margin = 15
                    bottomMargin = 0
                }
                editText {
                    id = R.id.et_password
                    hint = "Password"
                    inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                    visibility = View.VISIBLE
                }.lparams(width = matchParent, height = wrapContent) {
                    topMargin = 0
                    margin = 15
                }
                button("LOGIN") {
                    id = R.id.btn
                    backgroundColor = Color.BLUE
                    textColor = Color.WHITE
                }.lparams(width = matchParent, height = wrapContent) {
                    margin = 15
                    gravity = Gravity.CENTER
                }
            }
        }

    }
}
