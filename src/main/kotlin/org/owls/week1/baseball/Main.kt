package org.owls.week1.baseball

import mu.KotlinLogging
import java.util.Scanner

val baseBallLogger = KotlinLogging.logger { "baseball" }

// 입력과 출력이 있어야 함
fun main(args: Array<String>){
    baseBallLogger.info {
        """
            야구 게임
            숫자를 3개 넣어서 
            같은 위치에 같은 숫자면 스트라이크
            다른 위치에 같은 숫자면 볼
            결과지에 없는 숫자라면 파울
        """.trimIndent()
    }

    val game = BaseBall()
    var playFlag = true
    while(playFlag) {
        val scanner = Scanner(System.`in`)
        val result = game.play(scanner.nextLine().trim())
        baseBallLogger.info { result }
        playFlag = result.strike != 3
    }
}