package ru.plumsoftware.hello_world

import ru.plumsoftware.Languages
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

fun helloWorldPy(): String {
    return try {
        // Подготовка процесса для запуска Python скрипта
        val currentProject = File("").absolutePath
        val languageFile =
            File("$currentProject${Languages.Path.PYTHON_PATH}${Languages.Name.PYTHON_HELLO_WORLD_SCRIPT}").absolutePath
        val processBuilder = ProcessBuilder("python", languageFile)
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
        "Ошибка при вызове Python скрипта: ${e.message}"
    }
}