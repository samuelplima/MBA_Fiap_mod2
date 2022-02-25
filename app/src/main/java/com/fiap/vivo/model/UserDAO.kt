package com.fiap.vivo.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(user : User)

    @Query("SELECT * FROM user_table ORDER BY id")
    fun readAllData(): LiveData<List<User>>

    @Query("SELECT cpfCnpj FROM user_table WHERE cpfCnpj =:cpfCnpjDB")
    fun findUser(cpfCnpjDB : String ) : String

    @Query("SELECT name FROM user_table WHERE cpfCnpj =:cpfCnpjDB")
    fun findName(cpfCnpjDB : String ) : String




}

