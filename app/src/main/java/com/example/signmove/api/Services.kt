package com.example.signmove.api

import com.example.signmove.model.GetUser
import com.example.signmove.model.SetUser
import com.example.signmove.model.Sibal
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UserService {
    @GET("user")
    suspend fun getUser(@Query("email") email: String): Response<GetUser>

    @POST("user")
    suspend fun setUser(@Body user: SetUser): Response<Sibal>

    @DELETE("user")
    suspend fun delUser(@Query("email") email: String): Response<Boolean>
}