package com.example.app01

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

class  AdaptadorCarrito(val data:List<ItemListPOJO>) : RecyclerView.Adapter<AdaptadorCarrito.Holder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
        Holder(ItemList().createView(AnkoContext.Companion.create(parent!!.context,this,false)))
    override fun getItemCount(): Int =data.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bindView(data[position])
    }

    class Holder(itemView:View):RecyclerView.ViewHolder(itemView){
        val txtViewTitle by lazy{
            itemView.find<TextView>(R.id.txtTitleItem)
        }
        val txtViewDesc by lazy{
            itemView.find<TextView>(R.id.txtDescItem)
        }
        val txtViewPrice by lazy{
            itemView.find<TextView>(R.id.txtPriceItem)
        }
        fun bindView(item:ItemListPOJO){
            with(item){
                txtViewTitle.text=titulo
                txtViewDesc.text=desc
                txtViewPrice.text=price
            }
        }

 }
}