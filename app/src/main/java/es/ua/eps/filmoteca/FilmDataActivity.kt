package es.ua.eps.filmoteca

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import es.ua.eps.filmoteca.databinding.ActivityFilmDataBinding


class FilmDataActivity : AppCompatActivity() {

    private val MOVIE_RESULT=123


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFilmDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val receiveIntent = intent
        val movieA = receiveIntent.getStringExtra("filmA")
        val movieB = receiveIntent.getStringExtra("filmB")
        val relatedMovie = receiveIntent.getStringExtra("relatedFilm")

        if(movieA != null){
            binding.filmData.text = movieA
        }else if(movieB != null){
            binding.filmData.text = movieB
        }else{
            binding.filmData.text = relatedMovie
        }

        binding.watchRM.setOnClickListener {
            val filmDataIntent = Intent(this@FilmDataActivity, FilmDataActivity::class.java)
            filmDataIntent.putExtra("relatedFilm", getString(R.string.watchRelatedFilm) )
            startActivity(filmDataIntent)
        }


        //Cuando se le enviá al film edit
        binding.filmEdit.setOnClickListener {
            val filmEditIntent = Intent(this@FilmDataActivity, FilmEditActivity::class.java)
            if(Build.VERSION.SDK_INT >= 30) {
                startForResult.launch(filmEditIntent)
            }
            else {
                @Suppress("DEPRECATION")
                startActivityForResult(filmEditIntent, MOVIE_RESULT)
            }
        }

        binding.backToHome.setOnClickListener {
            val backToHomeIntent = Intent(this@FilmDataActivity, FilmListActivity::class.java)
            backToHomeIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(backToHomeIntent)
        }
    }

    private val startForResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                onActivityResult(MOVIE_RESULT, result.resultCode, result.data)
            }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        @Suppress("DEPRECATION")
        super.onActivityResult(requestCode, resultCode, data)
        val filmData = findViewById<TextView>(R.id.filmData)
        if(requestCode == MOVIE_RESULT){
            if (resultCode == Activity.RESULT_OK){
                filmData.text = getString(R.string.filmEdited)
            }
            else if(resultCode == Activity.RESULT_CANCELED){
                filmData.text = getString(R.string.filmCancel)
            }
        }
    }
}