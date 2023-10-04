package es.ua.eps.filmoteca

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import es.ua.eps.filmoteca.databinding.ActivityFilmEditBinding


class FilmEditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFilmEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.save.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }

        binding.cancel.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

    }
}