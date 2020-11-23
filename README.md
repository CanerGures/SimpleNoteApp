<a href="https://github.com/CanerGures/TokenFT-DemoApplication/pulls"><img src="https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat" alt="contributions welcome" /></a>
<a href="https://android-arsenal.com/api?level=21"><img src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat" alt="API" /></a>

# SimpleNoteApp
An app for keeping notes on the phone. Application capabilities ->

Users can:
- Create a new Note
- Inspect the created notes in main screen
- Update/Delete the notes
- See the date of creation of the note
- See the date which is added after note update.

The architecture of the app is MVVM+Repo+Roomdb as Google advised. Update, delete, add operations are written in the viewmodel. Methods can be reachable as long as you reach to the viewmodel. RoomDb used for the database and a model of the notes storing inside the database. Recycler view used for listing all the notes in the main menu. Live data and observe used for adapter model so any changes in the list will be updated after the process. Coroutines used for observe the data inside the database. Koin is used for dependency injection. Repository, roomdb instance and viewmodel added as module to Koin to apply dependency injection.Junit4 used for testing. I have tested the entry forms which is for adding, updating and deleting. Material design guides were tried to be followed. Glide used for image loading from the url. Lottie animation library is used for the animation on the splash screen. Page transition animations are added to improve user experience.

## Screen Shots📱
<p><img height= "350" src="https://media.giphy.com/media/2aVvMQ6etiHJAc7C7B/giphy.gif" alt="Gif1" />
<img height= "350" src="https://media.giphy.com/media/tIQFQ9MQLfIaRdrEmU/giphy.gif" alt="Gif2" />
<img height= "350" src="https://media.giphy.com/media/KLrAqs8O1q6g0J6scL/giphy.gif" alt="Gif3" />
<img height= "350" src="https://media.giphy.com/media/a2wKRyW4bhgOCxKFg0/giphy.gif" alt="Gif4" /></p>

## Built With 🚧
<code><img src="https://www.vectorlogo.zone/logos/kotlinlang/kotlinlang-ar21.svg"></code>
<code><img src="https://www.vectorlogo.zone/logos/android/android-ar21.svg"></code>

## Flow Diagram
<p><img height= "600" width="900" src="https://i.imgur.com/FSvjtL6.png" alt="Gif4" /></p>

## Unit Tests (JUnit4) 
<code><img src="https://i.imgur.com/ZhmikUi.png"></code>

## Libraries and Tools 🛠

<li><a href="https://developer.android.com/jetpack/guide">MVVM</a></li>
<li><a href="https://developer.android.com/topic/libraries/architecture/viewmodel">ViewModel</a></li>
<li><a href="https://developer.android.com/topic/libraries/architecture/livedata">Live Data and Observers</a></li>
<li><a href="https://developer.android.com/topic/libraries/architecture/room">Room Persistence Database</a></li>
<li><a href="https://kotlinlang.org/docs/reference/coroutines-overview.html">Kotlin Coroutines</a></li>
<li><a href="https://github.com/InsertKoinIO/koin">Koin for Dependency Injection</a></li>
<li><a href="https://junit.org/junit4/">JUnit4 for Unit Test</a></li>
<li><a href="https://developer.android.com/guide/navigation">Navigaiton Component</a></li>
<li><a href="https://github.com/bumptech/glide">Glide</a></li>
<li><a href="https://material.io/design">Material Design</a></li>
<li><a href="https://developer.android.com/training/transitions">Page Transitions</a></li>
<li><a href="https://github.com/airbnb/lottie-android">Lottie Animations</a></li>


## Architecture📃
The app uses MVVM [Model-View-ViewModel] and Repository architecture to have a unidirectional flow of data, separation of concern, and a lot morewhich is recommended by Google itself.

![Architecture](https://developer.android.com/topic/libraries/architecture/images/final-architecture.png)
