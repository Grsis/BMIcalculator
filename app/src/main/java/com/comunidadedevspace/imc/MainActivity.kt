package com.comunidadedevspace.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtweight = findViewById<TextInputEditText>(R.id.edt_weight)
        val edtheight = findViewById<TextInputEditText>(R.id.edt_height)

        val btnCalculate = findViewById<Button>(R.id.btn_calculate)

        btnCalculate.setOnClickListener {


            val weightStr: String = edtweight.text.toString()
            val heightStr: String = edtheight.text.toString()

            if (weightStr == "" || heightStr == "") {
                Snackbar
                    .make(
                        edtweight,
                        "Fill in the empty fields",
                        Snackbar.LENGTH_LONG
                    )
                    .show()
            } else {

                val weight = weightStr.toFloat()
                val height = heightStr.toFloat()

                val heightQ2 = height * height
                val resultado = weight / heightQ2


                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(KEY_RESULT_IMC, resultado)
                startActivity(intent)

            }
        }
    }
}