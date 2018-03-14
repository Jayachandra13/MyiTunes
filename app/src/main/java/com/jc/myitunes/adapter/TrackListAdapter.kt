package com.jc.myitunes.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.jc.myitunes.R
import com.jc.myitunes.callback.RcvAdapterCallback
import com.jc.myitunes.model.Result

/**
 * Created by user on 12-03-2018.
 */
class TrackListAdapter(val context: Context, val list: List<Result>, val adapterListener: RcvAdapterCallback) : RecyclerView.Adapter<TrackListAdapter.Vh>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(LayoutInflater.from(parent?.context).inflate(R.layout.track_custom_list, parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        val thumbnailRequest = Glide
                .with(context)
                .load(list[position].artworkUrl60)
        Glide.with(context)
                .load(list[position].artworkUrl60)
                .placeholder(R.drawable.ic_launcher_background)
                .thumbnail(thumbnailRequest)
                .into(holder?.thumbNai)

        holder?.tvArtistName?.text = list[position].artistName
        holder?.tvTrackName?.text = list[position].trackName
    }

    override fun getItemCount(): Int {
        return list.size
    }
    inner class Vh(itemView: View?) : RecyclerView.ViewHolder(itemView), View.OnClickListener {


        val thumbNai = itemView?.findViewById<ImageView>(R.id.ivArtwork)
        val tvTrackName = itemView?.findViewById<TextView>(R.id.tvTrackName)
        val tvArtistName = itemView?.findViewById<TextView>(R.id.tvArtistName)

        init {
            itemView?.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            Log.v("",""+list[adapterPosition])
            adapterListener.selectedTrack(list[adapterPosition])
        }
    }
}