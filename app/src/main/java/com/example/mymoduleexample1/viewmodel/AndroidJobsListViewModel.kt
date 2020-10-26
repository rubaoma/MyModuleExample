package com.example.mymoduleexample1.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.domain.entities.AndroidJob
import com.example.domain.usecases.GetJobsUseCases
import io.reactivex.Scheduler
import io.reactivex.rxkotlin.plusAssign

class AndroidJobsListViewModel(

    val useCase: GetJobsUseCases,
    val uiSheduler: Scheduler
): BaseViewModel() {

    val state = MutableLiveData<ViewState<List<AndroidJob>>>().apply {
        value = ViewState.Loading
    }

    fun getJobs(forceUpdate: Boolean = false) {
        disposables += useCase.execute(forceUpdate = forceUpdate)
            .compose(StateMachineSingle())
            .observeOn(uiSheduler)
            .subscribe(
                {
                    //onSuccess
                    state.postValue(it)
                },
                {
                    //onError
                }
            )
    }

    fun onTryAgainrequired(){
        getJobs(forceUpdate = true)
    }
}