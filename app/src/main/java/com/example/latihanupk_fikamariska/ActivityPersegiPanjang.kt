package com.example.latihanupk_fikamariska

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ActivityPersegiPanjang : AppCompatActivity() {

    private var HasilLuas = 0
    private var HasilKeliling = 0
    private lateinit var recyclerView : RecyclerView
    private lateinit var recyclerAdapter : RecyclerView.Adapter<*>
    private lateinit var viewManager : RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persegi_panjang)

        val Panjang = findViewById<EditText>(R.id.etPanjang)
        val Lebar = findViewById<EditText>(R.id.etLebar)
        val Luas = findViewById<TextView>(R.id.hsLuas)
        val Keliling = findViewById<TextView>(R.id.hsKeliling)
        val Simpan = findViewById<CheckBox>(R.id.CbSimpan)
        val Hitung = findViewById<Button>(R.id.btnHitung)
        val Reset = findViewById<Button>(R.id.btnReset)
        recyclerView = findViewById(R.id.ListData)

        val data = mutableListOf<DataPersegiPanjang>()
        viewManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerAdapter = AdapterPersegiPanjang(data)
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = viewManager

        fun menghitung(){
            if (Panjang.getText().toString().isEmpty()){
                val text = "Panjang tidak boleh kosong"
                val duration = Toast.LENGTH_SHORT

                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
            } else if (Lebar.getText().toString().isEmpty()){
                val text = "Lebar tidak boleh kosong"
                val duration = Toast.LENGTH_SHORT

                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
            } else {
                val pan = Panjang.text.toString().toInt()
                val leb = Lebar.text.toString().toInt()

                HasilLuas = (pan) * (leb)
                Luas.setText(HasilLuas.toString())

                HasilKeliling = 2 * (pan + leb)
                Keliling.setText(HasilKeliling.toString())
            }
        }

        fun recycler(){
            val PanjangPP = Panjang.text.toString()
            val LebarPP = Lebar.text.toString()
            val LuassPP = Luas.text.toString()
            val KelilingPP = Keliling.text.toString()

            val dataPerPa = DataPersegiPanjang (PanjangPP, LebarPP, LuassPP, KelilingPP)
            data.add(dataPerPa)
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
            Panjang.text.clear()
            Lebar.text.clear()
            Luas.text = 0.toString()
            Keliling.text = 0.toString()
        }

    }
}