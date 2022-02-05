package com.fiap.vivo.model

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseManager(context: Context, name: String?) : SQLiteOpenHelper(context,name,null,1)  {


    override fun onCreate(p0: SQLiteDatabase?) {

        p0?.execSQL("CREATE TABLE USERS " +
                "(ID INT NOT NULL, " +
                "CPF VARCHAR(20), " +
                "CNPJ VARCHAR(20), " +
                "PRIMARY KEY (ID));")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE IF EXISTS USERS")

        p0?.execSQL("CREATE TABLE USERS " +
                "(ID INT NOT NULL, " +
                "CPF VARCHAR(20), " +
                "CNPJ VARCHAR(20), " +
                "PRIMARY KEY (ID));")
    }

    fun insereUser(id: Int, cpf: String, cnpj: String){
        var db = this.writableDatabase

        var cv = ContentValues()

        cv.put("ID",id)
        cv.put("CPF", cpf)
        cv.put("CNPJ", cnpj)

        db.insert("USERS","ID",cv)
    }

    fun listaUsers(): Cursor {

        var db = this.readableDatabase
        var cur = db.rawQuery("select id,cpf, cnpj from users",null)
        return cur
    }

    fun removeUser(){
        var db = this.writableDatabase
        db.delete("USERS","ID=1",null)
    }
}