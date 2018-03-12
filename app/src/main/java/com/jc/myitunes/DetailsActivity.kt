package com.jc.myitunes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.jc.myitunes.model.Track
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val trackDetails=intent.getParcelableExtra<Track>("details")

        val thumbnailRequest = Glide
                .with(this@DetailsActivity)
                .load(trackDetails.artworkUrl60)
        Glide.with(this@DetailsActivity)
                .load(trackDetails.artworkUrl60)
                .placeholder(R.drawable.ic_launcher_background)
                .thumbnail(thumbnailRequest)
                .into(ivArtwork)
        tvTrackName.text="Track Name: "+trackDetails.trackName
        tvArtistName.text="Artist Name: "+trackDetails.artistName
        tvAlbumName.text="Collection Name"+trackDetails.collectionName
        tvPrice.text="Price: "+trackDetails.trackName+" "+trackDetails.currency
        tvReleaseDate.text="Release Date: "+trackDetails.releaseDate

    }
}
