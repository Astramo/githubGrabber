package com.weather.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weather.app.data.response.UserModel
import com.weather.app.domain.state.AppState
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ViewModelScoped
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@ViewModelScoped
class MainViewModel : ViewModel() {
    private val _viewState = MutableStateFlow<AppState>(AppState.idle())
    val state: StateFlow<AppState> = _viewState

    @Inject
    lateinit var client: HttpClient

    fun fetchUser(name: String) {
        viewModelScope.launch {
            try {
                val user =
                    com.weather.app.data.client.get(name).body<UserModel>()
                    _viewState.value = AppState.success(data = user)

            } catch (e: Exception) {
                _viewState.value = AppState.failed()
            }
        }
    }


}