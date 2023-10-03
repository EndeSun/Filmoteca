package es.ua.eps.filmoteca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
//import android.widget.Button
//import android.widget.TextView
// import android.widget.Button
import android.widget.Toast
import es.ua.eps.filmoteca.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onFuncionalidadClick(view: View){
        // val button = findViewById<Button>(R.id.button3) así se toma una referencia de los componentes de la actividad para importar alt + enter

        mostrarToast(getString(R.string.message))
    }
    private fun mostrarToast(mensaje:String){
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }
}