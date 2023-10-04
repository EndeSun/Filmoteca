package es.ua.eps.filmoteca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import es.ua.eps.filmoteca.databinding.ActivityFilmListBinding

class FilmListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFilmListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.filmA.setOnClickListener {
            val filmAListIntent = Intent(this@FilmListActivity, FilmDataActivity::class.java)

            filmAListIntent.putExtra("filmA", getString(R.string.watchFilmA))
            startActivity(filmAListIntent)
        }

        binding.filmB.setOnClickListener {
            val filmBListIntent = Intent(this@FilmListActivity, FilmDataActivity::class.java)
            filmBListIntent.putExtra("filmB", getString(R.string.watchFilmB))
            startActivity(filmBListIntent)
        }

        binding.about.setOnClickListener {
            val aboutIntent = Intent(this@FilmListActivity, AboutActivity::class.java)
            startActivity(aboutIntent)
        }
    }
}