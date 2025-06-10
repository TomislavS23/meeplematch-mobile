package com.meeplematch.data.repository

import com.meeplematch.data.model.PublicUser
import com.meeplematch.data.util.PUBLIC_USER
import retrofit2.http.GET
import retrofit2.http.Path

interface UserRepository {

    @GET(PUBLIC_USER)
    suspend fun getPublicUser(@Path("username") username: String) : PublicUser
}