package com.slc2223.trakabumkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.adamratzman.spotify.models.SimpleAlbum
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.slc2223.trakabumkt.databinding.ActivityDefaultBinding
import kotlinx.coroutines.*

class DefaultActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDefaultBinding
    private var albums: List<SimpleAlbum>? = emptyList()
    private var currentAlbumIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDefaultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSearch.setOnClickListener {
            searchAlbum(binding.txtAlbumName.text.toString())
        }

        binding.btnNext.setOnClickListener {
            if (albums?.isEmpty() == true || currentAlbumIndex + 1 >= albums?.count()!!) {
                toast(this, "There are no more albums.", Toast.LENGTH_SHORT)
                return@setOnClickListener
            }
            currentAlbumIndex++

            loadAlbum()
        }

        binding.btnPrevious.setOnClickListener {
            if (albums?.isEmpty() == true || currentAlbumIndex - 1 < 0) {
                toast(this, "You have the first album so you cannot go lower on the results.", Toast.LENGTH_SHORT)
                return@setOnClickListener
            }
            currentAlbumIndex--

            loadAlbum()
        }
    }

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

    private fun loadAlbum() {
        binding.lblAlbumName.text = albums!![currentAlbumIndex].artists[0].name
        binding.lblAlbumYear.text = albums!![currentAlbumIndex].releaseDate?.year.toString()
        Glide.with(applicationContext)
            .load(albums!![currentAlbumIndex].images[0].url)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(binding.imgAlbumCover)
    }
}
