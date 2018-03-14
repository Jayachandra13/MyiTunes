package com.jc.myitunes

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.jc.myitunes.adapter.TrackListAdapter
import com.jc.myitunes.apicall.TracksService
import com.jc.myitunes.callback.RcvAdapterCallback
import com.jc.myitunes.callback.ResponseCallBack
import com.jc.myitunes.model.Result
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    public lateinit var trackAdapter: TrackListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rcv.hasFixedSize()
        val linearLayoutManager = LinearLayoutManager(this@MainActivity)
        rcv.layoutManager = linearLayoutManager

        etEnterSearchText.setText("Michael Jackson")
        etEnterSearchText.setSelection(etEnterSearchText.length())
        hideKeyboard(etEnterSearchText)
        ivFetch.setOnClickListener {
            hideKeyboard(etEnterSearchText)
            val searchString = etEnterSearchText.text.toString().trim()
            if (Utils.Companion.isNetworkConnection(applicationContext)) {
                if (Utils.Companion.isValidString(searchString)) {
                    TracksService(progressBar, responseCallback).getTrackList(Utils.Companion.formatString(searchString))
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
        override fun onSuccess(trackListL: List<Result>) {
            trackAdapter = TrackListAdapter(applicationContext, trackListL, adapterListener)
             rcv.adapter = trackAdapter

        }

        override fun onError(errorMessage: String) {
            Toast.makeText(this@MainActivity, errorMessage, Toast.LENGTH_LONG)

        }

    }

    private val adapterListener = object : RcvAdapterCallback {
        override fun selectedTrack(trackDetails: Result) {
            val intent = Intent(this@MainActivity, DetailsActivity::class.java)
            intent.putExtra("details", trackDetails)
            startActivity(intent)
        }
    }

    private fun hideKeyboard(view: View) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
