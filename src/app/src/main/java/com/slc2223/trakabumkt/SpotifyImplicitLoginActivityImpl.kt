package com.slc2223.trakabumkt

import android.content.Intent
import android.widget.Toast
import com.adamratzman.spotify.SpotifyImplicitGrantApi
import com.adamratzman.spotify.SpotifyScope
import com.adamratzman.spotify.auth.implicit.AbstractSpotifyAppImplicitLoginActivity

class SpotifyImplicitLoginActivityImpl : AbstractSpotifyAppImplicitLoginActivity() {
    override val state: Int = 1337
    override val clientId: String = "2cf0773a0c4f48ca826b21c49a4bed02"
    override val redirectUri: String = "spotify-sdk://auth"
    override val useDefaultRedirectHandler: Boolean = false
    override fun getRequestingScopes(): List<SpotifyScope> = SpotifyScope.values().toList()

    override fun onSuccess(spotifyApi: SpotifyImplicitGrantApi) {
        val model = (application as SpotifyPlaygroundApplication).model
        model.credentialStore.setSpotifyApi(spotifyApi)
        toast(this, "Authentication completed correctly!", Toast.LENGTH_LONG)
        startActivity(Intent(this, DefaultActivity::class.java))
    }

    override fun onFailure(errorMessage: String) {
        toast(this, "Auth failed: $errorMessage", Toast.LENGTH_LONG)
    }
}