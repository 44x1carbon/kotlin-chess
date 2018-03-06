package shogi.koma

import shogi.layer.EnemyKomaLayer
import shogi.layer.MovableLayer
import shogi.layer.MyKomaLayer
import shogi.movement.Movement

abstract class Koma(val id: String) {
    abstract val movementList: List<Movement>

    fun movableRange(myKomaGrid: MyKomaLayer, enemyKomaGrid: EnemyKomaLayer): MovableLayer = MovableLayer() + movementList.map { it.mapping(this, myKomaGrid, enemyKomaGrid) }

    override fun equals(other: Any?): Boolean {
        if(other !is Koma) return false
        return other.id == id
    }
}