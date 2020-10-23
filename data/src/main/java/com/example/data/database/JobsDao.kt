package com.example.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.data.model.AndroidJobCache
import io.reactivex.Single

@Dao
interface JobsDao {

    @Query("SELECT * FROM jobs")
    fun getJobs(): Single<List<AndroidJobCache>>

    @Transaction
    fun updateData(users: List<AndroidJobCache>) {
        deleteAll()
        insertAll(users)
    }
    @Insert
    fun insertAll(users: List<AndroidJobCache>)

    @Query("DELETE FROM jobs")
    fun deleteAll()
}