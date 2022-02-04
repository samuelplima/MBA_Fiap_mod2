package com.fiap.vivo.model

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class DatabaseManager {

/*exemplo:
    fun onCreate(p0: SQLiteDatabase?) {

            p0?.execSQL("CREATE TABLE SAUDACAO(\n" +
                    "\tID_SAUDACAO INT NOT NULL,\n" +
                    "\tNOME VARCHAR(20),\n" +
                    "\tTRATAMENTO VARCHAR(20),\n" +
                    "\tPRIMARY KEY (ID_SAUDACAO)\n" +
                    "\t);")
        }

        fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
            p0?.execSQL("DROP TABLE IF EXISTS SAUDACAO")

            p0?.execSQL("CREATE TABLE SAUDACAO(\n" +
                    "\tID_SAUDACAO INT NOT NULL,\n" +
                    "\tNOME VARCHAR(20),\n" +
                    "\tTRATAMENTO VARCHAR(20),\n" +
                    "\tPRIMARY KEY (ID_SAUDACAO)\n" +
                    "\t);")
        }

        fun insere(id: Int, nome: String, tratamento: String){
            var db = this.writableDatabase

            var cv = ContentValues()

            cv.put("ID_SAUDACAO",id)
            cv.put("NOME",nome)
            cv.put("TRATAMENTO",tratamento)

            db.insert("SAUDACAO","ID_SAUDACAO",cv)
        }

        fun lista(): Cursor {

            var db = this.readableDatabase
            var cur = db.rawQuery("select nome,tratamento from saudacao",null)
            return cur
        }

        fun removeSaudaca(){
            var db = this.writableDatabase
            db.delete("SAUDACAO","ID_SAUDACAO=1",null)
        }
    }
*/
}