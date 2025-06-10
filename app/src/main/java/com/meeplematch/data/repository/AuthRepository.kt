package com.meeplematch.data.repository

import com.meeplematch.data.util.LOGIN
import retrofit2.http.GET
import retrofit2.http.Query

interface AuthRepository {

    @GET(LOGIN)
    suspend fun login(
        @Query("username") username: String,
        @Query("password") password: String
    ) : String?
}