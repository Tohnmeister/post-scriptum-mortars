package nl.tonni.postscriptum.mortars

import kotlin.math.abs
import kotlin.math.sqrt

data class Point(val x: Int, val y: Int)

enum class GridColumn {
    A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z
}

data class MapCoordinates(val column: GridColumn, val row: Int, val keyPadPosition: Int, val subKeyPosition: Int) {
    fun toPoint(): Point {
        val x = column.ordinal * 9 + positionToX(keyPadPosition) * 3 + positionToX(subKeyPosition)
        val y: Int = (row - 1) * 9 + positionToY(keyPadPosition) * 3 + positionToY(subKeyPosition)
        return Point(x, y)
    }

    private fun positionToX(position: Int): Int {
        require(position in 1..9)

        return (position - 1) % 3
    }

    private fun positionToY(position: Int): Int {
        require(position in 1..9)

        return when (position) {
            1, 2, 3 -> 2
            4, 5, 6 -> 1
            else -> 0
        }
    }

    fun distanceTo(other: MapCoordinates): Double {
        val fromPoint = toPoint()
        val toPoint = other.toPoint()

        val xDiff = abs(fromPoint.x - toPoint.x)
        val yDiff = abs(fromPoint.y - toPoint.y)
        val distance = sqrt((xDiff * xDiff + yDiff * yDiff).toDouble()) * 100 / 3
        return distance
    }
}