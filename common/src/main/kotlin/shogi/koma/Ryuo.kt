package shogi.koma

import shogi.movement.Direction
import shogi.movement.Movement
import shogi.movement.Run
import shogi.movement.Step

//龍王
class Ryuo(id: String): Koma(id) {
    override val movementList: List<Movement>  = listOf(
            Step(Direction.FORWARD_RIGHT),
            Step(Direction.FORWARD_LEFT),
            Step(Direction.BACK_LEFT),
            Step(Direction.BACK_RIGHT),
            Run(Direction.FORWARD),
            Run(Direction.BACK),
            Run(Direction.LEFT),
            Run(Direction.RIGHT)
    )
}