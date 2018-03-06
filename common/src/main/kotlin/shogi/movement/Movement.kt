package shogi.movement

import shogi.layer.EnemyKomaLayer
import shogi.layer.MovableLayer
import shogi.layer.MyKomaLayer
import shogi.koma.Koma

abstract class Movement(val direction: Direction) {
    abstract fun mapping(koma: Koma, myKomaGrid: MyKomaLayer, enemyKomaGrid: EnemyKomaLayer): MovableLayer
}