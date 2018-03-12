package com.jc.myitunes.service

import com.jc.myitunes.model.TracksResponse
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable


/**
 * Created by user on 12-03-2018.
 */
interface APIInterface {
    @GET("/search")
    fun getTrackList(@Query("term") searchTerm: String): Observable<TracksResponse>
}