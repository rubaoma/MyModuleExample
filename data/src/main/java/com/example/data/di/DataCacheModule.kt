package com.example.data.di

import com.example.data.database.JobsDataBase
import com.example.data.source.JobsCacheDataSource
import com.example.data.source.JobsCacheSourceImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val cacheDataSource = module {
    single { JobsDataBase.createDataBase(androidContext()) }
    factory <JobsCacheDataSource>{ JobsCacheSourceImpl(jobsDao = get()) }
}