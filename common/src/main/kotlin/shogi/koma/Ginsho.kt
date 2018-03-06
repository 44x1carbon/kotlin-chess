package shogi.koma

import shogi.movement.Direction
import shogi.movement.Movement
import shogi.movement.Step

//銀将
class Ginsho(id: String): Koma(id) {
    override val movementList: List<Movement> = listOf(
            Step(Direction.FORWARD),
            Step(Direction.FORWARD_RIGHT),
            Step(Direction.FORWARD_LEFT),
            Step(Direction.BACK_RIGHT),
            Step(Direction.BACK_LEFT)
    )
}