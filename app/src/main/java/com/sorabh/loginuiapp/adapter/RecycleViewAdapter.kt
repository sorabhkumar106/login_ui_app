package com.sorabh.loginuiapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sorabh.loginuiapp.R
import com.sorabh.loginuiapp.util.CryptoCoin

class RecycleViewAdapter(val context: Context) : RecyclerView.Adapter<DataViewHolder>() {
    private val cryptoList = ArrayList<CryptoCoin>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycleview_layout, parent, false)

        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val price = "$. " + cryptoList[position].cryptoPrice.toString()
        val quantity = "Qn. " + cryptoList[position].cryptoQuantity.toString()

        holder.cryptoName.text = cryptoList[position].cryptoName
        holder.cryptoPrice.text = price
        holder.cryptoQuantity.text = quantity
        holder.imageView.setImageResource(cryptoList[position].cryptoImage)
    }

    override fun getItemCount(): Int {
        return cryptoList.size
    }

     fun updateList(list: List<CryptoCoin>) {
        cryptoList.clear()
        cryptoList.addAll(list)
        notifyDataSetChanged()
    }
}

class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imageView: ImageView = itemView.findViewById(R.id.img_recycleView_logo)
    val cryptoName: TextView = itemView.findViewById(R.id.txt_recycleView_crypto_name)
    val cryptoPrice: TextView = itemView.findViewById(R.id.txt_recycleView_crypto_price)
    val cryptoQuantity: TextView = itemView.findViewById(R.id.txt_recycleView_crypto_quantity)
}