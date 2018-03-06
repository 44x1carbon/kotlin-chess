package shogi.layer

import shogi.Square

class MovableLayer(squares: List<Square<Boolean>> = listOf()) : Layer<Boolean>(squares, false) {
    override fun existSquares(): List<Square<Boolean>> = squares.filter { it.content == true }
    operator fun plus(other: MovableLayer): MovableLayer {
        val myPositions = this.existPositions()
        val otherPositions = other.existPositions()

        return MovableLayer().run {
            myPositions.forEach { this.set(it, true) }
            otherPositions.forEach { this.set(it, true) }
            this
        }
    }

    operator fun plus(others: List<MovableLayer>): MovableLayer = others.fold(MovableLayer()) { v1, v2 -> v1 + v2 }

    fun invert() = MovableLayer().also { this.squares.forEach { this.set(it.position.invert(), it.content ) } }
}