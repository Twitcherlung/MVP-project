package com.example.mvp_project.data.usecaserepo

import android.os.Handler
import androidx.annotation.MainThread
import com.example.mvp_project.domain.LoginApi
import com.example.mvp_project.domain.UseCaseImpl.CallbackData
import com.example.mvp_project.domain.entities.UserProfile

class ForgetPasswordUseCase(
    private val api: LoginApi,
    private val uiHandler: Handler
) : IForgetPasswordUseCase {

    override fun forgetPassword(
        email: String,
        @MainThread callback: CallbackData<UserProfile>
    ) {
        Thread {
            try {
                val account = api.forgotPassword(email)
                uiHandler.post {
                    callback.onSuccess(account)
                }
            } catch (exc: Exception) {
                uiHandler.post { callback.onError(exc) }
            }
        }.start()
    }
}