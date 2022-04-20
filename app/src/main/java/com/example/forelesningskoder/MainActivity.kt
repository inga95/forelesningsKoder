package com.example.forelesningskoder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.StringRequestListener
import org.json.JSONObject


class MainActivity : AppCompatActivity() {

    val imageList = ArrayList<ImagesApi>()
    private lateinit var searchBtn: Button
    private lateinit var imagesRV: RecyclerView

    //var imageUri: String? = null
    private var imageInfo = ArrayList<ImageInfo>()


    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val url = URL("http://api-edu.gtl.ai/api/v1/imagesearch/bing?url=https://gtl-bucket.s3.amazonaws.com/4e9683c5e0f34b17ac0d1b0e984fd930.jpg")
        thread {
            with(url.openConnection() as HttpURLConnection){
                requestMethod = "GET"

                inputStream.bufferedReader().lines().forEach{
                    val json: JSONArray = JSONArray(it)

                    for (index in 0 until json.length()){
                        val imageurl: String = (json.get(index) as JSONObject).get("image_link").toString()

                        Log.i(Globals.TAG, imageurl)

                        imageInfo.add(ImageInfo(
                            imageurl, -1, -1, -1, -1, -1
                        ))
                    }
                }
            }
        }*/


        //init views

        /*imagesRV = findViewById(R.id.imagesRecyclerView)
        searchBtn = findViewById(R.id.searchBtn)

        //Setting up Staggered Layout manager
        imagesRV.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)

        searchBtn.setOnClickListener{
            //get text from editText
            //var name = dogNameText.text.toString()

            //call search Dog function
            searchImages()
        }*/

    }

    fun switchFragment(v: View) {
        Log.i(Globals.TAG, "Activity 1 switchFragment. Tag: " + v.getTag().toString())
        Toast.makeText(
            this,
            "Activity switchFragment. Tag" + v.getTag().toString(),
            Toast.LENGTH_SHORT
        ).show()

        fragmentManager = supportFragmentManager

        if (Integer.parseInt(v.getTag().toString()) == 1) {
            fragmentManager
                .beginTransaction()
                .replace(
                    R.id.fragment_main,
                    Fragment1(),
                    "Fragment1"
                )
                .commit()
        } /*else if (Integer.parseInt(v.getTag().toString()) == 2) {
            fragmentManager
                .beginTransaction()
                .replace(
                    R.id.fragment_main,
                    Fragment2(),
                    "Fragment2"
                )
                .commit()
        }*/

    /*else if{
                fragmentManager
                    .beginTransaction()
                    .replace(
                        R.id.fragment_main,
                        Fragment2(studentsInfo),
                        "Fragment2"
                    )
                    .commit()
            }*/
    }

    /*fun submit(view: View){

            var imageUri = (fragmentManager.findFragmentByTag("Fragment1") as Fragment1).imageUri.toString()

            //var rect = (fragmentManager.findFragmentByTag("Fragment1") as Fragment1).image.actualCropRect
           // Toast.makeText(this, "Added New Student", Toast.LENGTH_SHORT).show()
        }*/

}
