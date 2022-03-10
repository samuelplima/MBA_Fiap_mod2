package com.fiap.vivo.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(

    @ColumnInfo(name = "ID")
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "NAME")
    val name: String,

    @ColumnInfo(name = "CPFCNPJ")
    val cpfCnpj: String,

    @ColumnInfo(name = "TELEFONE")
    val telefone: String,

    @ColumnInfo(name = "EMAIL")
    val email: String,

    @ColumnInfo(name = "PLANOS")
    val planos: String,

    @ColumnInfo(name = "SITUACAO")
    val situacao: String,

    @ColumnInfo(name = "SENHA")
    val senha: String


)





