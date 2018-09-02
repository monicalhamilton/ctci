package monicalhamilton.ctci.treesandgraphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 4.2
 *
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 */
public class PathExistsInDigraph {

    public static <T> boolean pathExistsDFS(Graph.Vertex<T> origin, Graph.Vertex<T> destination) {
        return pathExistsDFS(origin, destination, new HashSet<>());
    }

    private static <T> boolean pathExistsDFS(Graph.Vertex<T> origin, Graph.Vertex<T> destination, Set<Graph.Vertex<T>> visited) {
        visited.add(origin);
        if (origin == destination) {
            return true;
        }
        for (Graph.Vertex<T> neighbor : origin.getNeighbors()) {
            if (!visited.contains(neighbor)) {
                if (pathExistsDFS(neighbor, destination, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static <T> boolean pathExistsBFS(Graph.Vertex<T> origin, Graph.Vertex<T> destination) {
        return pathExistsBFS(origin, destination, new HashSet<>());
    }

    private static <T> boolean pathExistsBFS(Graph.Vertex<T> origin, Graph.Vertex<T> destination, HashSet<Graph.Vertex<T>> visited) {
        Queue<Graph.Vertex<T>> queue = new LinkedList<>();
        queue.offer(origin);
        while (!queue.isEmpty()) {
            Graph.Vertex<T> current = queue.poll();
            if (current == destination) {
                return true;
            }
            for (Graph.Vertex<T> neighbor : current.getNeighbors()) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                }
            }
        }
        return false;
    }
}
