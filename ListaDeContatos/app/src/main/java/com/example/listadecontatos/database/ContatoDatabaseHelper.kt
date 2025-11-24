package com.example.listadecontatos.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class ContatoDatabaseHelper(context : Context) : SQLiteOpenHelper(
    context,
    "contatos",
    null,
    1
) {
    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "CREATE TABLE IF NOT EXISTS Contatos(\n" +
                "  id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "  nome VARCHAR(100) NOT NULL,\n" +
                "  email VARCHAR(100) NOT NULL,\n" +
                "  telefone VARCHAR(100) NOT NULL \n" +
                ");\n"

        try {
            db?.execSQL(sql)
            Log.i("info_db", "Banco Criado com Sucesso!")
        }catch (e : Exception){
            Log.i("info_db", "Erro ao Criar o Banco!")
        }
    }

    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {
        TODO("Not yet implemented")
    }
}