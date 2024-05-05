plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.hilt)
    id("kotlin-kapt")
    id("androidx.navigation.safeargs")
}


android {
    namespace = "com.turk.universityapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.turk.universityapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.android.retrofit.adapter)
    implementation(libs.android.retrofit)
    implementation(libs.android.retrofit.convertor.gson)
    implementation(libs.android.square.logging.interceptor)
    implementation(libs.android.coroutine.core)
    implementation(libs.android.coroutine.android)
    implementation(libs.android.multiidex)
    implementation(libs.android.room.runtime)
    implementation(libs.androidx.fragment.testing)

    implementation(libs.android.hilt)
    kapt(libs.android.dagger.hilt.compiler)
    implementation(libs.navigationFragment)
    implementation(libs.navigationUi)
    implementation(project(":UniversityListing"))
    implementation(project(":universityDetails"))
    implementation(project(":dtos"))

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //implementation(libs.multidex)
    // https://mvnrepository.com/artifact/androidx.multidex/multidex
    runtimeOnly("androidx.multidex:multidex:2.0.1")

}

