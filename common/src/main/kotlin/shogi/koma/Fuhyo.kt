package shogi.koma

import shogi.movement.Direction
import shogi.movement.Movement
import shogi.movement.Step

//歩兵
class Fuhyo(id: String): Koma(id) {
    override val movementList: List<Movement>  = listOf(
        Step(Direction.FORWARD)
    )
}