package com.example.test_project_for_internal_use.ui.main

import androidx.lifecycle.ViewModel
import com.example.test_project_for_internal_use.models.MainElement
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel() {
    private val _state = MutableStateFlow<MainState>(MainState.NotLoaded)
    val state: StateFlow<MainState> get() = _state.asStateFlow()

    init {
        //TODO:do smth with state
    }

    fun askForChangeStateFromView(askingState: MainState) {

    }

    sealed class MainState {
        object Loading: MainState()
        object NotLoaded: MainState()
        data class Loaded(
            val count: Int,
        ): MainState()
    }
}