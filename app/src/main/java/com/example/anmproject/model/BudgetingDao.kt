package com.example.anmproject.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface BudgetingDao {
    @Dao
    interface BudgetingDao {
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        fun insertAll(vararg budgeting: Budgeting)

        @Query("SELECT * FROM budgeting")
        fun selectAllBudgeting(): List<Budgeting>

        @Query("SELECT * FROM budgeting WHERE uuid= :id")
        fun selectBudgeting(id:Int): Budgeting

        @Delete
        fun deleteBudgeting(budgeting:Budgeting)
    }
}