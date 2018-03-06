package shogi.layer

import shogi.IDGenerator
import shogi.Square
import shogi.koma.Koma

class EnemyKomaLayer(squares: List<Square<Koma>> = listOf()) : KomaLayer(squares) {
    fun invert() = EnemyKomaLayer().also { this.squares.forEach { this.set(it.position.invert(), it.content ) } }
    fun nextId(): String = IDGenerator.generate(8)
    fun fullMovementRange(myKomaGrid: MyKomaLayer) = (MovableLayer() + invert().existSquares().map { it.content }.map { it?.movableRange(myKomaGrid, this) ?: MovableLayer() }).invert()
}