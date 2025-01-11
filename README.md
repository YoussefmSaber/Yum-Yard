# Yum Yard

Yum Yard is an Android application built with **Jetpack Compose**. The app allows users to browse and share food recipes, post reviews, follow chefs, and contribute their own recipes. The app also supports user authentication and data management through **Supabase**.

## Features

### 1. **Recipe Browsing**
   - Browse a variety of recipes with detailed ingredients, instructions, and measures.
   - Filter recipes based on categories and dietary preferences.

### 2. **User Interaction**
   - Post reviews for recipes.
   - Follow chefs to get updates on their latest recipes.
   - Share your own recipes with the community.

### 3. **Search Functionality**
   - Search for recipes by name, ingredients, or categories.

### 4. **Authentication & Data Management**
   - **Supabase Authentication** for user sign-in (email/password, OAuth).
   - **Supabase Database** for managing recipes, user data, and reviews.

### 5. **Dynamic UI with Jetpack Compose**
   - Modern and responsive user interface built using **Jetpack Compose**.
   - Smooth UI transitions and animations.
   - Adaptive layout for various screen sizes and orientations.

## Technologies

- **Jetpack Compose**: UI toolkit for building native Android apps.
- **Kotlin**: The programming language used for the app.
- **Koin**: Dependency injection library for managing app components and simplifying the codebase.
- **Supabase**:
  - **Supabase Authentication** for handling user authentication.
  - **Supabase Database** for storing and retrieving recipes, user reviews, and other data.
- **Coil**: Library for efficient image loading.
- **Room Database**: for storing the favorite recipes on the device memory.

## Architecture

The app follows the **MVVM** (Model-View-ViewModel) architecture, which is structured as follows:

- **Model**: Contains the business logic and data operations, managing interactions with the Supabase database.
- **View**: Composed of the Jetpack Compose UI elements, observing and displaying data from the ViewModel.
- **ViewModel**: Manages UI-related data using **StateFlow** for state management, ensuring a reactive interface.

### Dependency Injection with Koin

- **Koin** is used to manage the injection of dependencies like the Supabase service, repositories, and ViewModels, simplifying the code and making it more testable.

## Setup & Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/YoussefmSaber/Yum-Yard.git
   cd Yum-Yard
   ```

2. Open the project in **Android Studio**.

3. **Supabase Setup**:
   - Create a Supabase account at [Supabase.io](https://supabase.io/).
   - Create a new project and configure the database schema.
   - Obtain the `SUPABASE_URL` and `SUPABASE_ANON_KEY` for authentication and data access.
   - Add the configuration to your project, typically in `strings.xml` or a config file.

4. **Run the app**:
   - Sync the project with Gradle files and run it on an emulator or physical device.
   - Test authentication and recipe browsing functionalities.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgements

- [Jetpack Compose Documentation](https://developer.android.com/jetpack/compose) for UI development.
- [Kotlin Lang](https://kotlinlang.org/) for the language used in the app.
- [Supabase Documentation](https://supabase.io/docs) for backend services and authentication.
- [Koin Documentation](https://insert-koin.io/docs/) for dependency injection.

## Contributing

Contributions are welcome! If you'd like to improve the app, feel free to fork the repository, create a branch, and submit a pull request.
