package org.owls.common.game

import kotlin.random.Random

class BaseballGame: Game<BaseballInput, BaseballResult> {
    private var answerNumberByIndex:MutableMap<String, Int> = HashMap()

    init {
        while (answerNumberByIndex.size < 3) {
            val num = Random.nextInt(10)
            answerNumberByIndex[num.toString()] = answerNumberByIndex.size
        }
    }

    override fun play(input: BaseballInput): BaseballResult {
        val userInputArray = input.numbers
        var strike = 0
        var ball = 0
        var foul = 0
        for (x:Int in userInputArray.indices) {
            val foundIndex = answerNumberByIndex[userInputArray[x]]
            when {
                null == foundIndex -> foul += 1
                foundIndex == x -> strike += 1
                else -> ball += 1
            }
        }
        return BaseballResult(strike, ball, foul)
    }
}

data class BaseballInput(val userInput: String):GameInsert {
    val numbers: Array<String> = Array(userInput.length) { userInput[it].toString() }
}

data class BaseballResult(val strike:Int, val ball:Int, val foul:Int):GameResult {
    override fun toString(): String {
        return "$strike strikes, $ball balls, $foul fouls"
    }
}