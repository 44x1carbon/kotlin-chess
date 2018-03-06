package shogi.koma

import shogi.movement.Direction
import shogi.movement.Movement
import shogi.movement.Run

//香車
class Kyosha(id: String): Koma(id) {
    override val movementList: List<Movement> = listOf(
        Run(Direction.FORWARD)
    )
}