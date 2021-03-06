package com.example.mvp_project.domain.UseCase

import androidx.annotation.MainThread
import com.example.mvp_project.data.database.AccountEntity
import com.example.mvp_project.domain.entities.UserProfile

interface RegistrationUseCase {
    fun register(
        login: String,
        password: String,
        email: String,
        @MainThread callback: CallbackData<UserProfile>
    )
}