package shogi

enum class Index(val num: Int) {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
}

operator fun Index.minus(num: Int): Index = Index.values().toList().find { it.num == this.num - num } ?: throw OutOfRangeException()
operator fun Index.plus(num: Int): Index = Index.values().toList().find { it.num == this.num + num } ?: throw OutOfRangeException()
fun Index.invert(): Index = when (this) {
    Index.ONE -> Index.NINE
    Index.TWO -> Index.EIGHT
    Index.THREE -> Index.SEVEN
    Index.FOUR -> Index.SIX
    Index.FIVE -> Index.FIVE
    Index.SIX -> Index.FOUR
    Index.SEVEN -> Index.THREE
    Index.EIGHT -> Index.TWO
    Index.NINE -> Index.ONE
}

class OutOfRangeException(override val message: String? = null): Throwable(message)