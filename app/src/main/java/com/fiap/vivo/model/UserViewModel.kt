package com.fiap.vivo.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val readAllData: LiveData<List<User>>
    private val repository: UserRepository

    init {
        val userDAO = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDAO)
        readAllData = repository.readAllData
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

}

