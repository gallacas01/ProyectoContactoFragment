package com.miguelgallardocastillo.proyectocontactofragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.miguelgallardocastillo.proyectocontactofragment.databinding.FragmentDetailContactoBinding
import com.miguelgallardocastillo.proyectocontactofragment.databinding.FragmentListaContactosBinding

class DetailFragment : Fragment(R.layout.fragment_detail_contacto) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentDetailContactoBinding.bind(view)

        val contacto = arguments?.getParcelable<Contacto>(EXTRA_CONTACTO)
        if (contacto != null) {

            binding.nombreContacto.text = contacto.nombre
            binding.imagenContacto.glide(contacto.imagen)

            binding.callButton.setOnClickListener{
                val telIntent =  Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + contacto.tel))
                startActivity(telIntent)
            }

            binding.emailButton.setOnClickListener{

                val uri = Uri.parse("mailto:" + contacto.correo)
                val emailIntent = Intent(
                    Intent.ACTION_SENDTO, uri
                )
                startActivity(emailIntent)
            }

        }
    }



    companion object {
        //El valor de esta constante es estática.
        const val EXTRA_CONTACTO = "EXTRA_CONTACTO"

        //Creamos una función
        fun create (contacto: Contacto){

        }
    }




}
