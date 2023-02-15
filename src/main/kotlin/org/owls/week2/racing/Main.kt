package org.owls.week2.racing

import org.owls.common.ConsoleInputReader
import org.owls.common.ConsolePresenter

// 입력과 출력이 있어야 함
fun main(args: Array<String>){
    val consoleInputReader = ConsoleInputReader()
    val consolePresenter = ConsolePresenter()
    val game = RacingGameController(consoleInputReader, consolePresenter)
    game.play()
}