package com.miguelgallardocastillo.proyectocontactofragment

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Contacto (val imagen:String, val nombre:String, val tel: String, val correo: String): Parcelable {



}