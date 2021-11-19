package com.sorabh.loginuiapp.startactivity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sorabh.loginuiapp.R
import com.sorabh.loginuiapp.adapter.RecycleViewAdapter
import com.sorabh.loginuiapp.util.CryptoCoin

class DashboardActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        recyclerView = findViewById(R.id.recycleView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        val adapter = RecycleViewAdapter(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        val list = makeList()
        adapter.updateList(list)
    }

    private fun makeList(): List<CryptoCoin> {
        val list = ArrayList<CryptoCoin>()
        val coin1 = CryptoCoin(R.drawable.bitcoin, "Bitcoin", "$45555", "4")
        val coin2 = CryptoCoin(R.drawable.ethereum, "Ethereum", "$8755", "9")
        val coin3 = CryptoCoin(R.drawable.binance, "Binance", "$55", "41")
        val coin4 = CryptoCoin(R.drawable.cardino, "Cardino", "$5", "7")
        val coin5 = CryptoCoin(R.drawable.solan, "Solana", "$67", "9")
        val coin6 = CryptoCoin(R.drawable.tegther, "Tegther", "$95", "48")
        list.add(coin1)
        list.add(coin2)
        list.add(coin3)
        list.add(coin4)
        list.add(coin5)
        list.add(coin6)

        return list
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        MenuInflater(this).inflate(R.menu.app_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.log_out -> {
                val sharedPreferences = getSharedPreferences("login", MODE_PRIVATE)
                sharedPreferences.edit().putBoolean("isActive", false).apply()
                sharedPreferences.edit().commit()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }

            R.id.news->{
                Toast.makeText(this,"Loading News..........",Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}