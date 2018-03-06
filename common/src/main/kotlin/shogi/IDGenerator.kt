package shogi

object IDGenerator {
    fun generate(length: Int) = ("abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789").split("").shuffled().take(length).joinToString("")
}