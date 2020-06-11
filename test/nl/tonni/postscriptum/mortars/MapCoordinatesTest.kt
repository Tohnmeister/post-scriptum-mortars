package nl.tonni.postscriptum.mortars

import org.junit.Test

import org.junit.Assert.*

class MapCoordinatesTest {

    @Test
    fun `A1-7-7 is top left`() {
        assertEquals(Point(0, 0), MapCoordinates(GridColumn.A, 1, 7, 7).toPoint())
    }

    @Test
    fun `A1-7-8 is sub key next to top left`() {
        assertEquals(Point(1, 0), MapCoordinates(GridColumn.A, 1, 7, 8).toPoint())
    }

    @Test
    fun `A1-8-7 is key pad next to top left`() {
        assertEquals(Point(3, 0), MapCoordinates(GridColumn.A, 1, 8, 7).toPoint())
    }

    @Test
    fun `B1-7-7 is grid next to top left`() {
        assertEquals(Point(9, 0), MapCoordinates(GridColumn.B, 1, 7, 7).toPoint())
    }

    @Test
    fun `A1-1-1 is bottom left key pad of top left grid`() {
        assertEquals(Point(0, 8), MapCoordinates(GridColumn.A, 1, 1, 1).toPoint())
    }

    @Test
    fun `Z2-4-5 is at 226, 13`(){
        assertEquals(Point(226, 13), MapCoordinates(GridColumn.Z, 2, 4, 5).toPoint())
    }

    @Test
    fun `distance to sub key directly to right is one third of 100`() {
        val from = MapCoordinates(GridColumn.A, 1, 1, 1)
        val to = MapCoordinates(GridColumn.A, 1, 1, 2)
        assertEquals(100.0 / 3.0, from.distanceTo(to), 1E-6)
    }

    @Test
    fun `distance to should be reflective`() {
        val from = MapCoordinates(GridColumn.A, 1, 1, 1)
        val to = MapCoordinates(GridColumn.A, 1, 1, 2)
        assertEquals(to.distanceTo(from), from.distanceTo(to), 1E-6)
    }

    @Test
    fun `distance to sub key directly to left is one third of 100`() {
        val from = MapCoordinates(GridColumn.A, 1, 1, 2)
        val to = MapCoordinates(GridColumn.A, 1, 1, 1)
        assertEquals(100.0 / 3.0, from.distanceTo(to), 1E-6)
    }

    @Test
    fun `distance to sub key directly above is one third of 100`() {
        val from = MapCoordinates(GridColumn.A, 1, 1, 4)
        val to = MapCoordinates(GridColumn.A, 1, 1, 1)
        assertEquals(100.0 / 3.0, from.distanceTo(to), 1E-6)
    }

    @Test
    fun `distance to sub key directly below is one third of 100`() {
        val from = MapCoordinates(GridColumn.A, 1, 1, 1)
        val to = MapCoordinates(GridColumn.A, 1, 1, 4)
        assertEquals(100.0 / 3.0, from.distanceTo(to), 1E-6)
    }

    @Test
    fun `distance to same sub key in key pad directly to right is 100`() {
        val from = MapCoordinates(GridColumn.A, 1, 1, 1)
        val to = MapCoordinates(GridColumn.A, 1, 2, 1)
        assertEquals(100.0, from.distanceTo(to), 1E-6)
    }

    @Test
    fun `distance to sub key one right below is pythagoras of x 33 and y 33`() {
        val from = MapCoordinates(GridColumn.A, 1, 1, 4)
        val to = MapCoordinates(GridColumn.A, 1, 1, 2)
        assertEquals(47.140452, from.distanceTo(to), 1E-6)
    }
}