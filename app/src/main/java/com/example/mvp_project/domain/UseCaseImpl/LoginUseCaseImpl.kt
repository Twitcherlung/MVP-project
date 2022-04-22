package com.example.mvp_project.domain.UseCaseImpl

import androidx.annotation.MainThread
import com.example.mvp_project.domain.entities.UserProfile

interface LoginUseCaseImpl {
    fun login(
        login: String,
        password: String,
        @MainThread callback: CallbackData<UserProfile>
    )
}