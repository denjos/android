package com.example.app01

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

data class Curso(val nombre:String, val url:String)

class MainActivity : Activity() {

    val react=Curso("React","react")
    val kot=Curso("Kotlin","kotlin")
    var actual=react.copy()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn=findViewById<Button>(R.id.btn)
        btn.setOnClickListener{
            view -> cambiar()
        }
        ver(actual)



        val btn_next=findViewById<Button>(R.id.btn_next)
        btn_next.setOnClickListener {
            val intent=Intent(this,SegundoActivity::class.java)
            startActivity(intent)
        }
    }

    fun cambiar()
    {
        when(actual.url)
        {
            "react"->actual=kot.copy()
            "kotlin"->actual=react.copy()
        }
        ver(actual)
    }
    fun ver(curso:Curso) {
        val txt=findViewById<TextView>(R.id.mensaje)
        txt.setText("Curso de ${curso.nombre}, link test.com/${curso.url}")
    }
}
