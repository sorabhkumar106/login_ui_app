package com.sorabh.loginuiapp.startactivity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sorabh.loginuiapp.R

class SignUpActivity : AppCompatActivity() {
    lateinit var userName: TextView
    lateinit var userEmail: TextView
    lateinit var userPhone: TextView
    lateinit var userAddress: TextView
    lateinit var userPassword1: TextView
    lateinit var userPassword2: TextView
    lateinit var signup: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        initialize()
        signup.setOnClickListener {
            login()

        }
    }

    private fun login() {
        val sharedPreferences = getSharedPreferences("login", MODE_PRIVATE)
        if (userName.text.isNotBlank() && userPhone.text.isNotBlank() && userEmail.text.isNotBlank()
            && userAddress.text.isNotBlank() && userPassword1.text.isNotBlank() && userPassword2.text.isNotBlank()
        ) {
            if (userPassword1.text.toString() == userPassword2.text.toString()) {
                sharedPreferences.edit().putString("userName", userName.text.toString()).apply()
                sharedPreferences.edit().putString("userEmail", userEmail.text.toString()).apply()
                sharedPreferences.edit().putString("userPhone", userPhone.text.toString()).apply()
                sharedPreferences.edit().putString("userAddress", userAddress.text.toString()).apply()
                sharedPreferences.edit().putString("userPassword", userPassword1.text.toString()).apply()
                sharedPreferences.edit().putBoolean("isActive", false).apply()
                sharedPreferences.edit().commit()
                Log.d("sorabh", "==================")
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()

            } else {
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initialize() {
        userName = findViewById(R.id.username)
        userEmail = findViewById(R.id.email)
        userPhone = findViewById(R.id.phone)
        userAddress = findViewById(R.id.address)
        userPassword1 = findViewById(R.id.password)
        userPassword2 = findViewById(R.id.password2)
        signup = findViewById(R.id.btn_register)
    }
}