package shogi.movement

import shogi.layer.EnemyKomaLayer
import shogi.layer.MovableLayer
import shogi.layer.MyKomaLayer
import shogi.koma.Koma

class Step(direction: Direction): Movement(direction) {
    override fun mapping(koma: Koma, myKomaGrid: MyKomaLayer, enemyKomaGrid: EnemyKomaLayer): MovableLayer {
        val movableGrid = MovableLayer()
        val position = myKomaGrid.search(koma).position
        val nextPosition = position + direction
        if(!myKomaGrid.isExist(nextPosition)) movableGrid.set(nextPosition, true)

        return movableGrid
    }
}