package monicalhamilton.ctci.treesandgraphs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchTreeFromSortedArrayTest {

    @Test
    public void emptyArray() {
        thenResultIs(null);
    }

    @Test
    public void singletonArray() {
        BinaryTree.Node root = new BinaryTree.Node(1);
        BinaryTree expected = new BinaryTree(root);
        thenResultIs(expected, 1);
    }

    @Test
    public void arraySizeTwo() {
        BinaryTree.Node root = new BinaryTree.Node(1);
        BinaryTree.Node right = new BinaryTree.Node(2);
        root.setRight(right);
        BinaryTree expected = new BinaryTree(root);
        thenResultIs(expected, 1, 2);
    }

    @Test
    public void arraySizeThree() {
        BinaryTree.Node left = new BinaryTree.Node(1);
        BinaryTree.Node root = new BinaryTree.Node(2);
        BinaryTree.Node right = new BinaryTree.Node(3);
        root.setRight(right);
        root.setLeft(left);
        BinaryTree expected = new BinaryTree(root);

        thenResultIs(expected, 1, 2, 3);
    }

    @Test
    public void arraySizeFour() {
        BinaryTree.Node one = new BinaryTree.Node(1);
        BinaryTree.Node two = new BinaryTree.Node(2);
        BinaryTree.Node three = new BinaryTree.Node(3);
        BinaryTree.Node four = new BinaryTree.Node(4);
        two.setLeft(one);
        two.setRight(three);
        three.setRight(four);
        BinaryTree expected = new BinaryTree(two);

        thenResultIs(expected, 1, 2, 3, 4);
    }

    @Test
    public void arraySizeSeven() {
        BinaryTree.Node one = new BinaryTree.Node(1);
        BinaryTree.Node three = new BinaryTree.Node(3);
        BinaryTree.Node two = new BinaryTree.Node(2);
        two.setLeft(one);
        two.setRight(three);

        BinaryTree.Node five = new BinaryTree.Node(5);
        BinaryTree.Node seven = new BinaryTree.Node(7);
        BinaryTree.Node six = new BinaryTree.Node(6);
        six.setLeft(five);
        six.setRight(seven);

        BinaryTree.Node four = new BinaryTree.Node(4);
        four.setLeft(two);
        four.setRight(six);

        BinaryTree expected = new BinaryTree(four);

        thenResultIs(expected, 1, 2, 3, 4, 5, 6, 7);
    }

    private void thenResultIs(BinaryTree expected, int... arrayValues) {
        assertEquals(expected, BinarySearchTreeFromSortedArray.createBST(arrayValues));
    }
}
