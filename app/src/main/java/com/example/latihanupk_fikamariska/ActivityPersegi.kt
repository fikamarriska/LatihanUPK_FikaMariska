package com.example.latihanupk_fikamariska

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ActivityPersegi : AppCompatActivity() {

    private var HasilLuas = 0
    private var HasilKeliling = 0
    private lateinit var recyclerView : RecyclerView
    private lateinit var recyclerAdapter : RecyclerView.Adapter<*>
    private lateinit var viewManager : RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persegi)

        val Sisi = findViewById<EditText>(R.id.etPanjang)
        val Luas = findViewById<TextView>(R.id.hsLuas)
        val Keliling = findViewById<TextView>(R.id.hsKeliling)
        val Simpan = findViewById<CheckBox>(R.id.CbSimpan)
        val Hitung = findViewById<Button>(R.id.btnHitung)
        val Reset = findViewById<Button>(R.id.btnReset)
        recyclerView = findViewById(R.id.ListData)

        val data = mutableListOf<DataPersegi>()
        viewManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerAdapter = AdapterPersegi(data)
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = viewManager

        fun menghitung(){

            if (Sisi.getText().toString().isEmpty()){
                val text = "Sisi tidak boleh kosong"
                val duration = Toast.LENGTH_SHORT

                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
            } else {
                val sis = Sisi.text.toString().toInt()

            HasilLuas = (sis) * (sis)
            Luas.setText(HasilLuas.toString())

            HasilKeliling = 4 * (sis)
            Keliling.setText(HasilKeliling.toString())
            }
        }

        fun recycler(){
            val sisiiPersegi = Sisi.text.toString()
            val LuassPersegi = Luas.text.toString()
            val KelilingPersegi = Keliling.text.toString()

            val dataPer = DataPersegi(sisiiPersegi, LuassPersegi, KelilingPersegi)
            data.add(dataPer)
            recyclerAdapter.notifyDataSetChanged()
        }

        Hitung.setOnClickListener {
            if (Simpan.isChecked){
                menghitung()
                recycler()
            } else{
                menghitung()
            }
        }

        Reset.setOnClickListener {
            Sisi.text.clear()
            Luas.text = 0.toString()
            Keliling.text = 0.toString()
        }

    }
}