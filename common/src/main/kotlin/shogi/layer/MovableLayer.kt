package shogi.layer

import shogi.Grid

class MovableLayer(grids: List<Grid<Boolean>> = listOf()) : Layer<Boolean>(grids, false) {
    override fun existGrids(): List<Grid<Boolean>> = grids.filter { it.content == true }
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

    fun invert() = MovableLayer().also { this.grids.forEach { this.set(it.position.invert(), it.content ) } }
}