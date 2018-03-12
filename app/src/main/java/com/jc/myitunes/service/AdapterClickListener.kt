package com.jc.myitunes.service

import com.jc.myitunes.model.Track

/**
 * Created by user on 12-03-2018.
 */
interface AdapterClickListener {
    fun selectedTrack(trackDetails:Track)
}