plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("maven-publish")

}

android {
    namespace = "io.github.mala2017"
    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }
    compileSdk = 34
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
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = "io.github.mala2017"
                artifactId = "testpublish"
                version = "1.0.0"

                pom {
                    packaging = "aar"
                    name.set("testpublish")
                    description.set("MyLibrary: Library for Android Application")
                    url.set("https://github.com/mala2017/testpublish.git")
                    inceptionYear.set("2024")

                    licenses {
                        license {
                            name.set("Apache License")
                            url.set("https://github.com/mala2017/testpublish/blob/master/LICENSE")
                        }
                    }

                    developers {
                        developer {
                            id.set("MalaRuparel")
                            name.set("Mala Ruparel")
                            email.set("mala.rupareliya@gmail.com")
                        }
                    }

                    scm {
                        connection.set("scm:git:github.com//mala2017/testpublish")
                        developerConnection.set("scm:git:ssh://github.com/mala2017/testpublish.git")
                        url.set("https://github.com/mala2017/testpublish")
                    }

                }
            }
        }
    }
}

