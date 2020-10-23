package com.example.data.api

import com.example.data.model.JobsPayload
import io.reactivex.Single
import retrofit2.http.GET

interface ServerApi {

    @GET("/android-jobs")
    fun fetchJobs(): Single<JobsPayload>
}