package com.kistlermorse.cloudmonitor.apicall

import com.jc.myitunes.model.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by jayachandra on 2/20/18.
 */

interface RetrofitService {
    @GET("/search")
    fun getTrackList(@Query("term") searchTerm: String): Call<SearchResponse>
}

