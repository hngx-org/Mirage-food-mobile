package com.shegs.miragefood.utils

import android.util.Patterns

fun String.validateFullName(): ValidationResult {
    if (this.isBlank()) {
        return ValidationResult(false, "Full name can't be blank..")
    }
    return ValidationResult(successful = true)
}

fun String.validateEmail(): ValidationResult {
    if (this.isBlank()) {
        return ValidationResult(false, "Email can't be blank...")
    }
    if (!Patterns.EMAIL_ADDRESS.matcher(this).matches()) {
        return ValidationResult(false, "Email not valid.")
    }
    return ValidationResult(successful = true)
}

fun String.validatePassword(): ValidationResult {
    if (this.length < 8) {
        return ValidationResult(false, "\"Password length too short(8)..")
    }
    val containsLettersAndDigits =
        this.any { it.isDigit() } &&
                this.any { it.isLetter() }
    if (!containsLettersAndDigits) {
        return ValidationResult(
            false, "Password needs at  least one letter and digit."
        )
    }
    return ValidationResult(successful = true)
}

fun String.validateRepeatedPassword(password: String): ValidationResult {
    if (this != password) {
        return ValidationResult(false, "Passwords don't match.")
    }
    return ValidationResult(successful = true)
}