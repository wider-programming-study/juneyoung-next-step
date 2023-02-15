package org.owls.week1.baseball

import kotlin.test.Test
import mu.KotlinLogging
import org.owls.common.ConsolePresenter
import org.owls.common.InputReader


/**
 * 미구현 분
 * TC 에 대해서 다양한 경우의 수를 커버할 수 있도록 ParameterizedTest 나 CsvResource 같은 부분을 활용해 볼 것
 */
class TestBaseBall {

    private val MOCK_CORRECT_ANSWER = "231"
    private val MOCK_INPUTS:ArrayDeque<String> = ArrayDeque(listOf("1", "123", "231", "2"))

    class TestInputReader(private val mockAnswerList:ArrayDeque<String>): InputReader<Any> {
        override fun read(): Any {
            return mockAnswerList.removeFirst();
        }
    }

    @Test fun testJudge() {
        val testInput = TestInputReader(MOCK_INPUTS)
        val testPresenter = ConsolePresenter()
        val sut = BaseBallController(testInput, testPresenter)
        val mockGame =
        sut.play()
    }
}