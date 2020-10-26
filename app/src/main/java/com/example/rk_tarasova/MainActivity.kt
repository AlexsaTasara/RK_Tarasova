package com.example.rk_tarasova

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rk_tarasova.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList
private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var listView_details: ListView
    var arrayList_details: ArrayList<Model> = ArrayList();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = this.findNavController(R.id.test_nav_frag)
        NavigationUI.setupActionBarWithNavController(this,navController)
        //setContentView(R.layout.activity_main)
        //val randomIntent = Intent(this, ChildActivity::class.java)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val item_id = item.getItemId()
        if (item_id == R.id.action_settings){
            Toast.makeText(this, "@string/sett_click", Toast.LENGTH_LONG).show()
            return true
        }
        if(item_id==R.id.language_settings){
            if(resources.configuration.locales.get(0) == Locale("ru")){
                resources.configuration.setLocale(Locale("en"))
                resources.updateConfiguration(resources.configuration, null)
                recreate()
                return true
            }else {
                resources.configuration.setLocale(Locale("ru"))
                resources.updateConfiguration(resources.configuration, null)
                recreate()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
        if(item_id==R.id.refresh_settings){
            recreate()
            return true
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.test_nav_frag)
        return navController.navigateUp()
    }
}