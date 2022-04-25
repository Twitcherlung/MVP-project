package com.example.mvp_project.ui.forget_password

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.mvp_project.R
import com.example.mvp_project.ui.BaseFragment
import com.example.mvp_project.app
import com.example.mvp_project.data.database.EmailException
import com.example.mvp_project.data.database.ForgetPasswordException
import com.example.mvp_project.databinding.FragmentForgetPasswordBinding
import com.example.mvp_project.domain.entities.UserProfile

class ForgetPasswordFragment :
    BaseFragment<FragmentForgetPasswordBinding>(FragmentForgetPasswordBinding::inflate),
    ForgetPasswordContract.ForgetPasswordViewInterface {

    private var presenter: ForgetPasswordContract.ForgetPasswordPresenterInterface? = null


    companion object {
        fun newInstance() = ForgetPasswordFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        presenter = activity?.app?.let { ForgetPasswordPresenter(it.forgetPasswordUseCase) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter?.onAttachView(this)

        binding.restoreButton.setOnClickListener {
            presenter?.findAccount(
                binding.emailTextView.text.toString()
            )
        }
    }

    override fun showProgress() {
        binding.progress.isVisible = true
    }

    override fun hideProgress() {
        binding.progress.isVisible = false
    }

    override fun setSuccess() {
        binding.root.setBackgroundColor(Color.GREEN)
    }

    override fun showError(error: Exception) {
        val text = when (error) {
            is ForgetPasswordException -> {
                getString(R.string.error_forget_password)
            }
            is EmailException -> {
                getString(R.string.error_email_empty)
            }
            else -> {
                getString(R.string.unexpected_error_occurred) + error.toString()
            }
        }
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
        binding.root.setBackgroundColor(Color.RED)
    }

    override fun forgetPasswordData(account: UserProfile) {
        Toast.makeText(context, getString(R.string.success_registration), Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onDetach()
    }

}