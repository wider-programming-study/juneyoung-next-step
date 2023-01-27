package org.owls.week1.baseball

import org.owls.common.InputReader
import org.owls.common.Presenter
import org.owls.common.game.CommonGame
import org.owls.common.game.GameInsert
import org.owls.common.game.GameResult
import kotlin.random.Random
import kotlin.system.exitProcess

/**
 * 미구현 분
 * - play 시 사용자 input 에 대한 validation 처리가 되어야 함 123 12#
 * - data 클래스의 toString 에 대한 검증
 * - input_handler 와 output_handler 를 생성자로 받아서 처리하는 방식도 있음
 */
class BaseBall(private val reader:InputReader<Any>, private val presenter:Presenter):
    CommonGame<BaseballInput, BaseballResult>() {
    private lateinit var answer:String
    private fun getOperation(): String {
        presenter.out("""
            시작: 1
            종료: 2
        """.trimIndent())
        return reader.read().toString().trim()
    }

    private fun showGuide() {
        presenter.out("""
            야구 게임
            숫자를 3개 넣어서 
            같은 위치에 같은 숫자면 스트라이크
            다른 위치에 같은 숫자면 볼
            결과지에 없는 숫자라면 파울
        """.trimIndent())
    }

    private fun prepareAnswer(){
        val tempAnswer = LinkedHashSet<Int>()
        while (tempAnswer.size < 3) {
            tempAnswer.add(Random.nextInt(10))
        }
        answer = tempAnswer.joinToString("")
    }

    override fun judge(input: BaseballInput): BaseballResult {
        var strikes = 0
        var balls = 0
        var fouls = 0
        for (i:Int in 0 .. 2) {
            val charAt = answer.get(i)
            val inputIndex = input.userInput.indexOf(charAt)
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
        return BaseballResult(strikes, balls, fouls)
    }

    override fun play(){
        prepareAnswer()
        showGuide()
        val operation = getOperation()
        if ("1" == operation) {
            var done = false;
            while(!done) {
                presenter.out("값을 입력하세요")
                val input = reader.read().toString()
                val result = judge(BaseballInput(input))
                presenter.out("결과: $result")
                done = (result.strike === 3)
            }
            play()
        } else {
            presenter.out("게임을 종료합니다")
            exitProcess(0)
        }
    }
}

data class BaseballInput(val userInput: String):GameInsert

data class BaseballResult(val strike:Int, val ball:Int, val foul:Int):GameResult {
    override fun toString(): String {
        return "$strike strikes, $ball balls, $foul fouls"
    }
}