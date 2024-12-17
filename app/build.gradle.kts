import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.example.foodrecipe"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.foodrecipe"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    val properties = Properties()
    properties.load(rootProject.file("secret.properties").inputStream())
    properties.getProperty("API_URL")
    properties.getProperty("API_KEY")

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            buildConfigField("String", "API_URL", properties.getProperty("API_URL"))
            buildConfigField("String", "API_KEY", properties.getProperty("API_KEY"))
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

// Compile time check
ksp {
    arg("KOIN_CONFIG_CHECK", "true")
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Koin
    implementation(libs.koin.androidx.compose)
    implementation(libs.koin.android)
    implementation(libs.koin.test)
    implementation(libs.koin.annotations)
    ksp(libs.koin.ksp)

    // Glide
    implementation("com.github.bumptech.glide:glide:4.16.0") // Replace with the latest version
    implementation("com.github.bumptech.glide:compose:1.0.0-alpha.1") // Replace with the latest version
    ksp(libs.ksp)

    // Room
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)

    // Ktor
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.android)
    implementation(libs.ktor.client.serialization)
    implementation(libs.ktor.client.logging)

    // Kotlin serialization
    implementation(libs.kotlinx.serialization.json)

    // Google fonts
    implementation(libs.androidx.ui.text.google.fonts)

    // Supabase
    implementation(platform("io.github.jan-tennert.supabase:bom:3.0.3"))
    implementation(libs.auth.kt)
    implementation(libs.realtime.kt)
    implementation(libs.postgrest.kt)

    // Coil image loading
    implementation(libs.coil.compose)

    // Splash API
    implementation(libs.androidx.core.splashscreen)

    // constraint layout
    implementation("androidx.constraintlayout:constraintlayout-compose:1.1.0")

    // Navigation
    implementation(libs.navigation.compose)
}