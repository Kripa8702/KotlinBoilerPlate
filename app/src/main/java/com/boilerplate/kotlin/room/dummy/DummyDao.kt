package com.boilerplate.kotlin.room.dummy

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DummyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(dummy: Dummy)

    @Query("SELECT * FROM dummy")
    suspend fun getDummy(): Dummy?

    @Query("DELETE FROM dummy")
    suspend fun clearDummy()
}