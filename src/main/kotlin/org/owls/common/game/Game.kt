package org.owls.common.game

interface Game <in P: GameInsert, out R: GameResult>{
    fun play(input: P): R
}