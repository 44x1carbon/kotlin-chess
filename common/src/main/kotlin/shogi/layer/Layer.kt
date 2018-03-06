package shogi.layer

import shogi.Position
import shogi.Square
import shogi.Index

abstract class Layer<T>(_squares: List<Square<T>> = listOf(), default: T? = null)  {
    val squares: List<Square<T>> =  Index.values().toList().let {
        subscripts -> subscripts.map { x -> subscripts.map { y -> Square<T>(Position(x, y), default) } }
    }.flatten()

    init {

        _squares.forEach {
            val a = this.select(it.position)
            this.set(it.position, it.content)
        }

    }



    fun select(position: Position) = squares.find { it.position == position }!!
    fun set(position: Position, value: T?): Unit {
        select(position).content = value
    }
    fun isExist(position: Position): Boolean = !select(position).isEmpty()
    open fun existSquares() = squares.filterNot { it.isEmpty() }
    fun existPositions(): List<Position> = existSquares().map{ it.position }
    fun search(content: T): Square<T> = squares.find { it.content == content }!!

    override fun equals(other: Any?): Boolean {
        if(other !is Layer<*>) return false
        return other.squares.all { this.select(it.position).content == it.content }
    }
}