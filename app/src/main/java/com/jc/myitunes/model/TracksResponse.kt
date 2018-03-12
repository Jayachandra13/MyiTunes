package com.jc.myitunes.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TracksResponse {

    @SerializedName("resultCount")
    @Expose
    var resultCount: Int? = null
    @SerializedName("results")
    @Expose
    var results: List<Track>? = null

}
