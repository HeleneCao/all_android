package fr.ch.routardapp.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://routard.sackebandt.fr/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface PaysApiService {
    @GET("pays")
    suspend fun getPays(): List<Pays>
}

object PaysApi{
    val retrofitService : PaysApiService by lazy { retrofit.create(PaysApiService::class.java)}
}