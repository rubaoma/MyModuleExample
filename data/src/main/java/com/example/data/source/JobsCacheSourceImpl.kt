package com.example.data.source

import com.example.data.database.JobsDao
import com.example.data.mapper.AndroidJobCacheMapper
import com.example.domain.entities.AndroidJob
import io.reactivex.Single

class JobsCacheSourceImpl (private val jobsDao: JobsDao): JobsCacheDataSource{
    override fun getJobs(): Single<List<AndroidJob>> {
        return  jobsDao.getJobs()
            .map { AndroidJobCacheMapper.map(it) }
    }

    override fun insertData(list: List<AndroidJob>) {
        jobsDao.insertAll(AndroidJobCacheMapper.mapJobsToCache(list))
    }

    override fun updateData(list: List<AndroidJob>) {
        jobsDao.updateData(AndroidJobCacheMapper.mapJobsToCache(list))
    }

}