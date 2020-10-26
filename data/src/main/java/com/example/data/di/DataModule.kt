package com.example.data.di

import com.example.data.repositoryimpl.AndroidJobsRepositoryImpl
import com.example.domain.repository.AndroidJobsRepository
import org.koin.dsl.module.module

/**
* Module Koin onde recebe os modulo criados no projeto
* */
val repositoryModule = module {
    factory<AndroidJobsRepository> {
        AndroidJobsRepositoryImpl(
            jobsCacheDataSource = get(),
            remoteDataSource = get()
        )
    }
}

/**
 * Variavel que junta os Koin Modules em um unico lugar
 */
val dataModules = listOf(remoteDataSourceModule, repositoryModule, cacheDataSource)