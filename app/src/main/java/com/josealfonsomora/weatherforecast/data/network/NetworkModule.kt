package com.josealfonsomora.weatherforecast.data.network

import com.josealfonsomora.weatherforecast.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(ActivityComponent::class)
class NetworkModule {

    @Provides
    fun provideInterceptor() = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.BUILD_TYPE == "release") {
            HttpLoggingInterceptor.Level.NONE
        } else {
            HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    fun provideOkHttp(interceptor: HttpLoggingInterceptor): OkHttpClient { // TODO: Add sslpinning
        return OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .addInterceptor { chain ->
                val newRequest = chain.request().newBuilder()
                val urlBuilder = chain.request().url.newBuilder()
                    .addQueryParameter("appid", "4cb14ee5bcb95c329c5c6468c540f38f")
                chain.proceed(newRequest.url(urlBuilder.build()).build())
            }
            .build()
    }

    @Provides
    fun provideForecastApi(okHttpClient: OkHttpClient): ForecastApi =
        Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.openweathermap.org")
            .build().create(ForecastApi::class.java)

    // APPID = 4cb14ee5bcb95c329c5c6468c540f38f
}