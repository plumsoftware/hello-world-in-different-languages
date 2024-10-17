package ru.plumsoftware

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println(
        """
            Введите число от 1 до 2. 
            1 - Kotlin Hello World
            2 - Python Hello World
        """.trimIndent()
    )
    repeat(20) {
        print("=")
    }
    println()

    while (true) {
        val input = readlnOrNull()
        val number = try {
            input?.toInt()
        } catch (e: NumberFormatException) {
            println("Неверный формат числа")
            null
        }

        if (number != null) {
            val helloWorldFromLanguage = when (number) {
                1 -> helloWorldKt()
                else -> {
                    "Неизвестный номер"
                }
            }
            println(helloWorldFromLanguage)
        }
    }
}