package shogi

import shogi.movement.Direction

class Position(val x: Index, val y: Index) {
    operator fun plus(direction: Direction): Position = Position(x + direction.x, y + direction.y)
    operator fun minus(direction: Direction): Position = Position(x - direction.x, y - direction.y)
    fun invert(): Position = Position(x.invert(), y.invert())
    override fun toString(): String = "x: $x, y: $y"

    override fun equals(other: Any?): Boolean {
        if(other !is Position) return false
        return other.x == this.x && other.y == this.y
    }
}