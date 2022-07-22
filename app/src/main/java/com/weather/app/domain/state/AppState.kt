package com.weather.app.domain.state

sealed class AppState(val result: Any? = null) {
    abstract fun state(data: Any?): AppState

    class success(data: Any?) : AppState(result = data) {
        override fun state(data: Any?): AppState {
            return this
        }

    }

    class failed : AppState() {
        override fun state(data: Any?): AppState {
            return this
        }
    }

    class loader : AppState() {
        override fun state(data: Any?): AppState {
            return this
        }
    }

    class idle : AppState() {
        override fun state(data: Any?): AppState {
            return this
        }
    }


}
