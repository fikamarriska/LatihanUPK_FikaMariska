package com.example.latihanupk_fikamariska

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterPersegiPanjang (private var dataSet : MutableList<DataPersegiPanjang>):
    RecyclerView.Adapter<AdapterPersegiPanjang.DataPersegiPanjangHolder>() {
    class DataPersegiPanjangHolder(view: View) : RecyclerView.ViewHolder(view) {
        val LebarPP = view.findViewById<TextView>(R.id.txtLebar)
        val PanjangPP = view.findViewById<TextView>(R.id.txtPanjang)
        val LuasPP = view.findViewById<TextView>(R.id.txtLuas)
        val KelilingPP = view.findViewById<TextView>(R.id.txtKeliling)
        val Hapus = view.findViewById<ImageView>(R.id.ic_delete)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataPersegiPanjangHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.activity_adapter_persegi_panjang, parent, false
        )
        return DataPersegiPanjangHolder(view)
    }

    override fun onBindViewHolder(holder: DataPersegiPanjangHolder, position: Int) {
        val data = dataSet[position]
        holder.PanjangPP.text = dataSet[position].Panjang_PersegiPanjang
        holder.LebarPP.text = dataSet[position].Lebar_PersegiPanjang
        holder.LuasPP.text = dataSet[position].Luas_PersegiPanjang
        holder.KelilingPP.text = dataSet[position].Keliling_PersegiPanjang
        holder.Hapus.setOnClickListener{
            dataSet.removeAt(position)
            notifyItemRangeRemoved(position, dataSet.size)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}