package com.example.test_project_for_internal_use.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.test_project_for_internal_use.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()

    lateinit var message: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        message = view.findViewById(R.id.message)
        message.text = "someText"
        viewModel.state.onEach {
            //do smth with state
            when(it) {
                MainViewModel.MainState.Loading -> {

                }
                is MainViewModel.MainState.Loaded -> {}
                MainViewModel.MainState.NotLoaded -> {}
            }
        }.launchIn(lifecycleScope)
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}