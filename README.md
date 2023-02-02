<h1 align="center">GameGuide</h1>
This application has been developed in accordance with the Android Architectural Architecture using the Android jetpack libraries.

## App Screenshots
<p align="center">
<img src="/previews/clean_arch.png" />
</p>

## Tech stack & Open-source Libraries
- Minimum SDK level 21
- 100% [Kotlin](https://kotlinlang.org/) based
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines)
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
- A single-activity architecture,
- using the [Navigation component](https://developer.android.com/guide/navigation/navigation-getting-started) to manage fragment operations.
- [Kotlin Flow](https://https://kotlinlang.org/docs/flow.html) Flows are built on top of coroutines and can provide multiple values. A flow is conceptually a stream of data that can be computed asynchronously. The emitted values must be of the same type
- [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - perform an action when lifecycle state changes
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes.
- [Repository](https://developer.android.com/topic/architecture/data-layer) - Located in data layer that contains application data and business logic.
- [ViewBinding](https://developer.android.com/topic/libraries/view-binding) - Generates a binding class for each XML layout file present in that module and allows you to more easily write code that interacts with views.
- [Usecases](https://developer.android.com/topic/architecture/domain-layer) - The domain layer is responsible for encapsulating complex business logic, or simple business logic that is reused by multiple ViewModels. This layer is optional because not all apps will have these requirements.
- [Android Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - Dependency Injection Library
- [Retrofit](https://square.github.io/retrofit/) A type-safe HTTP client for Android and Java
- [Modularization](https://developer.android.com/topic/modularization) Modularization is a means of structuring your codebase in a way that improves maintainability and helps avoid these problems.
- [Gson](https://github.com/google/gson) Gson is a Java library that can be used to convert Java Objects into their JSON representation. It can also be used to convert a JSON string to an equivalent Java object
- [Glide](https://github.com/bumptech/glide) An image loading library for Android backed by Kotlin Coroutines. Glide supports fetching, decoding, and displaying video stills, images, and animated GIFs. Glide includes a flexible API that allows developers to plug in to almost any network stack.
- Material Design