package com.sorabh.loginuiapp.startactivity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sorabh.loginuiapp.R

class LoginActivity : AppCompatActivity() {
    lateinit var userEmail: TextView
    lateinit var userPhone: TextView
    lateinit var userPassword: TextView
    lateinit var signup: Button
    lateinit var login: Button
    var isActive: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initialize()
        val sharedPreferences = getSharedPreferences("login", MODE_PRIVATE)
        isActive = sharedPreferences.getBoolean("isActive", false)
        if (isActive) {
            Log.d("login","--------------------------")
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
            finish()
        }
        login.setOnClickListener {
            Toast.makeText(this, " Something went wrong!", Toast.LENGTH_SHORT).show()
            val email = sharedPreferences.getString("userEmail", "userEmail")
            val phone = sharedPreferences.getString("userPassword", "userPassword")
            val password = sharedPreferences.getString("userPassword", "UserPassword")

            if (email == userEmail.text.toString() || phone == userPhone.text.toString() && password == userPassword.text.toString()) {
                sharedPreferences.edit().putBoolean("isActive", true).apply()
                sharedPreferences.edit().commit()
                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
            signup.setOnClickListener {
                val intent = Intent(this, SignUpActivity::class.java)
                startActivity(intent)
            }

    }

    private fun initialize() {
        userEmail = findViewById(R.id.emailAdd)
        userPhone = findViewById(R.id.edt_mobile)
        userPassword = findViewById(R.id.edt_password)
        signup = findViewById(R.id.btn_signup)
        login = findViewById(R.id.btn_login)
        isActive = false
    }
}