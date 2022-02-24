package com.fiap.vivo.model

import androidx.lifecycle.LiveData
import kotlinx.coroutines.newFixedThreadPoolContext

class UserRepository(private val userDAO: UserDAO) {

    val readAllData: LiveData<List<User>> = userDAO.readAllData()

    fun addUser(user: User) {
        userDAO.addUser(user)
    }

    fun findUser(cpfCnpjDB: String) : String {
        return userDAO.findUser(cpfCnpjDB)
    }
}