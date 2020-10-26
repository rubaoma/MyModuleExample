package com.example.domain.di

import com.example.domain.usecases.GetJobsUseCases
import io.reactivex.schedulers.Schedulers
import org.koin.dsl.module.module

/*
* module koin
* */

val useCaseModule = module {

    factory {
        GetJobsUseCases(
            repository = get(),
            scheduler = Schedulers.io()
        )
    }
}

val domainModule = listOf(useCaseModule)