package org.owls.common.game

abstract class CommonGame<in P:GameInsert, out R:GameResult>: Game {
    protected abstract fun judge(input: P): R
}