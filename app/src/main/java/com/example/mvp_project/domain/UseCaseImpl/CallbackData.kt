package com.example.mvp_project.domain.UseCaseImpl

interface CallbackData<T> {

    fun onSuccess(result: T)

    fun onError(error: Exception)

}