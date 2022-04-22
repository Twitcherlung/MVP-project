package com.example.mvp_project.domain.UseCase

import com.example.mvp_project.data.database.AccountEntity
import com.example.mvp_project.domain.entities.UserProfile

fun convertAccountToEntities(account: AccountEntity): UserProfile {
    return UserProfile(
        id = account.id,
        login = account.login,
        email = account.email
    )
}