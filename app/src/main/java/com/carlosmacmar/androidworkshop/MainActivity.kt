package com.carlosmacmar.androidworkshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.carlosmacmar.androidworkshop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            etNombre.setOnFocusChangeListener { v, hasFocus ->
                if(!hasFocus && etNombre.text.isNotEmpty()){
                    pbProgreso.progress += 33
                }
            }

            etEmail.setOnFocusChangeListener { v, hasFocus ->
                if(!hasFocus && etEmail.text.isNotEmpty()){
                    pbProgreso.progress += 33
                }
            }

            cbCondiciones.setOnCheckedChangeListener { buttonView, isChecked ->
                if(isChecked){
                    pbProgreso.progress += 33
                } else {
                    pbProgreso.progress -= 33
                }
            }

            btEnviar.setOnClickListener {
                pbProgreso.progress = 0
                etNombre.text.clear()
                etEmail.text.clear()
                cbCondiciones.isChecked = false

                Toast.makeText(this@MainActivity, "Datos enviados correctamente", Toast.LENGTH_LONG).show()
            }
        }
    }
}
