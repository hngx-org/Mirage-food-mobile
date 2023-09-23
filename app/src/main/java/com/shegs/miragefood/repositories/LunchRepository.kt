package com.shegs.miragefood.models.repositories

import com.shegs.miragefood.models.datas.LunchData
import com.shegs.miragefood.services.ApiService
import retrofit2.Response
import javax.inject.Inject

class LunchRepository @Inject constructor(
    private val apiService: ApiService
) {
   suspend  fun getAllLunch(token: String): Response<LunchData> {
        return apiService.getLunch(token = token);
    }
}