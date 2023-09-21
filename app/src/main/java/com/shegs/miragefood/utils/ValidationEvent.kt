package com.shegs.miragefood.utils

sealed class ValidationEvent {
        object Success : ValidationEvent()
    }