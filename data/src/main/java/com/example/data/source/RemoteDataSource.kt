package com.example.data.source

import com.example.data.model.AndroidJobPayload
import com.example.domain.entities.AndroidJob
import io.reactivex.Single

interface RemoteDataSource {
    fun getJobs(): Single<List<AndroidJob>>
}