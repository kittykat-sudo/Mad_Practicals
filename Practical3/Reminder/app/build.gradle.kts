plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    // Remove the Compose plugin since you're using traditional Views
    // alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.reminder"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.reminder"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
        compose = false  // Set to false since you're using traditional Views
        viewBinding = true  // Optional: Enable if you want to use View Binding
    }
}

dependencies {
    // Core Android dependencies - use proper Kotlin DSL syntax
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

     implementation(libs.androidx.lifecycle.runtime.ktx)      // Remove if not needed
     implementation(libs.androidx.activity.compose)           // Remove - Compose specific
     implementation(platform(libs.androidx.compose.bom))      // Remove - Compose BOM
     implementation(libs.androidx.ui)                         // Remove - Compose UI
     implementation(libs.androidx.ui.graphics)                // Remove - Compose graphics
     implementation(libs.androidx.ui.tooling.preview)         // Remove - Compose tooling
     implementation(libs.androidx.material3)

    // Testing dependencies - use proper Kotlin DSL syntax
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}