plugins {
    id(Plugins.ANDROID_APPLICATION)
    id(Plugins.KOTLIN_ANDROID)
}


android {
    namespace = AndroidConfiguration.APPLICATION_ID
    compileSdk = AndroidConfiguration.COMPILE_SDK_VERSION

    defaultConfig {
        applicationId = AndroidConfiguration.APPLICATION_ID
        minSdk = AndroidConfiguration.MIN_SDK_VERSION
        targetSdk = AndroidConfiguration.TARGET_SDK_VERSION
        versionCode = AndroidConfiguration.VERSION_CODE
        versionName = AndroidConfiguration.VERSION_NAME
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(libs.bundles.androidx)
    implementation(libs.glide)
}
