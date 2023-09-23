package com.shegs.miragefood.repositories
import android.util.Log
import com.shegs.miragefood.network.data.Result
import com.shegs.miragefood.network.data.SignUpRequest
import com.shegs.miragefood.network.data.SignUpResponse
import com.shegs.miragefood.services.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import javax.inject.Inject


class SignUpRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun signUp(signUpRequest: SignUpRequest): Result<SignUpResponse> {
        return try {
            val response = withContext(Dispatchers.IO) {
                // Perform the network call on the IO dispatcher
                val call: Call<SignUpResponse> = apiService.signUp(signUpRequest)
                call.execute()
            }

            // Check if the response is successful (HTTP status code in 2xx range)
            if (response.isSuccessful) {
                println("popoop")
                val signUpResponse = response.body()
                if (signUpResponse != null) {
                    Result.Success(signUpResponse)
                } else {
                    Result.Error("Sign-up failed. Please try again. Endpoint Message")
                }
            } else {
                println("lasnm")
                println(response.code())
                println(response.message())
                println(response.errorBody().toString())
                // Handle non-successful HTTP status codes
                Result.Error("Sign-up failed. Please try again. mumu Http")
            }
        } catch (e: Exception) {
            println("lkjhgx")
            Log.e("NetworkError", "Exception: ${e.localizedMessage}", e)
            // Handle network or other exceptions
            if (e is java.net.ConnectException) {
                // This is a network-related error
                Result.Error("Network error. Please check your connection.")
            } else {
                // Handle other exceptions
                Result.Error("An error occurred.")
            }
        }
    }
}