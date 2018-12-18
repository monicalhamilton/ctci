package monicalhamilton.ctci.recursionanddp;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class FindPathInGridTest {

    @Test
    public void testEmptyGrid() {
        assertEquals(FindPathInGrid.DirectionResult.notFound(),
                new FindPathInGrid(0, 0, Collections.emptyList()).findPath());
    }

    @Test
    public void testSingletonGrid() {
        assertEquals(FindPathInGrid.DirectionResult.found(Collections.emptyList()),
                new FindPathInGrid(1, 1, Collections.emptyList()).findPath());
    }

    @Test
    public void testTwoByTwoGrid() {
        assertEquals(FindPathInGrid.DirectionResult.found(Lists.newArrayList(FindPathInGrid.Direction.RIGHT, FindPathInGrid.Direction.DOWN)),
                new FindPathInGrid(2, 2, Collections.emptyList()).findPath());
    }

    @Test
    public void testTwoByTwoGrid_partiallyBlocked() {
        assertEquals(FindPathInGrid.DirectionResult.found(Lists.newArrayList(FindPathInGrid.Direction.DOWN, FindPathInGrid.Direction.RIGHT)),
                new FindPathInGrid(2, 2, Lists.newArrayList(new FindPathInGrid.Coordinate(1, 0))).findPath());
    }

    @Test
    public void testTwoByTwoGrid_fullyBlocked() {
        ArrayList<FindPathInGrid.Coordinate> blockedSquares = Lists.newArrayList(
                new FindPathInGrid.Coordinate(1, 0), new FindPathInGrid.Coordinate(0, 1));
        FindPathInGrid.DirectionResult actual = new FindPathInGrid(2, 2, blockedSquares).findPath();
        FindPathInGrid.DirectionResult expected = FindPathInGrid.DirectionResult.notFound();
        assertEquals(expected, actual);
    }
}
