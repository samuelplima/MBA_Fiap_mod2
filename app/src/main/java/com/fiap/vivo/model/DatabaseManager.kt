package com.example.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.fiap.vivo.view.FirstFragment

class DatabaseManager(Fragment: FirstFragment, name: String?) : SQLiteOpenHelper(Fragment.requireContext(), name, null, 1) {

    override fun onCreate(p0: SQLiteDatabase?) {

        p0?.execSQL(
            "CREATE TABLE BANCO(" +
                    " ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " NOME VARCHAR(50), " +
                    " CPF_CNPJ VARCHAR(50) " +
                    " );"
        )
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE IF EXISTS USERS")

        p0?.execSQL(
            "CREATE TABLE BANCO(" +
                    " ID INT PRIMARY KEY AUTOINCREMENT, " +
                    " NOME VARCHAR(50), " +
                    " CPF_CNPJ VARCHAR(50) " +
                    " );"
        )
    }

    fun insereUser(nome: String, cpf_cnpj: String) {
        var db = this.writableDatabase

        var cv = ContentValues()

        cv.put("NOME", nome)
        cv.put("CPF_CNPJ", cpf_cnpj)

        db.insert("BANCO", "ID", cv)
    }

    fun listaUsers(): Cursor {

        var db = this.readableDatabase
        var cur = db.rawQuery("select nome,cpf_cnpj from BANCO", null)
        return cur
    }

    fun findUser(cpfCnpj: String): Cursor {

        var db = this.readableDatabase
        var cur = db.rawQuery("select nome,cpf_cnpj from BANCO where cpf_cnpj = '$cpfCnpj'", null)
        return cur
    }

    fun removeUser() {
        var db = this.writableDatabase
        db.delete("BANCO", "ID=1", null)
    }

}
