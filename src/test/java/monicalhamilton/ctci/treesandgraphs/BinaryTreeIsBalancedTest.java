package monicalhamilton.ctci.treesandgraphs;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BinaryTreeIsBalancedTest {

    @Test
    public void whenTreeIsNull_isBalanced() {
        assertTrue(BinaryTreeIsBalanced.isBalanced(null));
        assertTrue(BinaryTreeIsBalancedNonOO.isBalanced(null));
    }

    @Test
    public void whenTreeIsSingleton_isBalanced() {
        BinaryTree n1 = new BinaryTree(new BinaryTree.Node(1));
        assertTrue(BinaryTreeIsBalanced.isBalanced(n1));
        assertTrue(BinaryTreeIsBalancedNonOO.isBalanced(n1.getRoot()));
    }

    /**
     * <pre>
     *          1
     *        /   \
     *      2       3
     * </pre>
     */
    @Test
    public void whenTreeIsFull_isBalanced() {
        BinaryTree.Node n1 = new BinaryTree.Node(1);
        BinaryTree.Node n2 = new BinaryTree.Node(2);
        BinaryTree.Node n3 = new BinaryTree.Node(3);
        n1.setLeft(n2);
        n1.setRight(n3);
        assertTrue(BinaryTreeIsBalanced.isBalanced(new BinaryTree(n1)));
        assertTrue(BinaryTreeIsBalancedNonOO.isBalanced(n1));
    }

    /**
     * <pre>
     *          1
     *        /
     *      2
     * </pre>
     */
    @Test
    public void whenHeightsDifferByOne_isBalanced() {
        BinaryTree.Node n1 = new BinaryTree.Node(1);
        BinaryTree.Node n2 = new BinaryTree.Node(2);
        n1.setLeft(n2);
        assertTrue(BinaryTreeIsBalanced.isBalanced(new BinaryTree(n1)));
        assertTrue(BinaryTreeIsBalancedNonOO.isBalanced(n1));
    }

    /**
     * <pre>
     *          1
     *        /  \
     *      2     4
     *     /       \
     *    3        5
     * </pre>
     */
    @Test
    public void whenHeightsSame_isBalanced() {
        BinaryTree.Node n1 = new BinaryTree.Node(1);
        BinaryTree.Node n2 = new BinaryTree.Node(2);
        BinaryTree.Node n3 = new BinaryTree.Node(3);
        BinaryTree.Node n4 = new BinaryTree.Node(4);
        BinaryTree.Node n5 = new BinaryTree.Node(5);
        n1.setLeft(n2);
        n2.setLeft(n3);
        n1.setRight(n4);
        n4.setRight(n5);
        assertTrue(BinaryTreeIsBalanced.isBalanced(new BinaryTree(n1)));
        assertTrue(BinaryTreeIsBalancedNonOO.isBalanced(n1));
    }

    /**
     * <pre>
     *          1
     *        /  \
     *      2     5
     *     /       \
     *    3        6
     *   /
     *  4
     * </pre>
     */
    @Test
    public void whenSubtreeUnbalanced_isUnbalanced() {
        BinaryTree.Node n1 = new BinaryTree.Node(1);
        BinaryTree.Node n2 = new BinaryTree.Node(2);
        BinaryTree.Node n3 = new BinaryTree.Node(3);
        BinaryTree.Node n4 = new BinaryTree.Node(4);
        BinaryTree.Node n5 = new BinaryTree.Node(5);
        BinaryTree.Node n6 = new BinaryTree.Node(6);
        n1.setLeft(n2);
        n2.setLeft(n3);
        n3.setLeft(n4);
        n1.setRight(n5);
        n5.setRight(n6);
        assertFalse(BinaryTreeIsBalanced.isBalanced(new BinaryTree(n1)));
        assertFalse(BinaryTreeIsBalancedNonOO.isBalanced(n1));
    }

    /**
     * <pre>
     *          1
     *        /   \
     *      2       8
     *     / \
     *   3    5
     *  /    / \
     *  4    6 7
     * </pre>
     */
    @Test
    public void complex_isUnbalanced() {
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

        assertFalse(BinaryTreeIsBalanced.isBalanced(new BinaryTree(n1)));
        assertFalse(BinaryTreeIsBalancedNonOO.isBalanced(n1));
    }

    /**
     * <pre>
     *          1
     *        /   \
     *      2       8
     *     / \       \
     *   3    5       9
     *  /    / \
     *  4    6 7
     * </pre>
     */
    @Test
    public void complex_isBalanced() {
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

        BinaryTree.Node n9 = new BinaryTree.Node(9);
        BinaryTree.Node n8 = new BinaryTree.Node(8);
        n8.setRight(n9);

        BinaryTree.Node n1 = new BinaryTree.Node(1);
        n1.setLeft(n2);
        n1.setRight(n8);

        assertTrue(BinaryTreeIsBalanced.isBalanced(new BinaryTree(n1)));
        assertTrue(BinaryTreeIsBalancedNonOO.isBalanced(n1));
    }
}