# CyptoInfoNav3 🪙

Welcome to **CyptoInfoNav3**, a modern Android application built to demonstrate the bleeding edge of the Android ecosystem. This project serves as a showcase for **Clean Architecture**, **Jetpack Navigation 3**, and advanced state management techniques in a multi-screen environment.

---

## 🏗️ Architecture & Tech Stack

This project follows a strict **Clean Architecture** pattern to ensure scalability, testability, and maintainability.

- **Architecture Pattern**: **MVVM (Model-View-ViewModel)** with **Unidirectional Data Flow (UDF)**.
- **UI Framework**: [Jetpack Compose](https://developer.android.com/compose) - Declarative UI where the screen is a pure function of the state.
- **State Management**: Reactive states using `StateFlow` and `collectAsStateWithLifecycle` for lifecycle-aware UI updates.
- **Design System**: [Material 3](https://m3.material.io/) - Implementing the latest Google design standards with adaptive support.
- **Dependency Injection**: [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - Scoped dependencies for clear lifecycle management.
- **Navigation**: [Navigation 3 (Alpha)](https://developer.android.com/guide/navigation/navigation-3) - Utilizing the latest type-safe, compose-first navigation library from Jetpack.
- **Networking**: [Retrofit](https://square.github.io/retrofit/) + [OkHttp](https://square.github.io/okhttp/) - Type-safe HTTP client with logging and interceptors.
- **Image Loading**: [Coil](https://coil-kt.github.io/coil/) - Optimized for Compose and high performance.
- **Asynchrony**: [Kotlin Coroutines & Flow](https://kotlinlang.org/docs/coroutines-overview.html) - Reactive state updates across the presentation layer.

---

## 🧭 Navigation System (The "Nav 3" Magic)

One of the standout features of this project is the early adoption of **Navigation 3**. Unlike traditional navigation, this implementation leverages:

- **Type-Safe Navigation Keys**: Using `NavigationKey` sealed interfaces annotated with `@Serializable`. No more string-based route management!
- **NavigationRoot**: A centralized hub that manages screen transitions using the `NavHost3` API, providing a clean separation between screen logic and navigation orchestration.
- **Adaptive Layouts**: Ready for multi-pane and large-screen support out of the box.

---

## 🧪 Nested Navigation & Shared ViewModels (Demo Branch)

While the `main` branch focuses on the core structure and coin information flow, the truly "magical" implementation lives in our demo branch.

### [🚀 Check out the Nested Navigation Demo](https://github.com/jrcmadushanka/CyptoInfoNav3/tree/nested_navigation_demo)

> [!IMPORTANT]
> This branch demonstrates how to handle complex navigation scenarios that most production apps struggle with.

**What's in the Demo?**
- **Nested Graphs**: Implementation of nested navigation for complex flows like `Auth` (Login/Register).
- **Shared ViewModels**: A showcase of how to share `ViewModel` instances across different screens within a navigation sub-graph, ensuring state consistency without polluting the global scope.
- **Advanced Serialization**: Deeply nested `NavigationKey` structures that maintain type safety even in complex hierarchies.

---

## 🛠️ Features (Main)
- **Coin List**: Real-time cryptocurrency list with performance-optimized scrolling.
- **Coin Details**: Comprehensive view of individual coins including whitepapers, info sections, and headers.
- **Modern DI**: Fully wired with Hilt for seamless testing and scalability.

---

*Built with ❤️ and a lot of Kotlin.*
