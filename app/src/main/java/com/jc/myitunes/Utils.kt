package com.jc.myitunes

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by user on 12-03-2018.
 */
class Utils {

    companion object {
        val BASE_URL="https://itunes.apple.com/"
        fun isNetworkConnection(context: Context): Boolean {

            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork = connectivityManager.activeNetworkInfo
            if (activeNetwork != null) {
                return true
            }
            return false
        }
        fun isValidString(searchString:String?):Boolean{
            if(searchString !=null && searchString.isNotEmpty()){
                return true
            }
            return false
        }
        fun formatString(searchString:String):String{

            return searchString.replace(" ","+")
        }
    }
}