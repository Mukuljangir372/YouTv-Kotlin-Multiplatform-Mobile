package com.mukul.youtv.android

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.mukul.youtv.Greeting
import com.mukul.youtv.graph.RepositoryGraph
import com.mukul.youtv.shared.common.models.movie.MovieCategory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val view = findViewById<TextView>(R.id.text_view)
        val graph = RepositoryGraph()

        CoroutineScope(Dispatchers.Main).launch {
            graph.getMovieListRepo().getMovies(
                category = MovieCategory.Popular,
                shouldFetch = true
            ).watch({
                runOnUiThread {
                    view.text = "movie state = ${it.data}"
                }

                print("movie result data = ${it.data}")
            },{
                runOnUiThread {
                    view.text = "movie state = ${it}"
                }
                print("movie state = error")
            })
        }

    }
}
