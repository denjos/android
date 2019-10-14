package com.example.app02

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView=findViewById<ListView>(R.id.lvMain)
        //val color=Color.parseColor("#FF0000")
       // listView.setBackgroundColor(color)
        lvMain.adapter=MyCustomAdapter(this)
    }

    private class MyCustomAdapter(context : Context):BaseAdapter(){
        private val mContext:Context

        init{
            mContext=context
        }

        private val names= arrayListOf<String>(
            "oscar",
            "javier",
            "campos",
            "herrera"
        )
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//            val textView=TextView(mContext)
//            textView.text="row of my listview"
//            return  textView
            val layoutInflater=LayoutInflater.from(mContext)
            val row=layoutInflater.inflate(R.layout.main_row, parent,false)
            val txtPrimero=row.findViewById<TextView>(R.id.txtPrimero)
            val txtSegundo=row.findViewById<TextView>(R.id.txtsegundo)
            txtPrimero.text=names.get(position)
            txtSegundo.text="Position ${position}"

            return row
        }
        override fun getItem(position: Int): Any {
            return "Test string"
        }
        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int = names.size
    }
}
