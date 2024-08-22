package com.example.conversionnumeros
import android.os.Bundle
import android.widget.Button

import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a los elementos de la vista
        val numeroEntrada = findViewById<EditText>(R.id.numeroEntrada)
        val botonConvertir = findViewById<Button>(R.id.botonConvertir)
        val resultadoConversion = findViewById<TextView>(R.id.resultadoConversion)
        val opcionesConversion = findViewById<RadioGroup>(R.id.opcionesConversion)

        botonConvertir.setOnClickListener {
            // Obtener el valor introducido y seleccionar la opción de conversión
            val numero = numeroEntrada.text.toString().toIntOrNull()
            val opcionSeleccionada = opcionesConversion.checkedRadioButtonId

            if (numero != null) {
                val resultado = when (opcionSeleccionada) {
                    R.id.radioBinario -> convertirABinario(numero)
                    R.id.radioOctal -> convertirAOctal(numero)
                    R.id.radioHexadecimal -> convertirAHexadecimal(numero)
                    else -> "Selecciona una opción"
                }
                resultadoConversion.text = "El resultado es: $resultado"
            } else {
                resultadoConversion.text = "Por favor, introduce un número válido."
            }
        }
    }

    // Métodos para convertir el número
    private fun convertirABinario(numero: Int): String {
        var num = numero
        val resultado = StringBuilder()
        while (num > 0) {
            val residuo = num % 2
            resultado.insert(0, residuo)
            num /= 2
        }
        return resultado.toString()
    }

    private fun convertirAOctal(numero: Int): String {
        var num = numero
        val resultado = StringBuilder()
        while (num > 0) {
            val residuo = num % 8
            resultado.insert(0, residuo)
            num /= 8
        }
        return resultado.toString()
    }

    private fun convertirAHexadecimal(numero: Int): String {
        val hexChars = "0123456789ABCDEF"
        var num = numero
        val resultado = StringBuilder()
        while (num > 0) {
            val residuo = num % 16
            resultado.insert(0, hexChars[residuo])
            num /= 16
        }
        return resultado.toString()
    }
}

