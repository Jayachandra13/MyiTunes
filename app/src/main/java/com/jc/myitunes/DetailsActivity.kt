package com.jc.myitunes

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.bumptech.glide.Glide
import com.jc.myitunes.model.Result
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val trackDetails:Result = intent.getParcelableExtra("details")
        if (trackDetails != null) {
            val thumbnailRequest = Glide
                    .with(this@DetailsActivity)
                    .load(trackDetails.artworkUrl60)
            Glide.with(this@DetailsActivity)
                    .load(trackDetails.artworkUrl60)
                    .thumbnail(thumbnailRequest)
                    .into(ivArtwork)
            tvTrackName.text = "Track Name : " + trackDetails.trackName
            tvArtistName.text = "Artist Name : " + trackDetails.artistName
            tvAlbumName.text = "Collection Name : " + trackDetails.collectionName
            tvPrice.text = "Price : " + trackDetails.trackName + "  " + trackDetails.currency
            tvReleaseDate.text = "Release Date : " + trackDetails.releaseDate

        } else {
            Toast.makeText(applicationContext, "Failed to get Data", Toast.LENGTH_SHORT).show()
            finish()
        }


    }
}
