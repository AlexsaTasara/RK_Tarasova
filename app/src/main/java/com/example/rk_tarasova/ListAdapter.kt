package com.example.rk_tarasova
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

 class CustomListAdapter : RecyclerView.Adapter<CustomListAdapter.ElemViewHolder>(){

     var data = listOf<String>()
         set(value){
             field = value
             notifyDataSetChanged()
         }
     override fun getItemCount() = data.size
     override fun onBindViewHolder(holder: ElemViewHolder, position: Int) {
         val item = data[position]
         holder.setData(item)
     }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElemViewHolder {
         return ElemViewHolder.from(parent)
     }

     class ElemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
         val textViewRow: TextView = itemView.findViewById(R.id.kript_item)
         fun setData(item: String){
            textViewRow.text = item
         }
        companion object{
            fun from(parent: ViewGroup): ElemViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.list_item, parent, false)
                return ElemViewHolder(view)
            }
        }
    }
}