package com.weather.app.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.weather.app.data.response.UserModel
import com.weather.app.domain.state.AppState

@Composable
fun MainUi(
    appState: AppState,
    onClick: (name: String) -> Unit
) {
    val (username, onChange) = remember {
        mutableStateOf("")
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when (appState) {
            is AppState.idle -> {}
            is AppState.success -> {
                val user: UserModel = appState.result as UserModel
                user.avatarURL?.let {
                    Image(
                        modifier = Modifier.fillMaxWidth().padding(16.dp),
                        painter = rememberAsyncImagePainter(model = it),
                        contentDescription = null
                    )
                }
            }
            is AppState.failed -> {
                Text(text = "Failed to get Image")
            }
            is AppState.loader -> {
                CircularProgressIndicator()
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        TextField(value = username, onValueChange = onChange, modifier = Modifier.fillMaxWidth().padding(8.dp))
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { onClick.invoke(username) }, modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            Text(text = "getImage",modifier = Modifier.padding(8.dp))
        }
    }


}