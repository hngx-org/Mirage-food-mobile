package com.shegs.miragefood.repositories

import com.shegs.miragefood.services.FreeLunchApiService
import com.shegs.miragefood.services.CustomResponse
import com.shegs.miragefood.services.LoginResponse
import com.shegs.miragefood.services.SignInRequest
import com.shegs.miragefood.services.UserInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class NetworkRepository @Inject constructor(
    private val apiService: FreeLunchApiService
) {

    fun signIn(signInRequest: SignInRequest): Flow<Resource<CustomResponse<LoginResponse>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val response = apiService.login(signInRequest)
                emit(Resource.Success(response))
            } catch (e: Exception) {
                emit(Resource.Error(e.message ?: "An error occurred"))
            } catch (e: HttpException) {
                emit(Resource.Error(e.message ?: "An error occurred"))
            }
        }
    }


    fun getAllUsers(accessToken: String): Flow<Resource<CustomResponse<UserInfo>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val response = apiService.getAllUsers(accessToken)
                emit(Resource.Success(response))
            } catch (e: Exception) {
                emit(Resource.Error(e.message ?: "An error occurred"))
            } catch (e: HttpException) {
                emit(Resource.Error(e.message ?: "An error occurred"))
            }
        }
    }

    fun getUserByQuery(query: String, accessToken: String): Flow<Resource<CustomResponse<UserInfo>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val response = apiService.getUserByQuery(query, accessToken)
                emit(Resource.Success(response))
            } catch (e: Exception) {
                emit(Resource.Error(e.message ?: "An error occurred"))
            } catch (e: HttpException) {
                emit(Resource.Error(e.message ?: "An error occurred"))
            }
        }
    }
}


sealed class Resource<T>(val data: T? = null, val errorMessage: String? = null) {
    class Loading<T> : Resource<T>()
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(errorMessage: String, data: T? = null) : Resource<T>(data, errorMessage)
}