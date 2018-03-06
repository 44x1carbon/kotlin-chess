package shogi.koma

import shogi.movement.Direction
import shogi.movement.Movement
import shogi.movement.Run

//角行
class Kakugyo(id: String): Koma(id) {
    override val movementList: List<Movement> = listOf(
        Run(Direction.FORWARD_RIGHT),
        Run(Direction.FORWARD_LEFT),
        Run(Direction.BACK_LEFT),
        Run(Direction.BACK_RIGHT)
    )
}