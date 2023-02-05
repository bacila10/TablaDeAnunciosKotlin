package com.example.tabladeanuncioskotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.example.tabladeanuncioskotlin.act.EditAdsAct
import com.example.tabladeanuncioskotlin.databinding.ActivityMainBinding
import com.example.tabladeanuncioskotlin.dialoghelper.DialogConst
import com.example.tabladeanuncioskotlin.dialoghelper.DialogHelper
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var rootElement:ActivityMainBinding
    private var dialogHelper = DialogHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rootElement = ActivityMainBinding.inflate(layoutInflater)
        setContentView(rootElement.root)
        init()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.id_new_ads){
            val i = Intent(this, EditAdsAct::class.java)
            startActivity(i)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun init(){
        setSupportActionBar(rootElement.mainContent.toolbar)
        val toogle = ActionBarDrawerToggle(this,rootElement.drawerLayout, rootElement.mainContent.toolbar,R.string.open,R.string.close)
//drawerLayout.addDrawerListener(toogle)
        rootElement.drawerLayout.addDrawerListener(toogle)
        toogle.syncState()
        rootElement.navView.setNavigationItemSelectedListener (this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
       when(item.itemId) {
           R.id.id_my_ads -> {
               Toast.makeText(this, "Paspaustas id_my_ads", Toast.LENGTH_SHORT).show()
           }
           R.id.id_car -> {
               Toast.makeText(this, "Paspaustas id_car", Toast.LENGTH_SHORT).show()
           }
           R.id.id_pc -> {
               Toast.makeText(this, "Paspaustas id_pc", Toast.LENGTH_SHORT).show()
           }
           R.id.id_smartphone -> {
               Toast.makeText(this, "Paspaustas id_smartphone", Toast.LENGTH_SHORT).show()
           }
           R.id.id_dm -> {
               Toast.makeText(this, "Paspaustas id_dm", Toast.LENGTH_SHORT).show()
           }
           R.id.id_sign_up -> {
              dialogHelper.createSignDialog(DialogConst.SIGN_UP_STATE)
           }
           R.id.id_sign_in -> {
               dialogHelper.createSignDialog(DialogConst.SIGN_IN_STATE)
           }
           R.id.id_sign_out -> {
               Toast.makeText(this, "Paspaustas id_sign_out", Toast.LENGTH_SHORT).show()
           }
       }
        rootElement.drawerLayout.closeDrawer(GravityCompat.START)
            return true
    }


}