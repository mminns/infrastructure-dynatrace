import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.31"
}

group = "com.atlassian.performance.tools"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(url ="https://packages.atlassian.com/maven/repository/internal")
}

dependencies {
    api("com.atlassian.performance.tools:infrastructure:[4.12.0,5.0.0)")
    api("com.atlassian.performance.tools:ssh:[2.3.0,3.0.0)")

    implementation(kotlin("stdlib-jdk8"))

    testCompile("junit:junit:4.12")
    testCompile("org.assertj:assertj-core:3.11.1")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        this.freeCompilerArgs += "-Xjvm-default=enable"
        this.jvmTarget = "1.8"
    }
}