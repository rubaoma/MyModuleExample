package com.example.data.source

import com.example.data.api.ServerApi
import com.example.data.mapper.AndroidJobMapper
import com.example.data.model.AndroidJobPayload
import com.example.domain.entities.AndroidJob
import io.reactivex.Single

class RemoteDataSourceImpl(private val serverApi: ServerApi):
    RemoteDataSource {

    override fun getJobs(): Single<List<AndroidJob>> {
        return serverApi.fetchJobs()
            .map { AndroidJobMapper.map(it) }
    }
}