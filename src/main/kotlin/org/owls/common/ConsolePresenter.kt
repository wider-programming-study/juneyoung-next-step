package org.owls.common

class ConsolePresenter: Presenter {
    override fun out(message: String) {
        println(message)
    }
}