package org.owls.week1.baseball

import org.owls.common.ConsoleInputReader
import org.owls.common.ConsolePresenter

// 입력과 출력이 있어야 함
fun main(args: Array<String>){
    val consoleInputReader = ConsoleInputReader()
    val consolePresenter = ConsolePresenter()
    val game = BaseBall(consoleInputReader, consolePresenter)
    game.play()
}