package com.fiap.vivo.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fiap.vivo.local.model.User

@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(user : User)

    @Query("SELECT * FROM user_table ORDER BY id")
    fun readAllData(): List<User>

    @Query("SELECT cpfCnpj FROM user_table WHERE cpfCnpj =:cpfCnpjDB")
    fun findUser(cpfCnpjDB : String ) : String

    @Query("SELECT name FROM user_table WHERE cpfCnpj =:cpfCnpjDB")
    fun findName(cpfCnpjDB : String ) : String

    @Query("SELECT email FROM user_table where email =:emailDB")
    fun findEmail(emailDB: String) : String

    @Query("SELECT senha FROM user_table where senha =:senhaDB")
    fun findPassword(senhaDB: String) : String

    @Query("SELECT email FROM user_table where cpfCnpj =:cpfCnpjDB")
    fun findEmailWithCpfCnpj(cpfCnpjDB: String) : String

    @Query("SELECT planos FROM user_table where cpfCnpj =:cpfCnpjDB")
    fun findPlanos(cpfCnpjDB: String) : String

    @Query("SELECT situacao FROM user_table where cpfCnpj =:cpfCnpjDB")
    fun findSituacao(cpfCnpjDB: String) : String

    /*para fins de testes da aplicação
    *irá popular o banco no primeiro uso para testes dos usuarios ja cadastrados
    */
    @Query("INSERT INTO user_table (name, cpfCnpj, email, planos, situacao, senha) " +
                 "VALUES " +
                 "  (\"Brock Reed\",\"44.444.444/4444-44\",\"nonummy@protonmail.ca\",\"Internet\",\"ativo\",\"JQA88GTF6LB\"), " +
                 "  (\"Raphael Mcgee\",\"75.755.746/0001-04\",\"id.risus@google.org\",\"Telefone\",\"inativo\",\"QIQ88JCO6NC\"), " +
                 "  (\"Chava Mcclure\",\"14.277.157/0001-73\",\"nunc.risus.varius@yahoo.com\",\"Combo\",\"ativo\",\"HWO98GUR9WJ\"), " +
                 "  (\"Regina Bright\",\"54.186.204/0001-98\",\"felis.eget@google.org\",\"Internet\",\"inativo\",\"TBR84NRN4LJ\"), " +
                 "  (\"Darrel Dawson\",\"26.385.632/0001-04\",\"cras.dolor.dolor@yahoo.org\",\"Telefone\",\"ativo\",\"ISL66WIZ2PY\"), " +
                 "  (\"Dylan Kane\",\"332.594.723-98\",\"lacus.nulla.tincidunt@aol.edu\",\"Combo\",\"inativo\",\"UFU63HYS5OB\"), " +
                 "  (\"Wylie Mullins\",\"243.474.303-02\",\"suspendisse.sed.dolor@icloud.com\",\"Telefone\",\"ativo\",\"CKS80RHW4UC\"), " +
                 "  (\"Lawrence Kelley\",\"068.560.871-95\",\"sed.sapien@outlook.org\",\"Combo\",\"inativo\",\"ILN13EOO2JM\"), " +
                 "  (\"Jessica Hobbs\",\"615.332.336-75\",\"gravida.praesent@outlook.couk\",\"Internet\",\"ativo\",\"SEK48ZDW3TV\")," +
                 "  (\"Aimee Swanson\",\"534.460.541-20\",\"magna@google.org\",\"Combo\",\"inativo\",\"LMO68IXP3SD\")",
    )
    fun populateDB()



}

