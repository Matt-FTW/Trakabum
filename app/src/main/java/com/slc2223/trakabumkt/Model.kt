package com.slc2223.trakabumkt

import com.adamratzman.spotify.auth.SpotifyDefaultCredentialStore

object Model {
    val credentialStore by lazy {
        SpotifyDefaultCredentialStore(
            clientId = "2cf0773a0c4f48ca826b21c49a4bed02",
            redirectUri = "spotify-sdk://auth",
            applicationContext = SpotifyPlaygroundApplication.context
        )
    }
}