plugins {
    kotlin("jvm") version "2.0.20"
}

group = "ru.plumsoftware"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

//Генерация файлов
tasks.register<Copy>("packPython") {
    //Python
    from("src/main/kotlin/languages/python")
    into("$buildDir/classes/python/main/ru/plumsoftware/languages")
}
tasks.register<Copy>("packCpp") {
    //Cpp
    from("src/main/kotlin/languages/cpp")
    into("$buildDir/classes/cpp/main/ru/plumsoftware/languages")
}
tasks.compileKotlin {
    dependsOn("packPython")
    dependsOn("packCpp")
}

kotlin {
    jvmToolchain(19)
}