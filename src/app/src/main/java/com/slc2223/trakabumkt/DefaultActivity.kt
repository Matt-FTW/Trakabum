package com.slc2223.trakabumkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.adamratzman.spotify.models.SimpleAlbum
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.slc2223.trakabumkt.databinding.ActivityDefaultBinding
import kotlinx.coroutines.*

/**
 * This is the default activity that will be launched once the user has logged in correctly.
 */
class DefaultActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDefaultBinding // ViewBinding for the Activity
    private var albums: List<SimpleAlbum>? = emptyList() // List of albums found by the search
    private var currentAlbumIndex = 0 // Index of the current album being displayed

    /**
     * This method is called when the activity is created.
     * It creates the listeners for the buttons of searching and navigating through the album results.
     * @param savedInstanceState The saved instance state of the activity.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        binding = ActivityDefaultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSearch.setOnClickListener {
            searchAlbum(binding.txtAlbumName.text.toString())
        }

        binding.btnNext.setOnClickListener {
            if (albums?.isEmpty() == true || currentAlbumIndex + 1 >= albums?.count()!!) { // If there are no albums or the index is out of bounds
                toast(this, "There are no more albums.", Toast.LENGTH_SHORT)
                return@setOnClickListener
            }
            currentAlbumIndex++

            loadAlbum()
        }

        binding.btnPrevious.setOnClickListener {
            if (albums?.isEmpty() == true || currentAlbumIndex - 1 < 0) { // If there are no albums or the index is out of bounds
                toast(this, "You have the first album so you cannot go lower on the results.", Toast.LENGTH_SHORT)
                return@setOnClickListener
            }
            currentAlbumIndex--

            loadAlbum()
        }
    }

    /**
     * This method is called to search for an album using the Spotify API and gets the results to the albums list.
     * @param albumName The name of the album to search for.
     */
    private fun searchAlbum(albumName: String) {
        if (albumName.isEmpty()) {
            toast(this, "Please enter an album name...", Toast.LENGTH_SHORT)
            return
        }

        lifecycleScope.launch {
            albums = withContext(Dispatchers.IO) {
                guardValidSpotifyApi(classBackTo = SpotifyImplicitLoginActivityImpl::class.java) { api ->
                    api.search.searchAlbum(albumName).items
                }
            }

            if (albums?.isEmpty() == true) {
                toast(this@DefaultActivity, "No albums found.", Toast.LENGTH_SHORT)
                return@launch
            }

            withContext(Dispatchers.Main) {
                currentAlbumIndex = 0
                loadAlbum()
            }
        }
    }

    /**
     * This method is called to load the album information into the UI, based on the current album index.
     */
    private fun loadAlbum() {
        binding.lblAlbumName.text = albums!![currentAlbumIndex].artists[0].name
        binding.lblAlbumYear.text = albums!![currentAlbumIndex].releaseDate?.year.toString()
        Glide.with(applicationContext)
            .load(albums!![currentAlbumIndex].images[0].url)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(binding.imgAlbumCover)
    }
}
