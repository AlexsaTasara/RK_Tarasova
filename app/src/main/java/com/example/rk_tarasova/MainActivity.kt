package com.example.rk_tarasova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

private lateinit var recyclerView: RecyclerView
private lateinit var viewAdapter: RecyclerView.Adapter<*>
private lateinit var viewManager: RecyclerView.LayoutManager

class MainActivity : AppCompatActivity() {
    lateinit var listView_details: ListView
    var arrayList_details: ArrayList<Model> = ArrayList();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myDataSet: List<String> = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
            .map { it -> "item $it" }
        viewManager = LinearLayoutManager(this)
        viewAdapter = CustomListAdapter()
        (viewAdapter as CustomListAdapter).data = myDataSet

        recyclerView = findViewById<RecyclerView>(R.id.my_recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
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
}