package monicalhamilton.ctci.treesandgraphs;

import java.util.*;

/**
 * 4.9
 * <p>
 * You are given a binary tree in which each node contains a value. Design an algorithm to print all paths which sum to
 * a given value. Note that a path can start or end anywhere in the tree.
 */
public class PathsInTreeSummingToX {

    public static void printPaths(BinaryTree tree, int sum) {
        for (List<BinaryTree.Node> path : findPaths(tree, sum)) {
            System.out.println(path);
        }
    }

    public static Collection<List<BinaryTree.Node>> findPaths(BinaryTree tree, int sum) {
        if (tree == null) {
            return Collections.emptyList();
        }
        return findPaths(tree.getRoot(), sum, 0, new LinkedList<>());
    }

    private static Collection<List<BinaryTree.Node>> findPaths(BinaryTree.Node n, int sumToFind, int currentSum,
                                                                Queue<BinaryTree.Node> queue) {

        Collection<List<BinaryTree.Node>> paths = new LinkedList<>();

        if (n == null) {
            return paths;
        }

        queue.add(n);
        currentSum += n.getData();
        while (currentSum >= sumToFind && !queue.isEmpty()) {
            if (currentSum == sumToFind) {
                paths.add(new LinkedList<>(queue));
            }
            BinaryTree.Node previousHead = queue.remove();
            currentSum -= previousHead.getData();
        }
        paths.addAll(findPaths(n.getLeft(), sumToFind, currentSum, new LinkedList<>(queue)));
        paths.addAll(findPaths(n.getRight(), sumToFind, currentSum, new LinkedList<>(queue)));
        return paths;
    }
}
