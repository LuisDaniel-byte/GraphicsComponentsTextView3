package com.example.graphicscomponents4

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyFirstActivity : Activity() {
    lateinit var tvContador : TextView
    lateinit var btnBoton : Button
    lateinit var lvLista : ListView
    var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_my_first)

        tvContador = findViewById(R.id.tvContador)
        btnBoton = findViewById(R.id.btnBoton)

        btnBoton.setOnClickListener{
            contador++
            tvContador.text = contador.toString()
            Toast.makeText(this, contador.toString() , Toast.LENGTH_LONG).show()
        }

        var lista = listOf<String>("Luis","Daniel","Vargas","Rodriguez")

        lvLista = findViewById(R.id.lvLista)

        //var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,lista)
        var adapter = AdapterList( this,lista)
        lvLista.adapter = adapter
    }

    override fun onResume()  {
        super.onResume()

    }

    class AdapterList(val context : Context, var lista : List<String> ) : BaseAdapter() {
        override fun getCount(): Int {
            return lista.size
        }

        override fun getItem(p0: Int): Any {
            return lista[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var vista: View
            var holder: ViewHolder = ViewHolder()


            vista = LayoutInflater.from(context).inflate(R.layout.item_lista, p2, false)
            holder.tvItem = vista.findViewById(R.id.tvItem)
            vista.tag = holder


            var nombre = lista[p0]
            holder.tvItem?.text = nombre

            return vista
        }


    }

     class ViewHolder {
         var tvItem: TextView? = null
     }
}

