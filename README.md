# Kotlin Boilerplate Project

This is a Kotlin boilerplate project designed for Android app development. It follows best practices and offers a clean architecture, making it easy to understand and extend for future development needs.

## Basic Features

- **Network Requests with Retrofit**: Perform API calls seamlessly using Retrofit for efficient networking.
- **Persistent Local Storage using Room DB**: Store and retrieve data locally using Room database with built-in repository patterns.
- **Responsive Functions**: Ensure that your UI components adapt to different screen sizes and orientations.
- **Firebase Crashlytics**: Integrated Firebase Crashlytics for crash reporting and tracking in production.
- **Logging Interceptors**: Easily debug network requests and responses using built-in logging interceptors for HTTP calls.
- **ViewModels with Dagger Hilt Integration**: Manage UI-related data and logic with ViewModels, seamlessly integrated with Dagger Hilt for dependency injection.

## Project Folder Structure
```
project 
├── api
│   └── ApiService.kt     
│ 
├── di
│   └── AppModule.kt
│ 
├── exceptions
│   └── ApiException.kt
│ 
├── interceptors
│   └── LoggingInterceptor.kt
│ 
├── models
│   ├── request
│   └── response
│ 
├── navigation
│   ├── AppNavHost.kt
│   └── AppNavigationRoutes.kt
│ 
├── presentation
│   └── composables                     # All common composables
│   └── screens
│   │   └── feature
│   │   │   ├── FeatureScreen.kt
│   │   │   ├── FeatureViewModel.kt
│   │   │   └── FeatureUiState.kt
│ 
├── repositories
│   ├── network
│   └── room
│ 
├── room
│   ├── feature
│   │   ├── Feature.kt
│   │   ├── FeatureDao.kt
│   │   ├── FeatureDatabase.kt
│   │   └── FeatureRepositoryImpl.kt  # Repository interface under repositories > room folder
│ 
├── theme
│   ├── Color.kt
│   ├── Type.kt
│   └── Theme.kt
│ 
├── utils                             # All common utility files
│ 
├── KotlinBoilerPlateApp.kt
│ 
└── MainActivity.kt

```
## Setup
Follow these steps to set up the project and get started:

### 1. Clone the Repository
```bash
git clone https://github.com/your-repo/kotlin-boilerplate.git
cd kotlin-boilerplate
```
### 2. Setup Environment
Update the API URLs in the build.gradle file (app-level) to match your environment.
- Location: Under the android block, in the productFlavors block.
- Modify the appropriate flavor with your development, staging, or production API URLs.
```
android {
    productFlavors {
        dev {
            buildConfigField "String", "BASE_URL", '"https://your-dev-url.com/"'
        }
        staging {
            buildConfigField "String", "BASE_URL", '"https://your-staging-url.com/"'
        }
        prod {
            buildConfigField "String", "BASE_URL", '"https://your-prod-url.com/"'
        }
    }
}
```
### 3. Convert Dependencies to Library Catalog Declaration
If you want to use new library catalog declarations, convert the existing implementation blocks in the build.gradle (app-level) to match the new format in the libs.versions.toml file.
```
// Old format
implementation 'com.squareup.retrofit2:retrofit:2.9.0'

// New format using libraries.toml
implementation libs.retrofit
```
### 4. Setup Firebase Crashlytics
Make sure to set up Firebase Crashlytics for error tracking in your app.
- Add your google-services.json file to the app/ directory of the project.
- If Firebase Crashlytics is not needed, you can remove the Crashlytics dependencies from the build.gradle and omit the google-services.json file.

### 5. Update Responsiveness Functions
Modify the height and width values in ResponsivenessHelper.kt to match your app's design specifications.
- Location: utils/ResponsivenessHelper.kt

```
@Composable
fun Int.h(): Dp {
    val figmaHeight = 812       // Replace this with the height of the figma design

    val screenHeight = LocalConfiguration.current.screenHeightDp.dp

    return (this * screenHeight / figmaHeight)
}
```

### 6. Customize Theme
- Update the colors in Color.kt to match your app’s color scheme ( Location : ```theme/Color.kt``` )
- To change the native splash screen colors for both light and dark modes:
    - File Locations:
        - Light mode : ```res/values/splash.xml```
        - Dark mode : ```res/values-night/splash.xml```
    - Update the windowSplashScreenBackground tag in both files to reflect your desired splash screen background color.  Replace @color/your_splash_color with your app’s splash screen background color.
    ```
    <item name="windowSplashScreenBackground">@color/your_splash_color</item>
    ```  

After completing these steps, your project should be ready for development!