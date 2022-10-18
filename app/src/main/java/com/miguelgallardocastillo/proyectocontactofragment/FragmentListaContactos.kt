package com.miguelgallardocastillo.proyectocontactofragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.miguelgallardocastillo.proyectocontactofragment.databinding.FragmentListaContactosBinding


//Inflamos la vista en el constructor.
class FragmentListaContactos : Fragment(R.layout.fragment_lista_contactos) {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    val listaContactos = listOf(
            Contacto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT_c8oKklgkak8-CTVMkZKFs33eNSIRaB1UHBKOksQUYAJn2l5iSzBgLhf3BIcJfzjhFH0&usqp=CAU", "Miguel Gallardo Castillo", "653789274", "miguelgc01@gmail.com"),
        Contacto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT_c8oKklgkak8-CTVMkZKFs33eNSIRaB1UHBKOksQUYAJn2l5iSzBgLhf3BIcJfzjhFH0&usqp=CAU", "María Gómez López", "635790524", "correomargia@gmail.com"),
        Contacto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT_c8oKklgkak8-CTVMkZKFs33eNSIRaB1UHBKOksQUYAJn2l5iSzBgLhf3BIcJfzjhFH0&usqp=CAU", "Pablo Pérez Rodríguez", "680755294", "pablocorreo@gmail.com"),
        Contacto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT_c8oKklgkak8-CTVMkZKFs33eNSIRaB1UHBKOksQUYAJn2l5iSzBgLhf3BIcJfzjhFH0&usqp=CAU", "Manuela Herrera Castillo", "955728920", "correoManuela@gmail.com")
    )


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentListaContactosBinding.bind(view)
        binding.recycler.adapter = ContactoAdapter (listaContactos){
            contacto ->  navigateTo(contacto)
        }

    }

    //Creamos el método navigateTo al que le indicaremos el fragment al que debe cambiar el recycler view cuando pulsemos en un contacto (que será el
    // DetailFragment)
    private fun navigateTo(contacto: Contacto) {
        //El fragment que reemplazamos.
        val fragment = DetailFragment()
        fragment.arguments = bundleOf(DetailFragment.EXTRA_CONTACTO to contacto)

        parentFragmentManager.beginTransaction()
        .setCustomAnimations(R.anim.slide_right_in,
        R.anim.slide_left_out,
        R.anim.slide_left_in,
        R.anim.slide_right_out)
        .replace(R.id.fragmentContainerView, fragment)
        .setReorderingAllowed(true)
        .addToBackStack(null)
        .commit()
    }


}