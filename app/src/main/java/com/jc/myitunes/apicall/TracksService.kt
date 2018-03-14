package com.jc.myitunes.apicall

import android.util.Log
import android.view.View
import android.widget.ProgressBar
import com.jc.myitunes.callback.ResponseCallBack
import com.jc.myitunes.model.Result
import com.jc.myitunes.model.SearchResponse
import com.kistlermorse.cloudmonitor.apicall.RetrofitService
import com.kistlermorse.cloudmonitor.apicall.ServiceGenerator
import retrofit2.Call
import retrofit2.Response

/**
 * Created by jayachandra on 13/3/18.
 */
class TracksService (val progessBar: ProgressBar, val resultsCallBack: ResponseCallBack){

    fun getTrackList(searchString: String){
        progessBar.visibility = View.VISIBLE
        var trackList = arrayListOf<Result>()

        val retrofitService = ServiceGenerator.createService(RetrofitService::class.java)
        val getTracks = retrofitService.getTrackList(searchString)
        getTracks.enqueue(object :retrofit2.Callback<SearchResponse>{
            override fun onResponse(call: Call<SearchResponse>?, response: Response<SearchResponse>?) {
                progessBar.visibility = View.GONE
                Log.v("",""+response?.body()?.results)
                resultsCallBack.onSuccess(response?.body()?.results!!)
            }

            override fun onFailure(call: Call<SearchResponse>?, t: Throwable?) {
                progessBar.visibility = View.GONE
                resultsCallBack.onError(t!!.localizedMessage)
            }
        })
    }
}