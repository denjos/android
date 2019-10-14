package com.example.app01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_segundo.*

class SegundoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segundo)

//        val btn_prev=findViewById<Button>(R.id.btn_prev)
//        btn_prev.setOnClickListener {
//            val intent=Intent(this,MainActivity::class.java)
//            startActivity(intent)
//        }
        rcView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        val items= arrayListOf<ItemListPOJO>()
        (0..20).map {
            items.add(ItemListPOJO("Titulo ${it}","Desc ${it}","200"))
        }
        rcView.adapter=AdaptadorCarrito(items)

    }
}
