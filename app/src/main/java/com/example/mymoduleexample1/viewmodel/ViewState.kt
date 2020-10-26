package com.example.mymoduleexample1.viewmodel

import com.example.domain.entities.AndroidJob
import io.reactivex.*

sealed class ViewState<out T> {

    object Loading : ViewState<Nothing>()
    data class Success<T>(val data: T) : ViewState<T>()
    data class Failed(val throwable: Throwable) : ViewState<Nothing>()
}

class StateMachineSingle<T> : SingleTransformer<T, ViewState<T>> {

    override fun apply(upstream: Single<T>): SingleSource<ViewState<T>> {
        return upstream
            .map {
                ViewState.Success(it) as ViewState<T>
            }
            .onErrorReturn {
                ViewState.Failed(it)
            }
            .doOnSubscribe {
                ViewState.Loading
            }
    }
}


