package com.example.data.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class JobsDataBase: RoomDatabase() {
    abstract fun jobsDao(): JobsDao

    companion object{
        fun createDataBase(context: Context) : JobsDao {
            return Room
                .databaseBuilder(context, JobsDataBase::class.java, "Jobs.db")
                .build()
                .jobsDao()
        }
    }
}