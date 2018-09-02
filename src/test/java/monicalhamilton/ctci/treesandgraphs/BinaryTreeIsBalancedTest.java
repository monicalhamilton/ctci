package monicalhamilton.ctci.treesandgraphs;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BinaryTreeIsBalancedTest {

    @Test
    public void whenTreeIsNull_isBalanced() {
        assertTrue(BinaryTreeIsBalanced.isBalanced(null));
    }

    @Test
    public void whenTreeIsSingleton_isBalanced() {
        Node n1 = new Node(1);
        assertTrue(BinaryTreeIsBalanced.isBalanced(n1));
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
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.setLeft(n2);
        n1.setRight(n3);
        assertTrue(BinaryTreeIsBalanced.isBalanced(n1));
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
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.setLeft(n2);
        assertTrue(BinaryTreeIsBalanced.isBalanced(n1));
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
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.setLeft(n2);
        n2.setLeft(n3);
        n1.setRight(n4);
        n4.setRight(n5);
        assertTrue(BinaryTreeIsBalanced.isBalanced(n1));
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
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        n1.setLeft(n2);
        n2.setLeft(n3);
        n3.setLeft(n4);
        n1.setRight(n5);
        n5.setRight(n6);
        assertFalse(BinaryTreeIsBalanced.isBalanced(n1));
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
        Node n4 = new Node(4);
        Node n3 = new Node(3);
        n3.setLeft(n4);

        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n5 = new Node(5);
        n5.setLeft(n6);
        n5.setRight(n7);

        Node n2 = new Node(2);
        n2.setLeft(n3);
        n2.setRight(n5);

        Node n8 = new Node(8);
        Node n1 = new Node(1);
        n1.setLeft(n2);
        n1.setRight(n8);

        assertFalse(BinaryTreeIsBalanced.isBalanced(n1));
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
        Node n4 = new Node(4);
        Node n3 = new Node(3);
        n3.setLeft(n4);

        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n5 = new Node(5);
        n5.setLeft(n6);
        n5.setRight(n7);

        Node n2 = new Node(2);
        n2.setLeft(n3);
        n2.setRight(n5);

        Node n9 = new Node(9);
        Node n8 = new Node(8);
        n8.setRight(n9);

        Node n1 = new Node(1);
        n1.setLeft(n2);
        n1.setRight(n8);

        assertTrue(BinaryTreeIsBalanced.isBalanced(n1));
    }
}