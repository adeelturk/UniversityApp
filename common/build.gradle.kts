plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id( "kotlin-kapt")
}

android {
    namespace = "com.turk.common"
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
    implementation(libs.android.retrofit.adapter)
    implementation(libs.android.retrofit)
    implementation(libs.android.retrofit.convertor.gson)
    implementation(libs.android.square.logging.interceptor)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
