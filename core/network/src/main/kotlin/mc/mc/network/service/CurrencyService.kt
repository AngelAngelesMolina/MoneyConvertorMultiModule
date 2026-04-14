package mc.mc.network.service

import mc.mc.network.model.response.ExchangeRatesResponse
import retrofit2.Response
import retrofit2.http.GET

interface CurrencyService {
    @GET("/latest")
    suspend fun getExchangeRates(): Response<ExchangeRatesResponse>
}