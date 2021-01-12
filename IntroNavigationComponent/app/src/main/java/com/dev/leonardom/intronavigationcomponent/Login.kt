package com.dev.leonardom.intronavigationcomponent

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Login(
        val modoJuego: String,
        val usuario: String,
        val contr: String
): Parcelable {

    override fun toString(): String {
        return "ModoJuego: $modoJuego\n\nUsuario: $usuario\n\ncontraseña: $contr"
    }

}