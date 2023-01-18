package org.owls.week1.baseball

import kotlin.test.Test
import mu.KotlinLogging
import org.junit.jupiter.api.Assertions

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
//    @Test fun testPlay(){
//        val sut = BaseBall()
//        alterAnswerField(sut, "139")
//        val actual = sut.play("123")
//        val expected = GameResult(1, 1, 1)
//        Assertions.assertEquals(actual.strike, expected.strike)
//        Assertions.assertEquals(actual.ball, expected.ball)
//        Assertions.assertEquals(actual.foul, expected.foul)
//
//        alterAnswerField(sut, "132")
//        val actual2 = sut.play("123")
//        val expected2 = GameResult(1, 2, 0)
//        Assertions.assertEquals(actual2.strike, expected2.strike)
//        Assertions.assertEquals(actual2.ball, expected2.ball)
//        Assertions.assertEquals(actual2.foul, expected2.foul)
//    }
}