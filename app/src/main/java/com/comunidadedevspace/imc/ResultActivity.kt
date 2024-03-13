package com.comunidadedevspace.imc

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassification = findViewById<TextView>(R.id.tv_classification)
        tvResult.text = result.toString()

        val classification: String
        val cor: Int
        when {
            result <= 18.5f -> {
                classification = "UNDERWEIGHT"
                cor = Color.RED
            }

            result <= 24.9f -> {
                classification = "NORMAL"
                cor = Color.GREEN
            }

            result <= 29.9f -> {
                classification = "OVERWEIGHT"
                cor = Color.YELLOW
            }

            result <= 39.9f -> {
                classification = "OBESITY"
                cor = Color.RED
            }

            else -> {
                classification = "SEVERE OBESITY "
                cor = Color.RED
            }

        }


        tvClassification.text = classification
        tvClassification.setTextColor(cor)
    }
}