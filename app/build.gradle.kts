import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion(29)
    buildToolsVersion("29.0.3")

    defaultConfig {
        applicationId = "com.example.ckfl"
        minSdkVersion(16)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    viewBinding {
        isEnabled = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Kotlin
    implementation(Dependencies.kotlin)
    // Coroutines
    implementation(Coroutines.core)
    implementation(Coroutines.android)
    // Android
    implementation(Android.appcompat)
    implementation(Android.ktx)
    implementation(Android.constraintLayout)
    implementation(Android.swipeRefreshLayout)
    // Architecture Components
    implementation(Dependencies.viewModel)
    implementation(Dependencies.liveData)
    // Retrofit
    implementation(Dependencies.retrofit)
    // Dagger 2
    implementation(Dagger.dagger)
    kapt(Dagger.compiler)
    implementation(Dagger.android)
    implementation(Dagger.support)
    kapt(Dagger.processor)
    // Testing
    testImplementation(Testing.jUnit)
    // Android Testing
    androidTestImplementation(Testing.extJUnit)
    androidTestImplementation(Testing.espresso)
}
