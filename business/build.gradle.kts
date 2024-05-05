plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.hilt)
    id( "kotlin-kapt")

}

android {
    namespace = "com.turk.business"
}

dependencies {

    implementation(libs.android.square.logging.interceptor)
    implementation(libs.android.hilt)
    kapt(libs.android.dagger.hilt.compiler)
    implementation(project(":common"))
    implementation(project(":dtos"))
    implementation(project(":universityReposiotry"))

}