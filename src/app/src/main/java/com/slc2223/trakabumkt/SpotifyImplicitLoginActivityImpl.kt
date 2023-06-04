package com.slc2223.trakabumkt

import android.content.Intent
import android.widget.Toast
import com.adamratzman.spotify.SpotifyImplicitGrantApi
import com.adamratzman.spotify.SpotifyScope
import com.adamratzman.spotify.auth.implicit.AbstractSpotifyAppImplicitLoginActivity

/**
 * This class is used to handle the implicit grant flow as well as to authenticate the user and get the access token.
 */
class SpotifyImplicitLoginActivityImpl : AbstractSpotifyAppImplicitLoginActivity() {
    override val state: Int = 1337 // This is used to prevent CSRF attacks, read more in the docs.
    override val clientId: String = "2cf0773a0c4f48ca826b21c49a4bed02" // This is the client id of the app in the Spotify Dashboard.
    override val redirectUri: String = "spotify-sdk://auth" // This is the redirect URI of the app in the Spotify Dashboard.
    override val useDefaultRedirectHandler: Boolean = false // This is used to prevent the SDK from automatically handling the redirect URI.
    override fun getRequestingScopes(): List<SpotifyScope> = SpotifyScope.values().toList() // This is used to request the scopes that the app needs.

    /**
     * This method is called when the authentication is completed successfully.
     * @param spotifyApi The Spotify API instance that can be used to make requests.
     */
    override fun onSuccess(spotifyApi: SpotifyImplicitGrantApi) {
        val model = (application as SpotifyPlaygroundApplication).model
        model.credentialStore.setSpotifyApi(spotifyApi)
        toast(this, "Authentication completed correctly!", Toast.LENGTH_LONG)
        startActivity(Intent(this, DefaultActivity::class.java))
    }

    /**
     * This method is called when the authentication fails.
     * @param errorMessage The error message.
     */
    override fun onFailure(errorMessage: String) {
        toast(this, "Auth failed: $errorMessage", Toast.LENGTH_LONG)
    }
}