package monicalhamilton.ctci.treesandgraphs;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PathExistsInDigraphTest {

    /**
     * a
     */
    @Test
    public void singletonGraph_originEqualsDestination_returnsTrue() {
        Graph.Vertex<Character> a = new Graph.Vertex<>('a');
        thenPathExists(a, a);
        thenPathDoesNotExist(a, new Graph.Vertex<>('b'));
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
        thenPathExists(origin, origin);
    }

    /**
     * a -> b
     */
    @Test
    public void destinationIsNeighborOfOrigin_returnsTrue() {
        Graph.Vertex<Character> origin = new Graph.Vertex<>('a');
        Graph.Vertex<Character> destination = new Graph.Vertex<>('b');
        origin.addNeighbor(destination);
        thenPathExists(origin, destination);
    }

    /**
     * a <- b
     */
    @Test
    public void originIsNeighborOfDestination_returnsFalse() {
        Graph.Vertex<Character> origin = new Graph.Vertex<>('a');
        Graph.Vertex<Character> destination = new Graph.Vertex<>('b');
        destination.addNeighbor(origin);
        thenPathDoesNotExist(origin, destination);
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
        thenPathExists(origin, destination);
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

        thenPathExists(a, a);
        thenPathExists(a, b);
        thenPathExists(a, c);
        thenPathExists(a, d);
        thenPathExists(a, e);

        thenPathDoesNotExist(b, a);
        thenPathExists(b, b);
        thenPathExists(b, c);
        thenPathDoesNotExist(b, d);
        thenPathDoesNotExist(c, e);

        thenPathDoesNotExist(c, a);
        thenPathDoesNotExist(c, b);
        thenPathExists(c, c);
        thenPathDoesNotExist(c, d);
        thenPathDoesNotExist(c, e);

        thenPathDoesNotExist(d, a);
        thenPathDoesNotExist(d, b);
        thenPathDoesNotExist(d, c);
        thenPathExists(d, d);
        thenPathExists(d, e);

        thenPathDoesNotExist(e, a);
        thenPathDoesNotExist(e, b);
        thenPathDoesNotExist(e, c);
        thenPathDoesNotExist(e, d);
        thenPathExists(e, e);
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

        thenPathExists(a, a);
        thenPathExists(a, b);
        thenPathExists(a, c);
        thenPathExists(a, d);

        thenPathExists(b, a);
        thenPathExists(b, b);
        thenPathExists(b, c);
        thenPathExists(b, d);

        thenPathExists(c, a);
        thenPathExists(c, b);
        thenPathExists(c, c);
        thenPathExists(c, d);

        thenPathDoesNotExist(d, a);
        thenPathDoesNotExist(d, b);
        thenPathDoesNotExist(d, c);
        thenPathExists(d, d);
    }

    private <T> void thenPathExists(Graph.Vertex<T> origin, Graph.Vertex<T> destination) {
        assertTrue(PathExistsInDigraph.pathExistsBFS(origin, destination));
        assertTrue(PathExistsInDigraph.pathExistsDFS(origin, destination));
    }

    private <T> void thenPathDoesNotExist(Graph.Vertex<T> origin, Graph.Vertex<T> destination) {
        assertFalse(PathExistsInDigraph.pathExistsBFS(origin, destination));
        assertFalse(PathExistsInDigraph.pathExistsDFS(origin, destination));
    }
}
