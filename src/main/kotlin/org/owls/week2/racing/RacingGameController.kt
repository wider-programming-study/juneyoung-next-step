package org.owls.week2.racing

import org.owls.common.InputReader
import org.owls.common.Presenter
import org.owls.common.game.GameController
import org.owls.week2.racing.game.Horse
import org.owls.week2.racing.game.RacingGame
import org.owls.week2.racing.game.RacingGameInput
import kotlin.random.Random

class RacingGameController(private val reader: InputReader<Any>, private val presenter: Presenter): GameController {
    private fun getPlayers(): List<Horse> {
        presenter.out("""
            경주마 이름을 입력하세요(이름은 쉼표(,) 로 구분)
        """.trimIndent())
        val names = this.reader.read().toString().trim().split(",")
        var players = mutableListOf<Horse>()
        for(name in names) {
            players.add(Horse(name, 0))
        }
        return players
    }

    private fun getRounds(): Int {
        presenter.out("""
            시도할 횟수는 몇회인가요?
        """.trimIndent())
        val rounds = this.reader.read().toString().trim()
        return rounds.toInt()
    }

    private val handleRound: (List<Horse>) -> Unit = {
        for (horse in it) {
            this.presenter.out(horse.toString())
        }
    }

    override fun play() {
        val entries = getPlayers()
        if (entries.size < 2) {
            throw IllegalArgumentException("참가자는 최소 2명 이상이어야 합니다")
        }

        val rounds = getRounds()
        if (rounds < 1) {
            throw IllegalArgumentException("라운드는 최소 1 이상이어야 합니다")
        }
        val racingGameInput = RacingGameInput(entries, rounds)
        val game = RacingGame(this.handleRound)
        val winners = game.play(racingGameInput) // 아 매라운드 결과 찍어야 되잖아...
        this.presenter.out(winners.toString())
    }
}