package com.example.mvp_project.data.userrepo

import com.example.mvp_project.domain.LoginApi
import com.example.mvp_project.domain.UseCase.CallbackData
import com.example.mvp_project.domain.UseCase.LoginUseCase
import com.example.mvp_project.domain.entities.UserProfile

class LoginUseCaseImpl(
    private val api: LoginApi,
) : LoginUseCase {
    override fun login(
        login: String,
        password: String,
        callback: CallbackData<UserProfile>
    ) {
        Thread {
            try {
                val account = api.login(login, password)
                callback.onSuccess(account)
            } catch (exc: Exception) {
                callback.onError(exc)
            }
        }.start()
    }
}
