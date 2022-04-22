package com.example.mvp_project.data.usecaserepo

import android.os.Handler
import androidx.annotation.MainThread
import com.example.mvp_project.domain.LoginApi
import com.example.mvp_project.domain.UseCaseImpl.CallbackData
import com.example.mvp_project.domain.UseCaseImpl.LoginUseCaseImpl
import com.example.mvp_project.domain.entities.UserProfile

class LoginUseCase(
    private val api: LoginApi,
    private val uiHandler: Handler
) : LoginUseCaseImpl {
    override fun login(
        login: String,
        password: String,
        @MainThread callback: CallbackData<UserProfile>
    ) {
        Thread {
            try {
                val account = api.login(login, password)
                uiHandler.post {
                    callback.onSuccess(account)
                }
            } catch (exc: Exception) {
                uiHandler.post { callback.onError(exc) }
            }
        }.start()
    }
}
