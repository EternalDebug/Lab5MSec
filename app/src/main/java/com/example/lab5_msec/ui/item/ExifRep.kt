package com.example.lab5_msec.ui.item

import android.content.Context
import android.net.Uri
import androidx.exifinterface.media.ExifInterface
import com.example.lab5_msec.appContext
import java.io.File

class ExifRep(
    val uri:Uri,
    val AppCont:Context
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

    fun saveFileWithNewTags(
        newUri:Uri,
        date:String,
        lat:String,
        long:String,
        device:String,
        model:String,
        navigate: (Uri) -> Unit
    ){
        val file: File = File(AppCont.getExternalFilesDir(null), "secret_data")
        uri.let { AppCont.contentResolver.openInputStream(it) }.use { input ->
            file.outputStream().use { output ->
                input!!.copyTo(output)
            }
        }

        val ex = ExifInterface(file)
        ex.setAttribute(ExifInterface.TAG_DATETIME, date)
        ex.setAttribute(ExifInterface.TAG_GPS_LATITUDE, lat)
        ex.setAttribute(ExifInterface.TAG_GPS_LONGITUDE, long)
        ex.setAttribute(ExifInterface.TAG_MAKE, device)
        ex.setAttribute(ExifInterface.TAG_MODEL, model)
        ex.saveAttributes()

        newUri.let { AppCont.contentResolver.openOutputStream(it) }.use { output ->
            file.inputStream().use { input ->
                input.copyTo(output!!)
            }
        }

        file.delete()
        navigate(newUri)
    }
}