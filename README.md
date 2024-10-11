## Kotlin Boiler Plate Code
### Project Folder Structure
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
