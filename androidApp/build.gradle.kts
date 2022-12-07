plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.randev.wanolog.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.randev.wanolog.android"
        minSdk = 23
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(project(":common:core"))
    implementation(project(":common:domain"))
    implementation(project(":common:navigation"))

    implementation("io.insert-koin:koin-androidx-compose:3.2.2")
    // Compose Coil
    implementation("io.coil-kt:coil-compose:2.2.2")

    implementation("com.google.accompanist:accompanist-pager:0.15.0")

    implementation("com.google.accompanist:accompanist-flowlayout:0.20.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.0-alpha01")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.0-alpha01")



    //Paging
    implementation("androidx.paging:paging-compose:1.0.0-alpha17")

    implementation("androidx.compose.ui:ui:1.3.1")
    implementation("androidx.compose.ui:ui-tooling:1.3.1")
    implementation("androidx.compose.ui:ui-util:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")
    implementation("androidx.compose.ui:ui-tooling-preview:1.3.1")
    implementation("androidx.compose.foundation:foundation:1.3.1")
    implementation("androidx.compose.material:material:1.3.1")
    implementation("androidx.activity:activity-compose:1.6.1")

    implementation("joda-time:joda-time:2.12.2")
}