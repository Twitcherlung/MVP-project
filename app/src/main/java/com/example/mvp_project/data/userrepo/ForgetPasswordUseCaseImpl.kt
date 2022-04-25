package com.example.mvp_project.data.userrepo

import android.os.Handler
import androidx.annotation.MainThread
import com.example.mvp_project.domain.LoginApi
import com.example.mvp_project.domain.UseCase.CallbackData
import com.example.mvp_project.domain.UseCase.ForgetPasswordUseCase
import com.example.mvp_project.domain.entities.UserProfile

class ForgetPasswordUseCaseImpl(
    private val api: LoginApi,
) : ForgetPasswordUseCase {

    override fun forgetPassword(
        email: String,
        callback: CallbackData<UserProfile>
    ) {
        Thread {
            try {
                val account = api.forgotPassword(email)
                callback.onSuccess(account)
            } catch (exc: Exception) {
                callback.onError(exc)
            }
        }.start()
    }
}