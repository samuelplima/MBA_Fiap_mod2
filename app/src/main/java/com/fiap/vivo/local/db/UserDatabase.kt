package com.fiap.vivo.local.db

import android.content.Context
import android.provider.Telephony
import android.telephony.SmsManager
import android.widget.Toast
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fiap.vivo.local.model.User

@Database(entities = [User::class], version = 2, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {

        abstract fun userDao() : UserDAO

        companion object{
            @Volatile
            private var INSTANCE: UserDatabase?= null

            fun getDatabase(context : Context): UserDatabase {
                val tempInstance = INSTANCE
                if(tempInstance!=null) {
                    return tempInstance
                }
                synchronized(this){
                    val instance = Room.databaseBuilder(context.applicationContext,
                        UserDatabase::class.java, "user_database")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                    INSTANCE = instance
                    return  instance
                }
            }
        }2017710508
}