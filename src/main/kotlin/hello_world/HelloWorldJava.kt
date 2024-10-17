package ru.plumsoftware.hello_world

import ru.plumsoftware.HelloWorldJava

fun helloWorldJava() : String {
    val helloWorldJava = HelloWorldJava()
    val byteArray = helloWorldJava.helloWorldJava()
    return String(byteArray)
}