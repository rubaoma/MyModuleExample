package com.example.data.mapper

import com.example.data.model.AndroidJobCache
import com.example.domain.entities.AndroidJob

object AndroidJobCacheMapper {

    fun map(cacheData: List<AndroidJobCache>) = cacheData.map { map(it) }

    private fun map(cacheData: AndroidJobCache) = AndroidJob(
        title = cacheData.title,
        experienceTimeRequired = cacheData.requiredExperienceYears,
        native = cacheData.native,
        country = cacheData.country
    )

    fun mapJobsToCache(jobs: List<AndroidJob>) = jobs.map { map(it) }

    private fun map(data: AndroidJob) = AndroidJobCache(
        title = data.title,
        requiredExperienceYears = data.experienceTimeRequired,
        native =  data.native,
        country = data.country
    )

}