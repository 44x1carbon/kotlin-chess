package shogi.layer

import shogi.IDGenerator
import shogi.Square
import shogi.koma.Koma

class MyKomaLayer(squares: List<Square<Koma>> = listOf()) : KomaLayer(squares) {
    fun invert() = MyKomaLayer().also { this.squares.forEach { this.set(it.position.invert(), it.content ) } }
    fun nextId(): String = IDGenerator.generate(8)
}