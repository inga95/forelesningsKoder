package com.example.forelesningskoder.network

import android.net.Uri
import java.io.File
import com.androidnetworking.error.ANError
import org.json.JSONObject
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.androidnetworking.interfaces.UploadProgressListener
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority


class ImageClient {

    fun uploadImage( uri: Uri) {
        println("uploading: " + uri.path)

        val image = File(uri.path!!)

        if(image.exists()){
            AndroidNetworking.upload("http://api-edu.gtl.ai/api/v1/imagesearch/upload")
                .addMultipartFile("image", image)
                .addMultipartParameter("key", "value")
                .setTag("uploadTest")
                .setPriority(Priority.HIGH)
                .build()
                .setUploadProgressListener { bytesUploaded, totalBytes ->
                    // do anything with progress
                }
                .getAsJSONObject(object : JSONObjectRequestListener {
                    override fun onResponse(response: JSONObject) {
                        println("ok: $response")
                    }

                    override fun onError(error: ANError) {
                        println("upload error: " + error.localizedMessage)
                    }
                })
        } else {
            println("File does not exist")
        }
    }
}