package com.weather.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import coil.compose.rememberAsyncImagePainter
import com.weather.app.data.client
import com.weather.app.data.response.UserModel
import com.weather.app.ui.MainUi
import com.weather.app.ui.theme.WeatherTheme
import com.weather.app.viewmodel.MainViewModel
import io.ktor.client.call.*
import io.ktor.client.request.*

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val state = viewModel.state.collectAsState()

                    MainUi(appState = state.value){
                        viewModel.fetchUser(it)
                    }

                }
            }
        }
    }
}

