package org.owls.week1.baseball

import kotlin.random.Random

/**
 * 미구현 분
 * - play 시 사용자 input 에 대한 validation 처리가 되어야 함 123 12#
 * - data 클래스의 toString 에 대한 검증
 * - input_handler 와 output_handler 를 생성자로 받아서 처리하는 방식도 있음
 */
class BaseBall {
    private lateinit var answer:String

    init {
        prepareAnswer()
    }

    private fun prepareAnswer(){
        val tempAnswer = LinkedHashSet<Int>()
        while (tempAnswer.size < 3) {
            tempAnswer.add(Random.nextInt(10))
        }
        answer = tempAnswer.joinToString("")
    }

    fun play(input:String):GameResult{
        var strikes = 0
        var balls = 0
        var fouls = 0
        for (i:Int in 0 .. 2) {
            val charAt = answer.get(i)
            val inputIndex = input.indexOf(charAt)
            if (inputIndex == i) {
                strikes ++
                continue
            }

            if (inputIndex < 0) {
                fouls ++
                continue
            }
            balls ++
        }
        return GameResult(strikes, balls, fouls)
    }
}

data class GameResult(val strike:Int, val ball:Int, val foul:Int) {
    override fun toString(): String {
        return "$strike strikes, $ball balls, $foul fouls"
    }
}