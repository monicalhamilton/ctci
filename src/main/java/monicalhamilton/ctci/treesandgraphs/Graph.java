package monicalhamilton.ctci.treesandgraphs;

import java.util.Collection;
import java.util.LinkedList;

public class Graph<T> {
    private Collection<Vertex<T>> vertices;

    static class Vertex<T> {
        private final T data;
        private Collection<Vertex<T>> neighbors = new LinkedList<>();

        public Vertex(T data) {
            this.data = data;
        }

        public Collection<Vertex<T>> getNeighbors() {
            return neighbors;
        }

        public void addNeighbor(Vertex<T> neighbor) {
            neighbors.add(neighbor);
        }
    }
}
