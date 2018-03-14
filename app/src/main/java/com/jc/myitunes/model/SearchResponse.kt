package com.jc.myitunes.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SearchResponse() :Parcelable{

    @SerializedName("resultCount")
    @Expose
   public var resultCount: Int? = null
    @SerializedName("results")
    @Expose
    public var results: List<Result>? = null

    constructor(parcel: Parcel) : this() {
        resultCount = parcel.readValue(Int::class.java.classLoader) as? Int
        results = parcel.createTypedArrayList(Result)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(resultCount)
        parcel.writeTypedList(results)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SearchResponse> {
        override fun createFromParcel(parcel: Parcel): SearchResponse {
            return SearchResponse(parcel)
        }

        override fun newArray(size: Int): Array<SearchResponse?> {
            return arrayOfNulls(size)
        }
    }

}
