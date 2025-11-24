package com.example.listadecontatos.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.listadecontatos.R
import com.example.listadecontatos.database.ContatoDAO
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var btnAddContact : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        btnAddContact = findViewById(R.id.fab_add_contact)
        btnAddContact.setOnClickListener {
            val intent = Intent(this, ActivityFormContato::class.java)
            startActivity(intent)
        }
    }

    override fun onStart(){
        super.onStart()

        val listaDeContatos = ContatoDAO(this).listar()
        listaDeContatos.forEach {
            Log.i("info_db", "id: ${it.id} - nome: ${it.nome} - email: ${it.email} - telefeno: ${it.telefone}")
        }
    }
}