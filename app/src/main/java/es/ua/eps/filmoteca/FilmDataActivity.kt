package es.ua.eps.filmoteca

import android.app.Instrumentation.ActivityResult
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import es.ua.eps.filmoteca.databinding.ActivityFilmDataBinding





class FilmDataActivity : AppCompatActivity() {
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


            private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                ActivityResult -> onActivityResult(MOVIE_RESULT, result.resultCode, result.data)
            }

            val intent = Intent(this@FilmDataActivity, FilmEditActivity::class.java)
            if(Build.VERSION.SDK.INT >= 30) {
                startForResult.launch(intent)
            }
            else {
                @Suppress("DEPRECATION")
                startActivityForResult(intent, MOVIE_RESULT)
            }

            override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
                @Suppress("DEPRECATION")
                super.onActivityResult(requestCode, resultCode, data)
                ...
            }



            startActivity(filmEditIntent)
            //startActivityFor(filmEditIntent)
        }

        binding.backToHome.setOnClickListener {
            val backToHomeIntent = Intent(this@FilmDataActivity, FilmListActivity::class.java)
            backToHomeIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(backToHomeIntent)
        }
    }
}