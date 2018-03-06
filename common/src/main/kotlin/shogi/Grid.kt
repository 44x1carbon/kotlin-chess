package shogi

class Grid<T>(val position: Position, var content: T?) {
    fun isEmpty(): Boolean = content == null
    override fun toString(): String {
        return "${position}: ${content}"
    }
}