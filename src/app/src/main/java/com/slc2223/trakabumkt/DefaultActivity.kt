package com.slc2223.trakabumkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.slc2223.trakabumkt.databinding.ActivityDefaultBinding

class DefaultActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDefaultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDefaultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSearch.setOnClickListener {
            var albums =
                guardValidSpotifyApi(classBackTo = SpotifyImplicitLoginActivityImpl::class.java) { api ->
                    api.search.searchTrack(binding.txtAlbumName.text.toString()).items
                }

            if (albums != null)
                binding.lblAlbumName.text = albums[0].artists[0].name
        }
    }
}

