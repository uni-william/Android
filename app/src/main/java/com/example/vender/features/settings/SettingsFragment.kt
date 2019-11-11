package com.example.vender.features.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.vender.R
import com.example.vender.features.UserSessionViewModel
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment :Fragment() {

    private val userModel: UserSessionViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_sair.setOnClickListener {
            userModel.authenticationState.value = UserSessionViewModel.AuthenticationState.UNAUTHENTICATED
        }
    }

}