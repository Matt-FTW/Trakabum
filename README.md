
<div align="center" style="margin: 30px;">
<a href="https://www.youtube.com/watch?v=dQw4w9WgXcQ">
  <img src="assets/Sketches/Trakabum Texto.png" style="width:550px;" align="center" />
</a>

# An <span style="color:#a6da95">Android</span> Album Tracker for the 21th Century

![forthebadge](https://forthebadge.com/images/badges/built-with-swag.svg)
![forthebadge](https://forthebadge.com/images/badges/it-works-why.svg)
![forthebadge](https://forthebadge.com/images/badges/designed-in-ms-paint.svg)

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![SQLite](https://img.shields.io/badge/sqlite-%2307405e.svg?style=for-the-badge&logo=sqlite&logoColor=white)
![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)
![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
![Spotify](https://img.shields.io/badge/Spotify-1ED760?style=for-the-badge&logo=spotify&logoColor=white)
![CodePen](https://img.shields.io/badge/Codepen-000000?style=for-the-badge&logo=codepen&logoColor=white)
![Android Studio](https://img.shields.io/badge/Android%20Studio-3DDC84.svg?style=for-the-badge&logo=android-studio&logoColor=white)
![Play Store](https://img.shields.io/badge/Google_Play-414141?style=for-the-badge&logo=google-play&logoColor=white)
![Jira](https://img.shields.io/badge/jira-%230A0FFF.svg?style=for-the-badge&logo=jira&logoColor=white)
</div>

## Table of Contents
- [Description](#description)
- [Features](#features)
- [Installation](#installation)
- [Building](#building)
- [Usage](#usage)
- [FAQ](#faq)
- [Contributing](#contributing)
- [Privacy Policy](#privacy-policy)
- [Contact Information](#contact-information)
- [License](#license)

## Description
> How many times did you wanted to go back and continue with the last session of listening to your new discovered albums?

> Did you want to remember how that album felt to you after you listened it?

> Or you just want to keep track of everything you listen without having to remember everything inside your brain.
<img src="assets/Sketches/Logo Trakabum.png" align="right"
     alt="Size Limit logo by Anton Lovchikov" width="260" height="268">

Well, the answer to this questions is **Trakabum**.

Trakabum is an app for people who wants to search and store their listened albums. Not only that, but you can have a rating system of the ones you have listened, as well as sorting and filtering all of them so you can focus on whats more important to you.

This is an <span style="color:#a6da95">android</span> application which uses the <span style="color:#a6da95">Spotify API</span> to retrieve information from the albums. In fact, we use a [library](https://github.com/adamint/spotify-web-api-kotlin) which has a bunch of implementations of the API already built in, so it is easier for us to develop the application to the public.
## Features
- **Cartonny & beautiful UI**: Based on Excalidraw's design with a cartonny design style.
- **Search and browse albums**: Use the integrated search functionality to find albums based on artists, genres, or specific keywords.
- **Album details**: View detailed information about each album, including the artist, release date, tracklist, album cover art and more!.
- **Add albums to your personal lists**: Save albums to your personal lists for easy access and reference.
- **Mark albums as listened**: Keep track of the albums you've already listened to by marking them as listened.
- **Create custom tags for each list**: You can create tags for the lists that you want so you can organize more your albums.
- **Notifications for new releases**: Receive notifications whenever new albums are released by your followed artists.
- **Personalized recommendations**: Get personalized album recommendations based on your listening preferences and saved albums.

## Installation
<a href="https://play.google.com/store/apps/details?id=com.indiedev.nevergonnagiveyouupbuton&hl=es&gl=US"><img alt="Google Play" src="https://play.google.com/intl/en_us/badges/static/images/badges/en_badge_web_generic.png" width="320px"></a>

Trakabum is available to download in the Google Play Store. Visit the link on the image above and click install to get the application on your phone.

## Building
The project can be build with Android Studio and Gradle. Here are the steps to compile it by yourself:

1. Clone the repository in your machine:
```
git clone https://github.com/Matt-FTW/Trakabum.git
```
2. Open the project in Android Studio
3. Obtain a Spotify API client ID and secret by creating a new application in the [Spotify Developer Dashboard](https://developer.spotify.com/dashboard). *For more information on how to create the application, check the following [tutorial](https://www.codeproject.com/Tips/5276627/HowTo-Setup-a-Spotify-API-App-in-the-Spotify-Devel).*
4. Go into the file ** and change the app ID and secret code with the codes of your new created application:
5. Build and run the application on an Android device or emulator.

## Usage
1. Launch the Music Album Tracker app on your Android device.
2. Use the search bar to search for albums by artist, genre, or keywords.
3. Tap on an album to view its details, including the tracklist and album cover.
4. To create a list, tap on the "Create List" button
5. To add an album to your list, tap the "Add to List" button.
6. To mark an album as listened, go to your collection, select the album, and tap the "Mark as Listened" button.
7. Follow artist by going into their names and clicking the heart button
8. Enable notifications in the app settings to receive updates on new album releases.

## FAQ
- **Will this app be available in the App Store?** For now, we dont plan to release Trakabum on the App Store, but if we recieve enough requests about it, we will.
- **Can i have a tag for more than one list?** Yes, you can.
- **Has the app a triel or something like that?** Yes it does! It has a free trial version for you to try. The trial is only 7 days, so after the time has passed, you will have to pay to keep using the app.
- **Can i use the app without Spotify?** No, you cant. The Spotify API is the most important ingredient for the app to work, so unfortunely, we have to use it. Altough, about connecting with your Spotify account, **you can not log in with Spotify**, and use the app for only local querys and store local information.
- **I have a question that is not answered here, what can I do?** You can post an issue here on GitHub, write a review og Google Play or contact us via mail. You have the [contact information](#contact-information) down on the page.

## Contributing
Contributions are welcome! If you have any ideas, suggestions, or bug reports, please create an issue or submit a pull request.

## Privacy Policy
Trakabum does not store or collect any personal information. All user prefences are stored on the user's device in local storage.

## Contact Information
For any questions or concerns regarding the anything about this project, please send an email to support@trakabum.com.

## License

Licensed under the [MIT License](LICENSE), Copyright © 2023-present Trakabum
