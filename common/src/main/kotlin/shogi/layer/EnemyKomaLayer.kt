package shogi.layer

import shogi.IDGenerator
import shogi.Grid
import shogi.koma.Koma

class EnemyKomaLayer(grids: List<Grid<Koma>> = listOf()) : KomaLayer(grids) {
    fun invert() = EnemyKomaLayer().also { this.grids.forEach { this.set(it.position.invert(), it.content ) } }
    fun nextId(): String = IDGenerator.generate(8)
    fun fullMovementRange(myKomaGrid: MyKomaLayer) = (MovableLayer() + invert().existGrids().map { it.content }.map { it?.movableRange(myKomaGrid, this) ?: MovableLayer() }).invert()
}