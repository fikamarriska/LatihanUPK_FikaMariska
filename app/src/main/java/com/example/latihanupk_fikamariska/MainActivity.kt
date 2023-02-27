package com.example.latihanupk_fikamariska

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun Persegi (view: View){
        val pindah = Intent(this, ActivityPersegi::class.java)
        startActivity(pindah)
    }

    fun Persegipanjang (view: View){
        val pindah = Intent(this, ActivityPersegiPanjang::class.java)
        startActivity(pindah)
    }
}