pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Wanolog"
include(":androidApp")
include(":shared")
include(":common:core")
include(":common:data")
include(":common:domain")
include(":libraries:network")
include(":libraries:database")
include(":common:navigation")
include(":libraries:preferences")
include(":libraries:preferences")
