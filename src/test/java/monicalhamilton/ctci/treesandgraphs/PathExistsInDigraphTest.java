package monicalhamilton.ctci.treesandgraphs;

import org.junit.Test;

import static org.junit.Assert.*;

public class PathExistsInDigraphTest {

    /**
     * a
     */
    @Test
    public void singletonGraph_originEqualsDestination_returnsTrue() {
        Graph.Vertex<Character> a = new Graph.Vertex<>('a');
        assertTrue(PathExistsInDigraph.pathExistsDFS(a, a));
        assertFalse(PathExistsInDigraph.pathExistsDFS(a, new Graph.Vertex<>('b')));
    }

    /**
     * <pre>
     * a ->
     * ^  /
     * |<
     * </pre>
     */
    @Test
    public void selfReferentialGraph_originEqualsDestination_returnsTrue() {
        Graph.Vertex<Character> origin = new Graph.Vertex<>('a');
        origin.addNeighbor(origin);
        assertTrue(PathExistsInDigraph.pathExistsDFS(origin, origin));
    }

    /**
     * a -> b
     */
    @Test
    public void destinationIsNeighborOfOrigin_returnsTrue() {
        Graph.Vertex<Character> origin = new Graph.Vertex<>('a');
        Graph.Vertex<Character> destination = new Graph.Vertex<>('b');
        origin.addNeighbor(destination);
        assertTrue(PathExistsInDigraph.pathExistsDFS(origin, destination));
    }

    /**
     * a <- b
     */
    @Test
    public void originIsNeighborOfDestination_returnsFalse() {
        Graph.Vertex<Character> origin = new Graph.Vertex<>('a');
        Graph.Vertex<Character> destination = new Graph.Vertex<>('b');
        destination.addNeighbor(origin);
        assertFalse(PathExistsInDigraph.pathExistsDFS(origin, destination));
    }

    /**
     * a -> b -> c
     */
    @Test
    public void connectedViaIntermediate_returnsTrue() {
        Graph.Vertex<Character> origin = new Graph.Vertex<>('a');
        Graph.Vertex<Character> intermediate = new Graph.Vertex<>('b');
        Graph.Vertex<Character> destination = new Graph.Vertex<>('c');
        origin.addNeighbor(intermediate);
        intermediate.addNeighbor(destination);
        assertTrue(PathExistsInDigraph.pathExistsDFS(origin, destination));
    }

    /**
     * <pre>
     * a -> b -> c | |--> d -> e
     * </pre>
     */
    @Test
    public void multipleNeighbors() {
        Graph.Vertex<Character> a = new Graph.Vertex<>('a');
        Graph.Vertex<Character> b = new Graph.Vertex<>('b');
        Graph.Vertex<Character> c = new Graph.Vertex<>('c');
        Graph.Vertex<Character> d = new Graph.Vertex<>('d');
        Graph.Vertex<Character> e = new Graph.Vertex<>('e');
        a.addNeighbor(b);
        b.addNeighbor(c);
        a.addNeighbor(d);
        d.addNeighbor(e);

        assertTrue(PathExistsInDigraph.pathExistsDFS(a, a));
        assertTrue(PathExistsInDigraph.pathExistsDFS(a, b));
        assertTrue(PathExistsInDigraph.pathExistsDFS(a, c));
        assertTrue(PathExistsInDigraph.pathExistsDFS(a, d));
        assertTrue(PathExistsInDigraph.pathExistsDFS(a, e));

        assertFalse(PathExistsInDigraph.pathExistsDFS(b, a));
        assertTrue(PathExistsInDigraph.pathExistsDFS(b, b));
        assertTrue(PathExistsInDigraph.pathExistsDFS(b, c));
        assertFalse(PathExistsInDigraph.pathExistsDFS(b, d));
        assertFalse(PathExistsInDigraph.pathExistsDFS(c, e));

        assertFalse(PathExistsInDigraph.pathExistsDFS(c, a));
        assertFalse(PathExistsInDigraph.pathExistsDFS(c, b));
        assertTrue(PathExistsInDigraph.pathExistsDFS(c, c));
        assertFalse(PathExistsInDigraph.pathExistsDFS(c, d));
        assertFalse(PathExistsInDigraph.pathExistsDFS(c, e));

        assertFalse(PathExistsInDigraph.pathExistsDFS(d, a));
        assertFalse(PathExistsInDigraph.pathExistsDFS(d, b));
        assertFalse(PathExistsInDigraph.pathExistsDFS(d, c));
        assertTrue(PathExistsInDigraph.pathExistsDFS(d, d));
        assertTrue(PathExistsInDigraph.pathExistsDFS(d, e));

        assertFalse(PathExistsInDigraph.pathExistsDFS(e, a));
        assertFalse(PathExistsInDigraph.pathExistsDFS(e, b));
        assertFalse(PathExistsInDigraph.pathExistsDFS(e, c));
        assertFalse(PathExistsInDigraph.pathExistsDFS(e, d));
        assertTrue(PathExistsInDigraph.pathExistsDFS(e, e));
    }


    /**
     * <pre>
     * d
     * ^
     * |
     * a -> b -> c
     * ^         |
     * |----------
     * </pre>
     */
    @Test
    public void loop() {
        Graph.Vertex<Character> a = new Graph.Vertex<>('a');
        Graph.Vertex<Character> b = new Graph.Vertex<>('b');
        Graph.Vertex<Character> c = new Graph.Vertex<>('c');
        Graph.Vertex<Character> d = new Graph.Vertex<>('d');
        a.addNeighbor(b);
        b.addNeighbor(c);
        c.addNeighbor(a);
        a.addNeighbor(d);

        assertTrue(PathExistsInDigraph.pathExistsDFS(a, a));
        assertTrue(PathExistsInDigraph.pathExistsDFS(a, b));
        assertTrue(PathExistsInDigraph.pathExistsDFS(a, c));
        assertTrue(PathExistsInDigraph.pathExistsDFS(a, d));

        assertTrue(PathExistsInDigraph.pathExistsDFS(b, a));
        assertTrue(PathExistsInDigraph.pathExistsDFS(b, b));
        assertTrue(PathExistsInDigraph.pathExistsDFS(b, c));
        assertTrue(PathExistsInDigraph.pathExistsDFS(b, d));

        assertTrue(PathExistsInDigraph.pathExistsDFS(c, a));
        assertTrue(PathExistsInDigraph.pathExistsDFS(c, b));
        assertTrue(PathExistsInDigraph.pathExistsDFS(c, c));
        assertTrue(PathExistsInDigraph.pathExistsDFS(c, d));

        assertFalse(PathExistsInDigraph.pathExistsDFS(d, a));
        assertFalse(PathExistsInDigraph.pathExistsDFS(d, b));
        assertFalse(PathExistsInDigraph.pathExistsDFS(d, c));
        assertTrue(PathExistsInDigraph.pathExistsDFS(d, d));
    }
}