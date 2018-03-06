package shogi.koma

import shogi.movement.Direction
import shogi.movement.Movement
import shogi.movement.Step

//と金
class Tokin(id: String): Koma(id) {
    override val movementList: List<Movement> = listOf(
            Step(Direction.FORWARD),
            Step(Direction.FORWARD_RIGHT),
            Step(Direction.FORWARD_LEFT),
            Step(Direction.RIGHT),
            Step(Direction.LEFT),
            Step(Direction.BACK)
    )
}