package com.example.conversionnumeros

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtener referencias de los elementos de la vista
        val numeroEntrada = findViewById<TextView>(R.id.numeroEntrada)
        val radioGroup = findViewById<RadioGroup>(R.id.opcionesConversion)
        val botonConvertir = findViewById<Button>(R.id.botonConvertir)
        val resultadoConversion = findViewById<TextView>(R.id.resultadoConversion)

        botonConvertir.setOnClickListener {
            val numero = numeroEntrada.text.toString().toIntOrNull()

            if (numero != null) {
                val seleccionId = radioGroup.checkedRadioButtonId

                val resultado = when (seleccionId) {
                    R.id.radioBinario -> convertirABinario(numero)
                    R.id.radioOctal -> convertirAOctal(numero)
                    R.id.radioHexadecimal -> convertirAHexadecimal(numero)
                    else -> "Selecciona una opción de conversión"
                }

                resultadoConversion.text = resultado
            } else {
                resultadoConversion.text = "Por favor, introduce un número válido"
            }
        }
    }

    // Método para convertir un número a binario
    private fun convertirABinario(numero: Int): String {
        var numero = numero
        val resultado = StringBuilder()

        do {
            val residuo = numero % 2
            resultado.insert(0, residuo)
            numero /= 2
        } while (numero > 0)

        return resultado.toString()
    }

    // Método para convertir un número a octal
    private fun convertirAOctal(numero: Int): String {
        var numero = numero
        val resultado = StringBuilder()

        do {
            val residuo = numero % 8
            resultado.insert(0, residuo)
            numero /= 8
        } while (numero > 0)

        return resultado.toString()
    }

    // Método para convertir un número a hexadecimal
    private fun convertirAHexadecimal(numero: Int): String {
        var numero = numero
        val resultado = StringBuilder()
        val hexChars = "0123456789ABCDEF"

        do {
            val residuo = numero % 16
            resultado.insert(0, hexChars[residuo])
            numero /= 16
        } while (numero > 0)

        return resultado.toString()
    }
}
