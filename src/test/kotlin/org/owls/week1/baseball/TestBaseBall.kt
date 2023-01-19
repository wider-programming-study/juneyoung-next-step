package org.owls.week1.baseball

import kotlin.test.Test
import mu.KotlinLogging
import org.junit.jupiter.api.Assertions
import org.owls.common.ConsoleInputReader
import org.owls.common.ConsolePresenter

val kotlinLogger = KotlinLogging.logger {}

/**
 * 미구현 분
 * TC 에 대해서 다양한 경우의 수를 커버할 수 있도록 ParameterizedTest 나 CsvResource 같은 부분을 활용해 볼 것
 */
class TestBaseBall {

    private fun alterAnswerField(targetInstance:BaseBall, mockAnswer:String) {
        val answerField = targetInstance.javaClass.getDeclaredField("answer")
        answerField.isAccessible = true
        answerField.set(targetInstance, mockAnswer)
    }

    // 이렇게 되면 round run 을 못하는데?!
    // 실패하는 이유는 play 를 하는 순간 기껏 리플렉션으로 처리한 answer 가 업데이트 되어버린다.
    @Test fun testInnerPlay(){
        val inputReader = ConsoleInputReader()
        val outputPresenter = ConsolePresenter()
        val sut = BaseBall(inputReader, outputPresenter)
        alterAnswerField(sut, "139")

        // get InnerMethod
        val innerPlay = sut.javaClass.getDeclaredMethod("innerPlay", String::class.java)
        innerPlay.isAccessible = true
        val actual = innerPlay.invoke(sut, "123") as GameResult

        val expected = GameResult(1, 1, 1)
        Assertions.assertEquals(actual.strike, expected.strike)
        Assertions.assertEquals(actual.ball, expected.ball)
        Assertions.assertEquals(actual.foul, expected.foul)

        val actual2 = innerPlay.invoke(sut, "132") as GameResult
        val expected2 = GameResult(1, 2, 0)
        Assertions.assertEquals(actual2.strike, expected2.strike)
        Assertions.assertEquals(actual2.ball, expected2.ball)
        Assertions.assertEquals(actual2.foul, expected2.foul)
    }
}