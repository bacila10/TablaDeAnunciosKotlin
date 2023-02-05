package com.example.tabladeanuncioskotlin.act

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.tabladeanuncioskotlin.databinding.ActivityEditAdsBinding
import com.example.tabladeanuncioskotlin.utils.CityHelper

class EditAdsAct : AppCompatActivity() {
    private lateinit var rootElement : ActivityEditAdsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rootElement = ActivityEditAdsBinding.inflate(layoutInflater)
        setContentView(rootElement.root)

        val adapter = ArrayAdapter(this,
            android.R.layout.simple_spinner_item, CityHelper.getAllCountries(this))
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            rootElement.spCountry.adapter = adapter
    }
}