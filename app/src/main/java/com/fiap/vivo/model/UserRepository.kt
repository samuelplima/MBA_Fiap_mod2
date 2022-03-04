package com.fiap.vivo.model



class UserRepository(private val userDAO: UserDAO) {

    fun readAllData(): List<User> = userDAO.readAllData()

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

    fun findPlanos(cpfCnpjDB: String) : String{
        return userDAO.findPlanos(cpfCnpjDB)
    }

    fun findSituacao(cpfCnpjDB: String) : String{
        return userDAO.findSituacao(cpfCnpjDB)
    }

    fun populateDB(){
        userDAO.populateDB()
    }

}