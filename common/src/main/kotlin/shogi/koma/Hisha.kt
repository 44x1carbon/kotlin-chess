package shogi.koma

import shogi.movement.Direction
import shogi.movement.Movement
import shogi.movement.Run

//飛車
class Hisha(id: String): Koma(id) {
    override val movementList: List<Movement> = listOf(
        Run(Direction.FORWARD),
        Run(Direction.BACK),
        Run(Direction.LEFT),
        Run(Direction.RIGHT)
    )
}