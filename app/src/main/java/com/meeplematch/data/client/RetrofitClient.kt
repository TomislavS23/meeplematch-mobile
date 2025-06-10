package com.meeplematch.data.client

import com.meeplematch.data.repository.AuthRepository
import com.meeplematch.data.repository.EventRepository
import com.meeplematch.data.repository.UserRepository
import com.meeplematch.data.util.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object RetrofitClient {
    private val logging = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    val eventApi: EventRepository by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EventRepository::class.java)
    }

    val authApi: AuthRepository by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthRepository::class.java)
    }

    val userApi: UserRepository by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserRepository::class.java)
    }
}
