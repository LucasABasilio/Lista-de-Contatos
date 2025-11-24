package com.example.listadecontatos.database

import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.example.listadecontatos.model.Contato

class ContatoDAO(context : Context) : IContato{

    val write = ContatoDatabaseHelper(context).writableDatabase
    val read = ContatoDatabaseHelper(context).readableDatabase

    override fun inserir(contato: Contato): Boolean {
        val values = ContentValues()
        values.put("nome", contato.nome)
        values.put("email", contato.email)
        values.put("telefone", contato.telefone)
        try {
            write.insert("Contatos", null, values)
            Log.i("info_db", "Registro Inserido com Sucesso!")
        }catch (e : Exception){
            Log.i("info_db", "Erro ao Inserir registro!")
            return false
        }
        return true
    }

    override fun atualizar(contato: Contato): Boolean {
        TODO("Not yet implemented")
    }

    override fun deletar(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun listar(): List<Contato> {
        val listaContatos = mutableListOf<Contato>()
        val sql = "SELECT * FROM contatos"
        val cursor = read.rawQuery(sql, null)

        while(cursor.moveToNext()){
            val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
            val nome = cursor.getString(cursor.getColumnIndexOrThrow("nome"))
            val email = cursor.getString(cursor.getColumnIndexOrThrow("email"))
            val telefone = cursor.getString(cursor.getColumnIndexOrThrow("telefone"))

            val contato = Contato(id, nome, email, telefone)
            listaContatos.add(contato)
        }

        return listaContatos
    }

}