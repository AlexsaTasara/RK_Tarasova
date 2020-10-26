package com.example.rk_tarasova

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.TextView

class CustomAdapter(context: Context,arrayListDetails:ArrayList<Model>) : BaseAdapter(){
    private val layoutInflater: LayoutInflater
    private val arrayListDetails:ArrayList<Model>
    init {
        this.layoutInflater = LayoutInflater.from(context)
        this.arrayListDetails = arrayListDetails
    }
    override fun getCount(): Int {
        return arrayListDetails.size
    }
    override fun getItem(position: Int): Any {
        return arrayListDetails.get(position)
    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val view: View?
        val listRowHolder: ListRowHolder
        if (convertView == null) {
            view = this.layoutInflater.inflate(R.layout.adapter_layout, parent, false)
            listRowHolder = ListRowHolder(view)
            view.tag = listRowHolder
        } else {
            view = convertView
            listRowHolder = view.tag as ListRowHolder
        }
        listRowHolder.newsName.text = arrayListDetails.get(position).name
        listRowHolder.newsAuthor.text = arrayListDetails.get(position).author
        listRowHolder.newsTitle.text = arrayListDetails.get(position).title
        return view
    }
}

private class ListRowHolder(row: View?) {
    public val newsName: TextView
    public val newsAuthor: TextView
    public val newsTitle: TextView
    public val linearLayout: LinearLayout
    init {
        this.newsName = row?.findViewById<TextView>(R.id.newsName) as TextView
        this.newsAuthor = row?.findViewById<TextView>(R.id.newsAuthor) as TextView
        this.newsTitle = row?.findViewById<TextView>(R.id.newsTitle) as TextView
        this.linearLayout = row?.findViewById<LinearLayout>(R.id.linearLayout) as LinearLayout
    }
}