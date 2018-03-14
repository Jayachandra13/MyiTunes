package com.jc.myitunes.callback

import com.jc.myitunes.model.Result

/**
 * Created by jayachandra on 13/3/18.
 */
interface ResponseCallBack {
    fun onSuccess(trackListL:List<Result>)
    fun onError(errorMessage:String)
}