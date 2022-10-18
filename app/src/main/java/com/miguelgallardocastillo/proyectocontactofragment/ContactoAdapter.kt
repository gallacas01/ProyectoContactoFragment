package com.miguelgallardocastillo.proyectocontactofragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.miguelgallardocastillo.proyectocontactofragment.databinding.ItemListBinding

class ContactoAdapter(val contactos: List<Contacto>, val listener: (Contacto) -> Unit) : RecyclerView.Adapter<ContactoAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        //Inflamos la vista, es decir, el contacto.
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val contactoActual = contactos[position]
        holder.bind(contactoActual)
        holder.itemView.setOnClickListener{
            listener(contactoActual)
        }
    }

    override fun getItemCount(): Int {
        return contactos.size
    }

    class ViewHolder (private val view: View) : RecyclerView.ViewHolder(view){

        val binding = ItemListBinding.bind(view)
        fun bind (contacto: Contacto){

            binding.nombreContacto.text = contacto.nombre
            binding.telContacto.text = contacto.tel
            binding.emailContacto.text = contacto.correo
            binding.imagenContacto.glide(contacto.imagen)
        }
    }

}//Fin de la clase ContactosAdapter.

    fun ImageView.glide(url: String){
    Glide.with(this).load(url).into(this)

}