plugins {
    kotlin("multiplatform") version "1.4.10"
    kotlin("plugin.serialization") version "1.4.10"
}
group = "me.daniel"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()
}
kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
    }
    js {
        browser {
            testTask {
                useKarma {
                    useChromeHeadless()
                    webpackConfig.cssSupport.enabled = true
                }
            }
        }
    }
    iosX64("ios") {
        binaries {
            framework {
                baseName = "library"
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-core:1.4.0")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9")
                implementation(kotlin("script-runtime"))
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.0.0-RC")

            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val jvmMain by getting {
            dependencies {
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("io.ktor:ktor-client-cio-jvm:1.4.0")

            }
        }
        val jsMain by getting
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
        val iosMain by getting {
            dependencies {
            }
        }
        val iosTest by getting
    }
}