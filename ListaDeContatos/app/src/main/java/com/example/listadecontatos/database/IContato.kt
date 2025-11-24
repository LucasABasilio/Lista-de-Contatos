package com.example.listadecontatos.database

import com.example.listadecontatos.model.Contato

interface IContato {
    fun inserir(contato : Contato) : Boolean
    fun atualizar(contato : Contato) : Boolean
    fun deletar(id : Int) : Boolean
    fun listar() : List<Contato>
}