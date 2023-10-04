package es.ua.eps.filmoteca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import es.ua.eps.filmoteca.databinding.ActivityFilmEditBinding
import android.view.View

class FilmEditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFilmEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.save.setOnClickListener {
            RESULT_OK
        }

        binding.cancel.setOnClickListener {
            RESULT_CANCELED
        }

    }
}