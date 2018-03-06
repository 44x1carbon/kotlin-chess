package shogi.koma

import shogi.movement.Direction
import shogi.movement.Jump
import shogi.movement.Movement

//桂馬
class Keima(id: String): Koma(id) {
    override val movementList: List<Movement>  = listOf(
        Jump(Direction.FORWARD_LEFT, 1, 2),
        Jump(Direction.FORWARD_RIGHT, 1, 2)
    )
}