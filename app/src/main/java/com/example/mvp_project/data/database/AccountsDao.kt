package com.example.mvp_project.data.database

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

interface AccountsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun registration(entity: AccountEntity)

    @Update
    fun updateAccount(user: AccountEntity)

    @Query("SELECT * FROM AccountEntity")
    fun getAllAccountData(): List<AccountEntity>
}
}