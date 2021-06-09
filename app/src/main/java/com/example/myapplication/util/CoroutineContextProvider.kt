package com.example.myapplication.util

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext


open class CoroutineContextProvider {
    open val main: CoroutineContext by lazy { Dispatchers.Main }
}