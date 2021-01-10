package com.dev.leonardom.intronavigationcomponent

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class GameModeDialog: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val gameModeOptions = arrayOf("Modo 1", "Modo 2", "Modo 3", "Modo 4")
        var optionSelected = gameModeOptions[0]

        return activity?.let {
            val builder = AlertDialog.Builder(it)

            builder
                .setTitle("Dialogo de Prueba")
                .setSingleChoiceItems(gameModeOptions, 0){ dialog, posicion ->
                    optionSelected = gameModeOptions[posicion]
                }
                .setPositiveButton("ACEPTAR") { dialog, id ->

                }
                .setNegativeButton("CANCELAR"){ dialog, id ->
                    dialog.dismiss()
                }

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")

    }
}

