plugins {
    id("com.android.application")
}

android {
    namespace = "com.ltrsoft.police_app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.ltrsoft.police_app"
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
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("com.android.volley:volley:1.2.1")
    implementation ("com.airbnb.android:lottie:4.2.2")
    implementation ("com.google.maps.android:android-maps-utils:2.2.0")
    implementation ("com.google.android.gms:play-services-location:21.0.1")
    implementation ("com.google.maps:google-maps-services:0.15.0")
    implementation ("com.google.android.gms:play-services-maps:17.0.1")



}