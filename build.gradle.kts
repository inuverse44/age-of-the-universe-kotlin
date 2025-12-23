plugins {
    kotlin("jvm") version "2.1.0"
    application
}

group = "AgeOfTheUniverse"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

application {
    mainClass.set("AgeOfTheUniverse.MainKt")
}

tasks.test {
    useJUnitPlatform()
}
