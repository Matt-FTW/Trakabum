package com.slc2223.trakabumkt

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.compose.setContent

class DefaultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_default)
        /*
        button.setOnClickListener {
            var albums = guardValidSpotifyApi(classBackTo = SpotifyImplicitLoginActivityImpl::class.java) { api ->
                api.search.searchAlbum("Lateralus").items
            }

            if (albums != null)
                nombre.text = albums[0].artists[0].name
        }*/
    }
}

