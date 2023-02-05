package com.example.tabladeanuncioskotlin.utils

import android.content.Context
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

object CityHelper {
    fun getAllCountries(contex:Context):ArrayList<String>{
        var tempArray = ArrayList<String>()

        try {

            val inputStream : InputStream = contex.assets.open("countriesToCities.json")
            val size : Int = inputStream.available()
            val bytesArray = ByteArray(size)
            inputStream.read(bytesArray)
            val jsonFile = String(bytesArray)
            val jsonObject = JSONObject(jsonFile)
            val countriesName = jsonObject.names()
            if (countriesName != null){
            for (n in 0 until countriesName.length()){
                tempArray.add(countriesName.getString(n))
                }
            }

        }catch (e:IOException){


        }
        return tempArray


    }



}