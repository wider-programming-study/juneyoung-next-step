package org.owls.common

import java.util.*

class ConsoleInputReader: InputReader<String> {
    override fun read(): String {
        val scanner = Scanner(System.`in`)
        return scanner.nextLine()
    }
}