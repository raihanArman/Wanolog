/**
 * @author Raihan Arman
 * @date 16/11/22
 */

object Dependencies {
    const val ktxSerialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Version.serialization}"
    const val ktxCoroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutine}"
    const val ktxDateTime = "org.jetbrains.kotlinx:kotlinx-datetime:${Version.dateTime}"
    const val coroutinesNative = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutinesNative}"

    const val androidMaterial = "com.google.android.material:material:${Version.material}"
    const val androidAppCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Version.constraint}"
    const val fragmentNavigation = "androidx.navigation:navigation-fragment-ktx:${Version.navFragment}"
    const val androidNavigation = "androidx.navigation:navigation-ui-ktx:${Version.navUi}"
    const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.livedata}"

    const val composeUi = "androidx.compose.ui:ui:${Version.compose}"
    const val composeMaterial = "androidx.compose.material:material:${Version.compose}"
    const val composeTooling = "androidx.compose.ui:ui-tooling:${Version.compose}"
    const val composeGraphics = "androidx.compose.ui:ui-graphics:${Version.compose}"
    const val composeUtil = "androidx.compose.ui:ui-util:${Version.compose}"
    const val composeFoundation = "androidx.compose.foundation:foundation:${Version.compose}"
    const val composeFoundationLayout = "androidx.compose.foundation:foundation-layout:${Version.compose}"
    const val composeMaterialIcon = "androidx.compose.material:material-icons-extended:${Version.compose}"
    const val composeLiveData = "androidx.compose.runtime:runtime-livedata:${Version.compose}"

    const val composeActivity = "androidx.activity:activity-compose:${Version.activityCompose}"
    const val composeLottie = "com.airbnb.android:lottie-compose:${Version.lottie}"
    const val composeShimmer = "com.valentinilk.shimmer:compose-shimmer:${Version.shimmer}"

    const val accompanistCoil = "com.google.accompanist:accompanist-coil:${Version.coilAccompanist}"
    const val accompanistPager = "com.google.accompanist:accompanist-pager:${Version.pagerAccompanist}"

    const val composeDestinations = "io.github.raamcosta.compose-destinations:core:${Version.composeDestinations}"
    const val composeDestinationsAnimation = "io.github.raamcosta.compose-destinations:animations-core:${Version.composeDestinations}"
    const val composeDestinationsKsp = "io.github.raamcosta.compose-destinations:ksp:${Version.composeDestinations}"

    const val koinCore = "io.insert-koin:koin-core:${Version.koin}"
    const val koinTest = "io.insert-koin:koin-test:${Version.koin}"
    const val koinAndroid = "io.insert-koin:koin-android:${Version.koin}"
    const val koinCompose = "io.insert-koin:koin-androidx-compose:${Version.koin}"

    const val ktorCore = "io.ktor:ktor-client-core:${Version.ktor}"
    const val ktorJsonSerialization = "io.ktor:ktor-serialization-kotlinx-json:${Version.ktor}"
    const val ktorContentNegotiation = "io.ktor:ktor-client-content-negotiation:${Version.ktor}"
    const val ktorLogging = "io.ktor:ktor-client-logging:${Version.ktor}"
    const val ktorOkhttp = "io.ktor:ktor-client-okhttp:${Version.ktor}"
    const val ktorDarwin = "io.ktor:ktor-client-darwin:${Version.ktor}"
    const val ktorAndroid = "io.ktor:ktor-client-android:${Version.ktor}"
    const val ktorIos = "io.ktor:ktor-client-ios:${Version.ktor}"

    const val navigation = "androidx.navigation:navigation-compose:${Version.navigation}"
    const val sqlDelightRuntime = "com.squareup.sqldelight:runtime:${Version.sqlDelight}"
    const val sqlDelightCoroutines = "com.squareup.sqldelight:coroutines-extensions:${Version.sqlDelight}"
    const val chucker = "com.github.chuckerteam.chucker:library:${Version.chucker}"

    const val kermitLogger = "co.touchlab:kermit:${Version.kermit}"
    const val multiplatformSettings = "com.russhwolf:multiplatform-settings:${Version.multiplatformSettings}"

    const val dataStore = "androidx.datastore:datastore-preferences:${Version.dataStore}"
    const val dataStoreCore = "androidx.datastore:datastore-preferences-core:${Version.dataStore}"
}