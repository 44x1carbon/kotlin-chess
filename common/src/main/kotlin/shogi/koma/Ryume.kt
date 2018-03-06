package shogi.koma

import shogi.movement.Direction
import shogi.movement.Movement
import shogi.movement.Run
import shogi.movement.Step

//龍馬
class Ryume(id: String): Koma(id) {
    override val movementList: List<Movement>  = listOf(
            Run(Direction.FORWARD_RIGHT),
            Run(Direction.FORWARD_LEFT),
            Run(Direction.BACK_LEFT),
            Run(Direction.BACK_RIGHT),
            Step(Direction.FORWARD),
            Step(Direction.BACK),
            Step(Direction.LEFT),
            Step(Direction.RIGHT)
    )
}