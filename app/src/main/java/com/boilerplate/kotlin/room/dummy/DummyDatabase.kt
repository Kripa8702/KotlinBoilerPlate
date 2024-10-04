package com.boilerplate.kotlin.room.dummy

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Dummy::class], version = 1)
abstract class DummyDatabase : RoomDatabase(){
    abstract val dummyDao: DummyDao
}