package org.owls.week2.racing.game

import org.owls.common.game.Game
import org.owls.common.game.GameInsert
import org.owls.common.game.GameResult
import kotlin.random.Random

class RacingGame(val roundHandler:(List<Horse>) -> Unit): Game<RacingGameInput, RacingGameOutput> {
    override fun play(input: RacingGameInput): RacingGameOutput {
        for (i in 0 until input.rounds) {
            for (horse in input.horses) {
                if(Random.nextInt(10) > 4) {
                    horse.run(1) // 보폭은 정해져 있음
                }
            }
            roundHandler(input.horses)
        }
        return RacingGameOutput(input.horses)
    }
}


data class RacingGameInput(val horses:List<Horse>, val rounds:Int):GameInsert
data class RacingGameOutput(val horses:List<Horse>): GameResult {
//    val winners:List<Horse>
//    init {
//        horses.sortedBy { horse: Horse -> horse.steps }
//    }
}

data class Horse(val name:String, var steps:Int){
    fun run(step:Int) {
        steps += step
    }
    override fun toString():String {
        var footStep = ""
        for (i in 0 until steps) {
            footStep += "-"
        }
        return "$name: $footStep"
    }
}