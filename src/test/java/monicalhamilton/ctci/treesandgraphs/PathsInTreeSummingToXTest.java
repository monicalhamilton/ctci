package monicalhamilton.ctci.treesandgraphs;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PathsInTreeSummingToXTest {

    @Test
    public void whenTreeIsNull_noPathsFound() {
        assertTrue(PathsInTreeSummingToX.findPaths(null, 0).isEmpty());
    }

    @Test
    public void whenTreeIsSingleton_doesNotFindPathLessThanRootValue() {
        BinaryTree tree = new BinaryTree(new BinaryTree.Node(2));
        assertTrue(PathsInTreeSummingToX.findPaths(tree, 1).isEmpty());
    }

    @Test
    public void whenTreeIsSingleton_doesNotFindPathMoreThanRootValue() {
        BinaryTree tree = new BinaryTree(new BinaryTree.Node(2));
        assertTrue(PathsInTreeSummingToX.findPaths(tree, 3).isEmpty());
    }

    @Test
    public void whenTreeIsSingleton_findsPathMatchingRootValue() {
        BinaryTree tree = new BinaryTree(new BinaryTree.Node(1));

        Assertions.assertThat(PathsInTreeSummingToX.findPaths(tree, 1))
                .hasSize(1)
                .contains(Collections.singletonList(tree.getRoot()));
    }

    /**
     * <pre>
     *          1
     *        /   \
     *      2       3
     * </pre>
     */
    @Test
    public void whenSumMatchesMultiplePaths_findsPaths() {
        BinaryTree.Node n1 = new BinaryTree.Node(1);
        BinaryTree.Node n2 = new BinaryTree.Node(2);
        BinaryTree.Node n3 = new BinaryTree.Node(3);
        n1.setLeft(n2);
        n1.setRight(n3);
        BinaryTree tree = new BinaryTree(n1);

        Assertions.assertThat(PathsInTreeSummingToX.findPaths(tree, 3))
                .hasSize(2)
                .contains(Collections.singletonList(n3))
                .contains(Arrays.asList(n1, n2));
    }

    /**
     * <pre>
     *          1
     *            \
     *             2
     * </pre>
     */
    @Test
    public void whenSumMatchesLeaf_findsPath() {
        BinaryTree.Node n1 = new BinaryTree.Node(1);
        BinaryTree.Node n2 = new BinaryTree.Node(2);
        n1.setRight(n2);
        BinaryTree tree = new BinaryTree(n1);

        Assertions.assertThat(PathsInTreeSummingToX.findPaths(tree, 2))
                .hasSize(1)
                .contains(Collections.singletonList(n2));
    }

    /**
     * <pre>
     *          1
     *        /  \
     *      2     5
     *     /       \
     *    3        6
     *   /          \
     *  4           7
     * </pre>
     */
    @Test
    public void whenSumMatchesInternalPath_findsPath() {
        BinaryTree.Node n1 = new BinaryTree.Node(1);
        BinaryTree.Node n2 = new BinaryTree.Node(2);
        BinaryTree.Node n3 = new BinaryTree.Node(3);
        BinaryTree.Node n4 = new BinaryTree.Node(4);
        BinaryTree.Node n5 = new BinaryTree.Node(5);
        BinaryTree.Node n6 = new BinaryTree.Node(6);
        BinaryTree.Node n7 = new BinaryTree.Node(7);
        n1.setLeft(n2);
        n2.setLeft(n3);
        n3.setLeft(n4);
        n1.setRight(n5);
        n5.setRight(n6);
        n6.setRight(n7);
        BinaryTree tree = new BinaryTree(n1);

        Assertions.assertThat(PathsInTreeSummingToX.findPaths(tree, 5))
                .hasSize(2)
                .contains(Arrays.asList(n2, n3))
                .contains(Collections.singletonList(n5));
    }

    /**
     * <pre>
     *          1
     *        /  \
     *      2     1
     *     /       \
     *    1        2
     * </pre>
     */
    @Test
    public void whenPathFoundInRightAndLeft_findsPaths() {
        BinaryTree.Node root = new BinaryTree.Node(1);
        BinaryTree.Node left1 = new BinaryTree.Node(1);
        BinaryTree.Node left2 = new BinaryTree.Node(2);
        BinaryTree.Node right1 = new BinaryTree.Node(1);
        BinaryTree.Node right2 = new BinaryTree.Node(2);
        root.setLeft(left2);
        left2.setLeft(left1);
        root.setRight(right1);
        right1.setRight(right2);
        BinaryTree tree = new BinaryTree(root);

        Assertions.assertThat(PathsInTreeSummingToX.findPaths(tree, 4))
                .hasSize(2)
                .contains(Arrays.asList(root, left2, left1))
                .contains(Arrays.asList(root, right1, right2));
    }

    /**
     * <pre>
     *          1
     *        /   \
     *      2       8
     *     / \
     *   3    5
     *  /    / \
     * 4    6  7
     * </pre>
     */
    @Test
    public void complex_findsPaths() {
        BinaryTree.Node n4 = new BinaryTree.Node(4);
        BinaryTree.Node n3 = new BinaryTree.Node(3);
        n3.setLeft(n4);

        BinaryTree.Node n6 = new BinaryTree.Node(6);
        BinaryTree.Node n7 = new BinaryTree.Node(7);
        BinaryTree.Node n5 = new BinaryTree.Node(5);
        n5.setLeft(n6);
        n5.setRight(n7);

        BinaryTree.Node n2 = new BinaryTree.Node(2);
        n2.setLeft(n3);
        n2.setRight(n5);

        BinaryTree.Node n8 = new BinaryTree.Node(8);
        BinaryTree.Node n1 = new BinaryTree.Node(1);
        n1.setLeft(n2);
        n1.setRight(n8);
        BinaryTree tree = new BinaryTree(n1);

        Assertions.assertThat(PathsInTreeSummingToX.findPaths(tree, 9))
                .hasSize(2)
                .contains(Arrays.asList(n1, n8))
                .contains(Arrays.asList(n2, n3, n4));

        Assertions.assertThat(PathsInTreeSummingToX.findPaths(tree, 14))
                .hasSize(2)
                .contains(Arrays.asList(n1, n2, n5, n6))
                .contains(Arrays.asList(n2, n5, n7));
    }
}