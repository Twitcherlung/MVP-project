package com.example.mvp_project.UI

import androidx.fragment.app.Fragment

interface NavigationActivity {
    fun navigationTo(fragment: Fragment, withTransaction: Boolean = false)
}
