package shogi.layer

import shogi.IDGenerator
import shogi.Grid
import shogi.koma.Koma

class MyKomaLayer(grids: List<Grid<Koma>> = listOf()) : KomaLayer(grids) {
    fun invert() = MyKomaLayer().also { this.grids.forEach { this.set(it.position.invert(), it.content ) } }
    fun nextId(): String = IDGenerator.generate(8)
}