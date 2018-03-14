package com.jc.myitunes.callback

import com.jc.myitunes.model.Result

/**
 * Created by jayachandra on 13/3/18.
 */
interface RcvAdapterCallback {
    fun selectedTrack(trackDetails:Result)
}