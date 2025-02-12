#Fetch Rewards Coding Exercise

> This is a coding exercise I did for the Fetch Rewards interview process (see https://fetch-hiring.s3.amazonaws.com/mobile.html). It highlights fetching data from an endpoint, storing results locally, and presenting the data with some filtering applied and using Jetpack Compose. 

While the coding exercise was requested as an Android native, I chose to build it in Kotlin Multiplatform. I did this for a couple reasons:

1. KMP and Android native use very similar architecture. I felt this would showcase my understanding of Android fundamentals since I could have done it natively, but also highlight my adaptability to emerging technologies. I also wanted to show how far the cross-platform capabilities of KMP have come and how some slight architectural differences can add polished implementations for other platforms. 
2. I figured that the engineer reviewing all these projects would enjoy seeing something *slightly* different :) 
3. I wanted to challenge myself and keep the skill-set fresh. My personal project I'm currently working on is Android native, so it's been a little while since I've worked in KMP. Since I'm doing this project for "fun" I figured I should also use it as a chance to keep these skills fresh.

The architecture I used:
- Room for local storage. Room currently supports KMP in the alpha builds
- Ktor client for network functionality. Ktor natively supports KMP, but had I built it Android native, I would probably have used Retrofit since it's the most common
- Koin for dependency injection. I would have used Hilt for Android native. 
- Compose for the UI. Compose works for both Android and iOS (experimental but so far pretty polished)
- ViewModel and Navigation. The jetbrains team has done a ton of work getting these libraries to work on both iOS and Android
- Coroutines and Flow for async operations. Also natively supported by both platforms.

Note - I don't have a MacOS device to test the iOS version. In theory it should work on iOS once the room database builder is built and the project is setup in xcode, but it will just build for Android right now.


Below is the default explanation for KMP folder structure:

This is a Kotlin Multiplatform project targeting Android, iOS.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…