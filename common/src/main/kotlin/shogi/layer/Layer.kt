package shogi.layer

import shogi.Position
import shogi.Grid
import shogi.Index

abstract class Layer<T>(_grids: List<Grid<T>> = listOf(), default: T? = null)  {
    val grids: List<Grid<T>> =  Index.values().toList().let {
        subscripts -> subscripts.map { x -> subscripts.map { y -> Grid<T>(Position(x, y), default) } }
    }.flatten()

    init {

        _grids.forEach {
            val a = this.select(it.position)
            this.set(it.position, it.content)
        }

    }



    fun select(position: Position) = grids.find { it.position == position }!!
    fun set(position: Position, value: T?): Unit {
        select(position).content = value
    }
    fun isExist(position: Position): Boolean = !select(position).isEmpty()
    open fun existGrids() = grids.filterNot { it.isEmpty() }
    fun existPositions(): List<Position> = existGrids().map{ it.position }
    fun search(content: T): Grid<T> = grids.find { it.content == content }!!

    override fun equals(other: Any?): Boolean {
        if(other !is Layer<*>) return false
        return other.grids.all { this.select(it.position).content == it.content }
    }
}