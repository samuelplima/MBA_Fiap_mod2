package com.fiap.vivo.model

import androidx.lifecycle.LiveData

class UserRepository(private val userDAO: UserDAO) {

    val readAllData: LiveData<List<User>> = userDAO.readAllData()

    fun addUser(user: User) {
        userDAO.addUser(user)
    }

    fun findUser(cpfCnpjDB: String) : String {
        return userDAO.findUser(cpfCnpjDB)
    }

    fun findName(cpfCnpjDB: String) : String {
        return userDAO.findName(cpfCnpjDB)
    }

    fun findEmail(emailDB: String): String{
        return userDAO.findEmail(emailDB)
    }

    fun findPassword(senhaDB: String): String{
        return userDAO.findPassword(senhaDB)
    }

   fun findEmailWithCpfCnpj(cpfCnpjDB: String) : String{
       return userDAO.findEmailWithCpfCnpj(cpfCnpjDB)
   }


}