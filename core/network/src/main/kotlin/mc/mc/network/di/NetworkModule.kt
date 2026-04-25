package mc.mc.network.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import mc.mc.network.interceptor.HeadersInterceptor
import mc.mc.network.service.CurrencyService
import mc.mc.network.util.Constants
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        val logginInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC

        }

        return OkHttpClient.Builder()
            .addNetworkInterceptor(logginInterceptor)
            .addNetworkInterceptor(HeadersInterceptor(mapOf(Constants.API_KEY to Constants.API_KEY_VALUE)))
            .build()
    }

    @Singleton
    @Provides
    fun provideCurrencyRetrofitService(
        client: OkHttpClient
    ): CurrencyService {

        return Retrofit
            .Builder()
            .baseUrl(Constants.CURRENCY_CONVERTOR_PATH_URL)
            .client(client)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(CurrencyService::class.java)
    }

}