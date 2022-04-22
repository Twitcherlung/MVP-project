package com.example.mvp_project.domain.UseCase

import androidx.annotation.MainThread
import com.example.mvp_project.data.database.AccountEntity

interface RegistrationUseCase {
    fun register(
        login: String,
        password: String,
        email: String,
        @MainThread callback: CallbackData<AccountEntity>
    )
}