package com.example.mvp_project.UI.login

import com.example.mvp_project.domain.UseCase.CallbackData
import com.example.mvp_project.domain.UseCase.LoginUseCase
import com.example.mvp_project.domain.entities.UserProfile

class LoginPresenter(
    private val loginUseCase: LoginUseCase
) : LoginContract.LoginPresenterInterface {

    private var isSuccess: Boolean = false
    private var view: LoginContract.LoginViewInterface? = null

    override fun onAttachView(view: LoginContract.LoginViewInterface) {
        this.view = view
        if (isSuccess) {
            view.setSuccess()
        }
    }

    override fun onLogin(login: String, password: String) {
        view?.showProgress()
        loginUseCase.login(login, password, object : CallbackData<UserProfile> {
            override fun onSuccess(result: UserProfile) {
                view?.hideProgress()
                view?.loadAccountData(result)
                view?.setSuccess()
                isSuccess = true
            }

            override fun onError(error: Exception) {
                view?.hideProgress()
                view?.showError(error)
                isSuccess = false
            }
        })
    }

    override fun onDetach() {
        this.view = null
    }
}