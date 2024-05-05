plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.hilt)
    id( "kotlin-kapt")

}

android {
    namespace = "com.turk.localpersistance"
}

dependencies {

    implementation(libs.android.room.runtime)
    implementation(libs.android.roomktx)
    implementation(libs.android.hilt)
    kapt(libs.android.dagger.hilt.compiler)
    annotationProcessor(libs.androidx.room.compiler)
    kapt(libs.androidx.room.compiler)
    implementation(project(":dtos"))

}