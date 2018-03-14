package com.jc.myitunes.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Result() :Parcelable{

    @SerializedName("wrapperType")
    @Expose
    var wrapperType: String? = null
    @SerializedName("kind")
    @Expose
    var kind: String? = null
    @SerializedName("artistId")
    @Expose
    var artistId: Int? = null
    @SerializedName("collectionId")
    @Expose
    var collectionId: Int? = null
    @SerializedName("trackId")
    @Expose
    var trackId: Int? = null
    @SerializedName("artistName")
    @Expose
    var artistName: String? = null
    @SerializedName("collectionName")
    @Expose
    var collectionName: String? = null
    @SerializedName("trackName")
    @Expose
    var trackName: String? = null
    @SerializedName("collectionCensoredName")
    @Expose
    var collectionCensoredName: String? = null
    @SerializedName("trackCensoredName")
    @Expose
    var trackCensoredName: String? = null
    @SerializedName("artistViewUrl")
    @Expose
    var artistViewUrl: String? = null
    @SerializedName("collectionViewUrl")
    @Expose
    var collectionViewUrl: String? = null
    @SerializedName("trackViewUrl")
    @Expose
    var trackViewUrl: String? = null
    @SerializedName("previewUrl")
    @Expose
    var previewUrl: String? = null
    @SerializedName("artworkUrl30")
    @Expose
    var artworkUrl30: String? = null
    @SerializedName("artworkUrl60")
    @Expose
    var artworkUrl60: String? = null
    @SerializedName("artworkUrl100")
    @Expose
    var artworkUrl100: String? = null
    @SerializedName("collectionPrice")
    @Expose
    var collectionPrice: Double? = null
    @SerializedName("trackPrice")
    @Expose
    var trackPrice: Double? = null
    @SerializedName("releaseDate")
    @Expose
    var releaseDate: String? = null
    @SerializedName("collectionExplicitness")
    @Expose
    var collectionExplicitness: String? = null
    @SerializedName("trackExplicitness")
    @Expose
    var trackExplicitness: String? = null
    @SerializedName("discCount")
    @Expose
    var discCount: Int? = null
    @SerializedName("discNumber")
    @Expose
    var discNumber: Int? = null
    @SerializedName("trackCount")
    @Expose
    var trackCount: Int? = null
    @SerializedName("trackNumber")
    @Expose
    var trackNumber: Int? = null
    @SerializedName("trackTimeMillis")
    @Expose
    var trackTimeMillis: Int? = null
    @SerializedName("country")
    @Expose
    var country: String? = null
    @SerializedName("currency")
    @Expose
    var currency: String? = null
    @SerializedName("primaryGenreName")
    @Expose
    var primaryGenreName: String? = null
    @SerializedName("isStreamable")
    @Expose
    var isStreamable: Boolean? = null

    constructor(parcel: Parcel) : this() {
        wrapperType = parcel.readString()
        kind = parcel.readString()
        artistId = parcel.readValue(Int::class.java.classLoader) as? Int
        collectionId = parcel.readValue(Int::class.java.classLoader) as? Int
        trackId = parcel.readValue(Int::class.java.classLoader) as? Int
        artistName = parcel.readString()
        collectionName = parcel.readString()
        trackName = parcel.readString()
        collectionCensoredName = parcel.readString()
        trackCensoredName = parcel.readString()
        artistViewUrl = parcel.readString()
        collectionViewUrl = parcel.readString()
        trackViewUrl = parcel.readString()
        previewUrl = parcel.readString()
        artworkUrl30 = parcel.readString()
        artworkUrl60 = parcel.readString()
        artworkUrl100 = parcel.readString()
        collectionPrice = parcel.readValue(Double::class.java.classLoader) as? Double
        trackPrice = parcel.readValue(Double::class.java.classLoader) as? Double
        releaseDate = parcel.readString()
        collectionExplicitness = parcel.readString()
        trackExplicitness = parcel.readString()
        discCount = parcel.readValue(Int::class.java.classLoader) as? Int
        discNumber = parcel.readValue(Int::class.java.classLoader) as? Int
        trackCount = parcel.readValue(Int::class.java.classLoader) as? Int
        trackNumber = parcel.readValue(Int::class.java.classLoader) as? Int
        trackTimeMillis = parcel.readValue(Int::class.java.classLoader) as? Int
        country = parcel.readString()
        currency = parcel.readString()
        primaryGenreName = parcel.readString()
        isStreamable = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(wrapperType)
        parcel.writeString(kind)
        parcel.writeValue(artistId)
        parcel.writeValue(collectionId)
        parcel.writeValue(trackId)
        parcel.writeString(artistName)
        parcel.writeString(collectionName)
        parcel.writeString(trackName)
        parcel.writeString(collectionCensoredName)
        parcel.writeString(trackCensoredName)
        parcel.writeString(artistViewUrl)
        parcel.writeString(collectionViewUrl)
        parcel.writeString(trackViewUrl)
        parcel.writeString(previewUrl)
        parcel.writeString(artworkUrl30)
        parcel.writeString(artworkUrl60)
        parcel.writeString(artworkUrl100)
        parcel.writeValue(collectionPrice)
        parcel.writeValue(trackPrice)
        parcel.writeString(releaseDate)
        parcel.writeString(collectionExplicitness)
        parcel.writeString(trackExplicitness)
        parcel.writeValue(discCount)
        parcel.writeValue(discNumber)
        parcel.writeValue(trackCount)
        parcel.writeValue(trackNumber)
        parcel.writeValue(trackTimeMillis)
        parcel.writeString(country)
        parcel.writeString(currency)
        parcel.writeString(primaryGenreName)
        parcel.writeValue(isStreamable)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Result> {
        override fun createFromParcel(parcel: Parcel): Result {
            return Result(parcel)
        }

        override fun newArray(size: Int): Array<Result?> {
            return arrayOfNulls(size)
        }
    }

}
