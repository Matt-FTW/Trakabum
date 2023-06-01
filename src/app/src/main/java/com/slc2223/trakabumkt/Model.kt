package com.slc2223.trakabumkt

import com.adamratzman.spotify.auth.SpotifyDefaultCredentialStore

/**
 * This is a singleton object that holds the [SpotifyDefaultCredentialStore] instance.
 * Basically, this is used to store the Spotify app credentials across the application for searching functionality.
 */
object Model {
    val credentialStore by lazy {
        SpotifyDefaultCredentialStore(
            clientId = "2cf0773a0c4f48ca826b21c49a4bed02", // Client ID of the app in the Spotify Developer Dashboard
            redirectUri = "spotify-sdk://auth", // Redirect URI of the app in the Spotify Developer Dashboard
            applicationContext = SpotifyPlaygroundApplication.context // Context of the Spotify Playground application
        )
    }
}