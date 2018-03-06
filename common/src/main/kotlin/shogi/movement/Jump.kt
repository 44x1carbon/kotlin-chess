package shogi.movement

import shogi.OutOfRangeException
import shogi.Position
import shogi.Square
import shogi.layer.EnemyKomaLayer
import shogi.layer.MovableLayer
import shogi.layer.MyKomaLayer
import shogi.koma.Koma
import shogi.plus

class Jump(direction: Direction, val multipleX: Int, val multipleY: Int): Movement(direction) {
    override fun mapping(koma: Koma, myKomaGrid: MyKomaLayer, enemyKomaGrid: EnemyKomaLayer): MovableLayer {
        val position = myKomaGrid.search(koma).position

        return try {
            val targetX = position.x + direction.x * multipleX
            val targetY = position.y + direction.y * multipleY
            val target = Position(targetX, targetY)

            if(myKomaGrid.isExist(target)) {
                MovableLayer()
            } else {
                MovableLayer(listOf(
                    Square(target, true)
                ))
            }
        } catch (e: OutOfRangeException) {
            MovableLayer()
        }
    }

}