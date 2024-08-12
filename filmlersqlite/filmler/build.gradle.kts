// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.0.2")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.3")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.46.1")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.0") // En son
    }
}
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
}