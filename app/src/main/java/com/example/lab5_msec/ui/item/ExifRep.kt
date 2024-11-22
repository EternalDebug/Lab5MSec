package com.example.lab5_msec.ui.item

import android.content.Context
import android.net.Uri
import androidx.exifinterface.media.ExifInterface

class ExifRep(
    uri:Uri,
    AppCont:Context
) {
    var exif = ExifInterface(AppCont.contentResolver.openInputStream(uri)!!)
    var empty = "You are Empty"

    fun GetDate(): String{
        var res = empty
        try {
            var sr = exif.getAttribute(ExifInterface.TAG_DATETIME)
            if (sr!=null)
                res = sr
            return res
        }
        catch (e: Exception){
           return res
        }
    }

    fun GetLat(): String{
        var res = empty
        try {
            var sr = exif.getAttribute(ExifInterface.TAG_GPS_LATITUDE)
            if (sr!=null)
                res = sr
            return res
        }
        catch (e: Exception){
            return res
        }
    }

    fun GetLong(): String{
        var res = empty
        try {
            var sr = exif.getAttribute(ExifInterface.TAG_GPS_LONGITUDE)
            if (sr!=null)
                res = sr
            return res
        }
        catch (e: Exception){
            return res
        }
    }

    fun GetDevice(): String{
        var res = empty
        try {
            var sr = exif.getAttribute(ExifInterface.TAG_MAKE)
            if (sr!=null)
                res = sr
            return res
        }
        catch (e: Exception){
            return res
        }
    }

    fun GetModel(): String{
        var res = empty
        try {
            var sr = exif.getAttribute(ExifInterface.TAG_MODEL)
            if (sr!=null)
                res = sr
            return res
        }
        catch (e: Exception){
            return res
        }
    }
}