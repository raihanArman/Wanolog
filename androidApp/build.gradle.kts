plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.ewalabs.kiiroi"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.ewalabs.kiiroi"
        minSdk = 23
        targetSdk = 33
        versionCode = 2
        versionName = "1.0.1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
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
}

dependencies {
    implementation(project(":shared"))
    implementation(project(":common:core"))
    implementation(project(":common:domain"))
    implementation(project(":common:ui:navigation"))
    implementation(project(":common:ui:widget"))
    implementation(project(":libraries:work-manager"))

    implementation(libs.koin.compose)

    implementation(libs.coil)
    implementation(libs.coil.gif)

    implementation(libs.accompanist.flowlayout)
    implementation(libs.accompanist.swiperefresh)
    implementation(libs.accompanist.navigation.animation)
    implementation(libs.accompanist.pager)
    implementation(libs.accompanist.pager.indicators)

    implementation(libs.androidx.lifecycle.viewmodel)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.paging.compose)
    implementation(libs.androidx.startup)
    implementation(libs.androidx.work.manager)

    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling)
    implementation(libs.compose.ui.util)
    implementation(libs.constraintlayout.compose)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.foundation)
    implementation(libs.compose.material)
    implementation(libs.activity.compose)

    implementation(libs.joda.time)
    implementation("androidx.compose.material3:material3:1.0.1")
    implementation("androidx.compose.material3:material3-window-size-class:1.0.1")
    implementation("com.google.accompanist:accompanist-adaptive:0.26.2-beta")

    androidTestImplementation(libs.compose.ui.test)
// Needed for createAndroidComposeRule, but not createComposeRule:
    debugImplementation(libs.compose.ui.test.manifest)

}