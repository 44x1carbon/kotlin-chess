package shogi.movement

enum class Direction(val x: Int, val y: Int) {
    FORWARD(0, 1),
    BACK(0, -1),
    LEFT(-1, 0),
    RIGHT(1,0),
    FORWARD_LEFT(-1, 1),
    FORWARD_RIGHT(1, 1),
    BACK_LEFT(-1, -1),
    BACK_RIGHT(1, -1)
}

fun Direction.invert()  = when(this) {
        Direction.FORWARD -> Direction.BACK
        Direction.BACK -> Direction.FORWARD
        Direction.LEFT -> Direction.RIGHT
        Direction.RIGHT -> Direction.LEFT
        Direction.FORWARD_LEFT -> Direction.BACK_RIGHT
        Direction.FORWARD_RIGHT -> Direction.BACK_LEFT
        Direction.BACK_LEFT -> Direction.FORWARD_RIGHT
        Direction.BACK_RIGHT -> Direction.FORWARD_LEFT
    }