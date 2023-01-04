plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization") version Version.kotlin
}

kotlin {
    android()
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "data"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Dependencies.koinCore)
                implementation(Dependencies.ktorCore)
                implementation(Dependencies.ktorJsonSerialization)

                implementation(project(mapOf("path" to ":common:core")))
                implementation(project(mapOf("path" to ":common:domain")))
                implementation(project(mapOf("path" to ":libraries:preferences")))
                implementation(project(mapOf("path" to ":libraries:database")))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation("junit:junit:4.13.2")
                implementation("io.mockk:mockk:1.13.2")
                implementation("io.mockk:mockk-common:1.12.1")
//                implementation( "org.mockito:mockito-inline:4.6.0")
//                implementation("org.mockito:mockito-core:4.6.0")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
                implementation(Dependencies.koinTest)
            }
        }
        val androidMain by getting
        val androidTest by getting {
            dependencies {
                implementation("io.mockk:mockk-jvm:1.13.2")
            }

        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting {
            dependencies {
                implementation("io.mockk:mockk:1.13.2")
            }
        }
        val iosArm64Test by getting {
            dependencies {
                implementation("io.mockk:mockk:1.13.2")
            }
        }
        val iosSimulatorArm64Test by getting {
            dependencies {
                implementation("io.mockk:mockk:1.13.2")
            }
        }
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "com.randev.data"
    compileSdk = 32
    defaultConfig {
        minSdk = 23
        targetSdk = 32
    }
}