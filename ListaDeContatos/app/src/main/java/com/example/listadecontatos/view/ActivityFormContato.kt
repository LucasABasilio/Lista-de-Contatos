package com.example.listadecontatos.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.listadecontatos.R
import com.example.listadecontatos.database.ContatoDAO
import com.example.listadecontatos.model.Contato

class ActivityFormContato : AppCompatActivity() {

    private lateinit var btnSalvar : Button
    private lateinit var btnCancelar : Button
    private lateinit var editNome : EditText
    private lateinit var editEmail : EditText
    private lateinit var editTelefone : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_form_contato)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnSalvar = findViewById(R.id.btnSalvar)
        btnCancelar = findViewById(R.id.btnCancelar)
        editNome = findViewById(R.id.editNome)
        editEmail = findViewById(R.id.editEmail)
        editTelefone = findViewById(R.id.editTelefone)

        btnSalvar.setOnClickListener {
            if (editNome.text.toString().isNotEmpty() && editEmail.text.toString().isNotEmpty() && editTelefone.text.toString().isNotEmpty()){
                val novoContato = Contato(-1, editNome.text.toString(),editEmail.text.toString(), editTelefone.text.toString())
                val contatoDAO = ContatoDAO(this)
                if(contatoDAO.inserir(novoContato)){
                    Toast.makeText(this, "Contato Inserido Com Sucesso!", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }

        btnCancelar.setOnClickListener{
            finish()
        }

    }
}