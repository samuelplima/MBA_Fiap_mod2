package com.fiap.vivo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.fiap.vivo.data.model.User
import com.fiap.vivo.data.db.UserDatabase
import com.fiap.vivo.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: UserRepository

    init {
        val userDAO = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDAO)
    }

    fun readAllData(): List<User> {
        return repository.readAllData()
    }

    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }

    fun findUser(cpfCnpjDB: String) : String {
        return repository.findUser(cpfCnpjDB)
    }

    fun findName(cpfCnpjDB: String) : String {
        return repository.findName(cpfCnpjDB)
    }

    fun findEmail(emailDB: String): String{
        return repository.findEmail(emailDB)
    }

    fun findPassword(senhaDB: String): String{
        return repository.findPassword(senhaDB)
    }

    fun findEmailWithCpfCnpj(cpfCnpjDB: String) : String{
        return repository.findEmailWithCpfCnpj(cpfCnpjDB)
    }

    fun findPlanos(cpfCnpjDB: String) : String{
        return repository.findPlanos(cpfCnpjDB)
    }

    fun findSituacao(cpfCnpjDB: String) : String{
        return repository.findSituacao(cpfCnpjDB)
    }

    fun findTelefone(cpfCnpjDB: String) : String{
        return  repository.findTelefone(cpfCnpjDB)
    }

    fun changePassword(senhaDB: String, cpfCnpjDB: String){
        repository.changePassword(senhaDB, cpfCnpjDB)
    }

    fun populateDB(){
        repository.populateDB()
    }

}

