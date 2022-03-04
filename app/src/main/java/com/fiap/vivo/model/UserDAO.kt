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

    @Query(
        " INSERT INTO user_table (name,cpfCnpj,email,planos,situacao,senha) " +
                "VALUES " +
                "  (\"Brock Reed\",\"\",\"nonummy@protonmail.ca\",\"Empresarial\",\"Neque Vitae Corporation\",\"JQA88GTF6LB\"), " +
                "  (\"Raphael Mcgee\",\"\",\"id.risus@google.org\",\"Empresarial\",\"Dui Semper Corporation\",\"QIQ88JCO6NC\"), " +
                "  (\"Chava Mcclure\",\"\",\"nunc.risus.varius@yahoo.com\",\"Empresarial\",\"Nulla Vulputate Company\",\"HWO98GUR9WJ\"), " +
                "  (\"Regina Bright\",\"\",\"felis.eget@google.org\",\"Empresarial\",\"Nulla LLP\",\"TBR84NRN4LJ\"), " +
                "  (\"Darrel Dawson\",\"\",\"cras.dolor.dolor@yahoo.org\",\"Empresarial\",\"Luctus Curabitur Ltd\",\"ISL66WIZ2PY\"), " +
                "  (\"Dylan Kane\",\"\",\"lacus.nulla.tincidunt@aol.edu\",\"Pessoal\",\"Elit Sed LLC\",\"UFU63HYS5OB\"), " +
                "  (\"Wylie Mullins\",\"\",\"suspendisse.sed.dolor@icloud.com\",\"Pessoal\",\"Vitae Industries\",\"CKS80RHW4UC\"), " +
                "  (\"Lawrence Kelley\",\"\",\"sed.sapien@outlook.org\",\"Pessoal\",\"Sit Associates\",\"ILN13EOO2JM\"), " +
                "  (\"Jessica Hobbs\",\"\",\"gravida.praesent@outlook.couk\",\"Pessoal\",\"Sed Neque Sed Company\",\"SEK48ZDW3TV\")," +
                "  (\"Aimee Swanson\",\"\",\"magna@google.org\",\"Pessoal\",\"Nonummy Ac Feugiat LLC\",\"LMO68IXP3SD\")",
    )
    fun populateDB()

}

