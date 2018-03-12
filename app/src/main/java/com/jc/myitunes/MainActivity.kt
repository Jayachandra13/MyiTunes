package com.jc.myitunes

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.jc.myitunes.model.Track
import com.jc.myitunes.service.FetchTracksService
import com.jc.myitunes.service.ResponseCallBack
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.widget.LinearLayoutManager
import com.jc.myitunes.adapter.TrackListAdapter
import com.jc.myitunes.service.AdapterClickListener


class MainActivity : AppCompatActivity() {
    lateinit var trackAdapter:TrackListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rcv.hasFixedSize()
        val linearLayoutManager = LinearLayoutManager(this@MainActivity)
        rcv.layoutManager = linearLayoutManager



        ivFetch.setOnClickListener {

            val searchString = etEnterSearchText.text.toString().trim()
            if (Utils.Companion.isNetworkConnection(applicationContext)) {
                if (Utils.Companion.isValidString(searchString)) {
                    FetchTracksService(progressBar, responseCallback).getTrackList(Utils.Companion.formatString(searchString))
                } else {
                    etEnterSearchText.setText("")
                    etEnterSearchText.error = "Enter valid text"

                }

            } else {
                Toast.makeText(applicationContext, "Please check Network connection", Toast.LENGTH_LONG).show()
            }
        }
    }

    private val responseCallback = object : ResponseCallBack {
        override fun onSuccess(trackListL: List<Track>) {
            trackAdapter= TrackListAdapter(applicationContext,trackListL,adapterListener)
            rcv.adapter=trackAdapter

        }

        override fun onError(erroMessage: String) {
            Log.v("onError", "erroMessage " + erroMessage)

        }

    }
    private val adapterListener=object :AdapterClickListener{
        override fun selectedTrack(trackDetails: Track) {
            val intent=Intent(this@MainActivity,DetailsActivity::class.java)
            intent.putExtra("details",trackDetails)
            startActivity(Intent(this@MainActivity,DetailsActivity::class.java))
        }
    }
}
