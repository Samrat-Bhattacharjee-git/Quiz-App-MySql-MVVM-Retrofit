plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.quiz_app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.quiz_app"
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
    buildFeatures{
        dataBinding=true
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    val lifecycle_version = "2.6.2"

    //viewmodel
    implementation("androidx.lifecycle:lifecycle-viewmodel:$lifecycle_version")
    //livedata
    implementation("androidx.lifecycle:lifecycle-livedata:$lifecycle_version")
    //retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    //Gson converter
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

}