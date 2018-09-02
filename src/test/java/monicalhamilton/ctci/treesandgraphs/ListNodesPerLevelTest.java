package monicalhamilton.ctci.treesandgraphs;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListNodesPerLevelTest {

    @Test
    public void empty() {
        BinaryTree tree = new BinaryTree(null);
        Collection<List<Integer>> actual = ListNodesPerLevel.listLevels(tree);
        assertEquals(Collections.emptyList(), actual);
    }

    @Test
    public void singleton() {
        BinaryTree.Node root = new BinaryTree.Node(1);
        BinaryTree tree = new BinaryTree(root);
        Collection<List<Integer>> actual = ListNodesPerLevel.listLevels(tree);
        assertEquals(Collections.singletonList(Collections.singletonList(1)), actual);
    }

    /**
     * <pre>
     *          4
     *        /   \
     *      2       6
     *     / \    /  \
     *   1    3  5    7
     * </pre>
     */
    @Test
    public void fullAndCompleteTree() {
        BinaryTree.Node one = new BinaryTree.Node(1);
        BinaryTree.Node two = new BinaryTree.Node(2);
        BinaryTree.Node three = new BinaryTree.Node(3);
        BinaryTree.Node four = new BinaryTree.Node(4);
        BinaryTree.Node five = new BinaryTree.Node(5);
        BinaryTree.Node six = new BinaryTree.Node(6);
        BinaryTree.Node seven = new BinaryTree.Node(7);

        four.setLeft(two);
        two.setLeft(one);
        two.setRight(three);

        four.setRight(six);
        six.setLeft(five);
        six.setRight(seven);

        BinaryTree tree = new BinaryTree(four);
        Collection<List<Integer>> actual = ListNodesPerLevel.listLevels(tree);

        Collection<List<Integer>> expected = new LinkedList<>();
        expected.add(Collections.singletonList(4));
        expected.add(Arrays.asList(2, 6));
        expected.add(Arrays.asList(1, 3, 5, 7));
        assertEquals(expected, actual);
    }

    /**
     * <pre>
     *          4
     *        /   \
     *      2       6
     *     /      /  \
     *   1       5    7
     *                 \
     *                  8
     * </pre>
     */
    @Test
    public void unbalancedTree() {
        BinaryTree.Node one = new BinaryTree.Node(1);
        BinaryTree.Node two = new BinaryTree.Node(2);
        BinaryTree.Node four = new BinaryTree.Node(4);
        BinaryTree.Node five = new BinaryTree.Node(5);
        BinaryTree.Node six = new BinaryTree.Node(6);
        BinaryTree.Node seven = new BinaryTree.Node(7);
        BinaryTree.Node eight = new BinaryTree.Node(8);

        four.setLeft(two);
        two.setLeft(one);

        four.setRight(six);
        six.setLeft(five);
        six.setRight(seven);

        seven.setRight(eight);

        BinaryTree tree = new BinaryTree(four);
        Collection<List<Integer>> actual = ListNodesPerLevel.listLevels(tree);

        Collection<List<Integer>> expected = new LinkedList<>();
        expected.add(Collections.singletonList(4));
        expected.add(Arrays.asList(2, 6));
        expected.add(Arrays.asList(1, 5, 7));
        expected.add(Collections.singletonList(8));
        assertEquals(expected, actual);
    }
}
