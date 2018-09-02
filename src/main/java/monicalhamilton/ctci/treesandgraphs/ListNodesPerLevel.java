package monicalhamilton.ctci.treesandgraphs;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 4.4
 *
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth (e.g., if you
 * have a tree with depth D, you'll have D linked lists).
 */
public class ListNodesPerLevel {

    public static Collection<List<Integer>> listLevels(BinaryTree binaryTree) {
        if (binaryTree == null || binaryTree.getRoot() == null) {
            return Collections.emptyList();
        }
        Collection<List<Integer>> levels = new LinkedList<>();

        Queue<BinaryTree.Node> parentQueue = new LinkedList<>();
        Queue<BinaryTree.Node> childQueue = new LinkedList<>();
        parentQueue.offer(binaryTree.getRoot());
        Queue<BinaryTree.Node> currentQueue = parentQueue;
        List<Integer> currentLevel = new LinkedList<>();
        while (!currentQueue.isEmpty()) {
            BinaryTree.Node n = currentQueue.poll();
            currentLevel.add(n.getData());
            if (n.getLeft() != null) {
                childQueue.offer(n.getLeft());
            }
            if (n.getRight() != null) {
                childQueue.offer(n.getRight());
            }
            if (currentQueue.isEmpty()) {
                currentQueue = childQueue;
                childQueue = new LinkedList<>();
                levels.add(currentLevel);
                currentLevel = new LinkedList<>();
            }
        }
        return levels;
    }
}
