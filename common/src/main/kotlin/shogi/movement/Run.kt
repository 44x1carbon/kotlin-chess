package shogi.movement

import shogi.OutOfRangeException
import shogi.Position
import shogi.Grid
import shogi.layer.EnemyKomaLayer
import shogi.layer.MovableLayer
import shogi.layer.MyKomaLayer
import shogi.koma.Koma

class Run(direction: Direction): Movement(direction) {
    override fun mapping(koma: Koma, myKomaGrid: MyKomaLayer, enemyKomaGrid: EnemyKomaLayer): MovableLayer {
        val position = myKomaGrid.search(koma).position

        val calcCourse: (position: Position, direction: Direction) -> List<Position>
            = { pos, d ->
                generateSequence(pos) {  it + d  }
                    .takeWhile { try { (it + d).run {true} } catch (e: OutOfRangeException) { false }  }
                    .map { it + d }
                    .toList()
            }

        val inCourse: (target: Position) -> Boolean = { target -> calcCourse(position, direction).contains(target) }
        val afterCourse: (target: Position) -> List<Position> = { target -> calcCourse(target, direction.invert()).filter(inCourse) }
        val isExistEnemyBehind: (target: Position) -> Boolean = { target -> afterCourse(target).any(enemyKomaGrid::isExist) }

        val course = calcCourse(position, direction)
        val movablePosition = course.takeWhile {
            !(isExistEnemyBehind(it) || myKomaGrid.isExist(it))
        }

        return MovableLayer(movablePosition.map { Grid(it, true) })
    }
}