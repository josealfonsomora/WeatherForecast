# WeatherForecast
Android Kata with WeatherForecast

![Build and deploy](https://github.com/josealfonsomora/WeatherForecast/workflows/Build%20and%20deploy/badge.svg)

![Screenshot](https://github.com/josealfonsomora/WeatherForecast/blob/main/art/screenshot.png)

### Building de project

Android Studio Arctic Fox | 2020.3.1 Canary 5
gradle-6.8

The project can be built from github actions on Github UI

### Unit Test

run ```./gradlew test```

### Jetpack libraries used

This project is using latest Jetpack libraries even in alpha, like Paging 3 or DataStore. I consider that both libraries are mature enough and small
enough to be released to production

[Hilt](https://developer.android.com/training/dependency-injection/hilt-android)

[Navigation](https://developer.android.com/guide/navigation)

[ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)

[ViewBinding](https://developer.android.com/topic/libraries/view-binding)

#### External Dependencies

[Retrofit](https://square.github.io/retrofit/)

[Okhttp](https://square.github.io/okhttp/)

[Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html)

[Timber](https://github.com/JakeWharton/timber)

[Mockk](https://mockk.io/)

### TODO

With more than 4 hours I would add:
- Cache storage on a Room database and Shared preferences
- Handle Network issues and show cached information
- Obviously better design or just some design
- More unit tests and some espresso UI tests (there is only one unit test as example)