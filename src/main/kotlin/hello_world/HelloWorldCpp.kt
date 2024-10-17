package ru.plumsoftware.hello_world

import ru.plumsoftware.Languages
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

fun helloWorldCpp() : String {
    return try {
        // Подготовка процесса для запуска Python скрипта
        val currentProject = File("").absolutePath
        val languageFile =
            File("$currentProject${Languages.Path.CPP_PATH}${Languages.Name.CPP_HELLO_WORLD_SCRIPT}").absolutePath
        val processBuilder = ProcessBuilder("g++", languageFile, "-o", Languages.Name.CPP_HELLO_WORLD_SCRIPT.removeSuffix(".cpp"))
        println("g++ " + languageFile + " -o " + Languages.Name.CPP_HELLO_WORLD_SCRIPT.removeSuffix(".cpp"))
        processBuilder.redirectErrorStream(true)
        val process = processBuilder.start()

        // Читаем поток битов от Python
        val reader = BufferedReader(InputStreamReader(process.inputStream, Charsets.UTF_8))

        val output: StringBuilder = StringBuilder()
        reader.forEachLine { output.appendLine(it) }

        // Ожидание завершения процесса
        val exitCode = process.waitFor()

        if (exitCode == 0) {
            output.toString().trim()
        } else {
            exitCode.toString()
        }
    } catch (e: Exception) {
        "Ошибка при вызове C++ скрипта: ${e.message}"
    }
}