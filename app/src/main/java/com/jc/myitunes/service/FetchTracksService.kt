package com.jc.myitunes.service

import android.view.View
import android.widget.ProgressBar
import com.jc.myitunes.Utils
import com.jc.myitunes.model.Track
import com.jc.myitunes.model.TracksResponse
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


/**
 * Created by user on 12-03-2018.
 */
class FetchTracksService(val progessBar: ProgressBar, val resultsCallBack: ResponseCallBack) {
    fun getTrackList(searchString: String): List<Track> {
        progessBar.visibility = View.VISIBLE
        var trackList = arrayListOf<Track>()
        val retrofit = Retrofit.Builder()
                .baseUrl(Utils.Companion.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val apiInterface = retrofit.create(APIInterface::class.java)
        apiInterface.getTrackList(searchString)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Subscriber<TracksResponse>() {
                    override fun onCompleted() {
                        progessBar.visibility = View.GONE
                    }

                    override fun onError(e: Throwable) {
                        progessBar.visibility = View.GONE
                        resultsCallBack.onError(e.message.toString())

                    }

                    override fun onNext(tracksResponse: TracksResponse) {
                        progessBar.visibility = View.GONE
                        tracksResponse.results?.let { trackList.addAll(it) }
                        resultsCallBack.onSuccess(trackList)
                    }
                })

        return trackList
    }

}