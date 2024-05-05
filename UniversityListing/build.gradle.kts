plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.hilt)
    id( "kotlin-kapt")
    id("androidx.navigation.safeargs")
}

android {
    namespace = "com.turk.universitylisting"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.android.coroutine.core)
    implementation(libs.android.coroutine.android)
    implementation(libs.android.multiidex)
    implementation(libs.navigationFragment)
    implementation(libs.navigationUi)
    implementation(libs.androidx.fragment.testing)
    implementation(libs.android.swiperefresh)
    implementation(libs.android.hilt)
    kapt(libs.android.dagger.hilt.compiler)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(project(":common"))
    implementation(project(":dtos"))
    implementation(project(":business"))
}

