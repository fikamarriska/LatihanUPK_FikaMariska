package com.example.latihanupk_fikamariska

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterPersegi (private var dataSet : MutableList<DataPersegi>):
        RecyclerView.Adapter<AdapterPersegi.DataPersegiHolder>(){
    class DataPersegiHolder(view: View) : RecyclerView.ViewHolder(view) {
        val SisiPersegi = view.findViewById<TextView>(R.id.txtLebar)
        val LuasPersegi = view.findViewById<TextView>(R.id.txtLuas)
        val KelilingPersegi = view.findViewById<TextView>(R.id.txtKeliling)
        val Hapus = view.findViewById<ImageView>(R.id.ic_delete)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataPersegiHolder {
       val view = LayoutInflater.from(parent.context).inflate(
           R.layout.activity_adapter_persegi, parent, false
       )
        return DataPersegiHolder(view)
    }

    override fun onBindViewHolder(holder: DataPersegiHolder, position: Int) {
        val data = dataSet[position]
        holder.SisiPersegi.text = dataSet[position].Sisi_Persegi
        holder.LuasPersegi.text = dataSet[position].Luas_Persegi
        holder.KelilingPersegi.text = dataSet[position].Keliling_Persegi
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