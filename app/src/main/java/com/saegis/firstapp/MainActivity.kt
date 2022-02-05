package com.saegis.firstapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val heightEditText = findViewById<EditText>(R.id.heightText)
        val weightEditText = findViewById<EditText>(R.id.weightText)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val resultText = findViewById<TextView>(R.id.resultText)

        calculateButton.setOnClickListener {
            if (heightEditText.text.isNullOrEmpty() || weightEditText.text.isNullOrEmpty()) {
                Toast.makeText(this, R.string.validation, Toast.LENGTH_SHORT).show()
            } else {
                val heightValue: Float = heightEditText.text.toString().toFloat()
                val weightValue: Float = weightEditText.text.toString().toFloat()
                val bmiValue = generateBmi(heightValue, weightValue)
                resultText.text = getString(R.string.bm_result, "%.2f".format(bmiValue))
            }
        }
    }

    private fun generateBmi(height: Float, weight: Float): Float =
        (weight / height / height) * 1000
}