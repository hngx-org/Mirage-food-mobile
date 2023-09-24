package com.shegs.miragefood.models.repositories

import com.shegs.miragefood.repositories.Resource
import com.shegs.miragefood.services.CustomResponse
import com.shegs.miragefood.services.FreeLunchApiService
import com.shegs.miragefood.services.Lunch
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class LunchRepository @Inject constructor(
    private val apiService: FreeLunchApiService
) {
   suspend  fun getAllLunch(token: String): Flow<Resource<CustomResponse<Lunch>>> {
        return flow {
            emit(Resource.Loading())
            try{
                val response = apiService.getLunch(token = token)
                emit(Resource.Success(response))
            } catch (e: Exception){
                emit(Resource.Error(e.message ?: "An error occured"))
            } catch (e: HttpException){
                emit(Resource.Error(e.message ?: "An error occured"))
            }
        }
    }
}