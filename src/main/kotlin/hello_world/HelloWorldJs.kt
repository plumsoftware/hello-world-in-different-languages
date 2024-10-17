package ru.plumsoftware.hello_world

import ru.plumsoftware.Languages
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

fun helloWorldJs() : String {
    return try {
        val currentProject = File("").absolutePath
        val languageFile =

            File("$currentProject${Languages.Path.JS_PATH}${Languages.Name.JS_HELLO_WORLD_SCRIPT}").absolutePath
        println(languageFile)

        val processBuilder = ProcessBuilder("node", languageFile)
        processBuilder.redirectErrorStream(true)
        val process = processBuilder.start()

        val reader = BufferedReader(InputStreamReader(process.inputStream, Charsets.UTF_8))

        val output = StringBuilder()

        var line: String?
        while (reader.readLine().also { line = it } != null) {
            output.append(line).append("\n")
        }

        val exitCode = process.waitFor()

        if (exitCode == 0) {
            output.toString().trim()
        } else {
            exitCode.toString()
        }
    } catch (e: Exception) {
        "Ошибка при вызове JavaScript скрипта: ${e.message}"
    }
}