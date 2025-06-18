package com.example.anmproject.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Expenses::class), version =  1)
abstract class ExpensesDatabase:RoomDatabase() {
    abstract fun expensesDao(): ExpensesDao

    companion object {
        @Volatile private var instance: ExpensesDatabase ?= null
        private val LOCK = Any()

        fun buildDatabase(context:Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ExpensesDatabase::class.java,
                "newexpensesdb").build()

        operator fun invoke(context:Context) {
            if(instance == null) {
                synchronized(LOCK) {
                    instance ?: buildDatabase(context).also {
                        instance = it
                    }
                }
            }
        }

    }
}