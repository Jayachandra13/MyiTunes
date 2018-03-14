package com.kistlermorse.cloudmonitor.apicall

import com.jc.myitunes.Utils
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by jayachandra on 2/20/18.
 */

object ServiceGenerator {
    private val API_BASE_URL = Utils.Companion.BASE_URL
    private val httpClient = OkHttpClient.Builder()
    private val builder = Retrofit.Builder().baseUrl(API_BASE_URL).addConverterFactory(GsonConverterFactory.create())

    fun <S> createService(serviceClass: Class<S>): S {
        val retrofit = builder.client(httpClient.build()).build()
        return retrofit.create(serviceClass)
    }

}
