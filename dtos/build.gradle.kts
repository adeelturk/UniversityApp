plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.hilt)
    id( "kotlin-kapt")
    id( "kotlin-parcelize")
}

android {
    namespace = "com.turk.dtos"
}

dependencies {
    implementation(libs.androidx.rv)
    implementation(libs.androidx.appcompat)
    implementation(libs.android.room.runtime)
    implementation(libs.android.google.gson)
    implementation(libs.android.hilt)
    kapt(libs.android.dagger.hilt.compiler)
}