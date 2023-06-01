package com.slc2223.trakabumkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adamratzman.spotify.auth.implicit.startSpotifyImplicitLoginActivity
import com.slc2223.trakabumkt.databinding.ActivityLoginBinding

/**
 * This activity is the home screen of the application, responsible for handling Spotify authentication.
 * It initiates the Spotify authentication activity and handles the response from it.
 * @see <a href="https://developer.spotify.com/documentation/android/quick-start/#authenticating-with-spotify">Authenticating with Spotify</a>
 */
class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding // ViewBinding for the Activity

    /**
     * Initiates the Spotify authentication activity.
     * Creates the listener for the Spotify login button.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSpotifyLoginAct.setOnClickListener {
            startSpotifyImplicitLoginActivity<SpotifyImplicitLoginActivityImpl>() // Starts the authentication activity of Spotify
        }
    }
}