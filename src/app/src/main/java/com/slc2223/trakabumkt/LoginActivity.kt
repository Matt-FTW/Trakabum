package com.slc2223.trakabumkt

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.adamratzman.spotify.GenericSpotifyApi
import com.adamratzman.spotify.SpotifyApi
import com.adamratzman.spotify.SpotifyClientApi
import com.adamratzman.spotify.auth.implicit.startSpotifyImplicitLoginActivity
import com.adamratzman.spotify.models.Token
import com.slc2223.trakabumkt.databinding.ActivityLoginBinding
import com.spotify.sdk.android.auth.AuthorizationClient
import com.spotify.sdk.android.auth.AuthorizationRequest
import com.spotify.sdk.android.auth.AuthorizationResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val CLIENT_ID = "2cf0773a0c4f48ca826b21c49a4bed02"
    private val REDIRECT_URI = "spotify-sdk://auth"
    private val REQUEST_CODE = 1337


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnOfflineLoginAct.setOnClickListener {
            startSpotifyImplicitLoginActivity<SpotifyImplicitLoginActivityImpl>()
        }
        binding.btnSpotifyLoginAct.setOnClickListener {
            val builder = AuthorizationRequest.Builder(CLIENT_ID, AuthorizationResponse.Type.TOKEN, REDIRECT_URI)
            builder.setScopes(arrayOf("user-read-private", "user-read-email"))
            val request = builder.build()
            AuthorizationClient.openLoginActivity(this, REQUEST_CODE, request)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            val response = AuthorizationClient.getResponse(resultCode, data)
            when (response.type) {
                AuthorizationResponse.Type.TOKEN -> {
                    // Autenticación exitosa
                    val accessToken = response.accessToken
                    Log.d(TAG, "Access token: $accessToken")
                }
                AuthorizationResponse.Type.ERROR -> {
                    // Autenticación fallida
                    val error = response.error
                    Log.d(TAG, "Auth error: $error")
                }
                else -> {
                    // Respuesta desconocida
                    Log.d(TAG, "Unknown auth response")
                }
            }
        }
    }

}