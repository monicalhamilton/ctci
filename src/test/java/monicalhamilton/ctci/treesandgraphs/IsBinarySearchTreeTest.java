package monicalhamilton.ctci.treesandgraphs;

import org.junit.Test;

import static org.junit.Assert.*;

public class IsBinarySearchTreeTest {

    @Test
    public void null_returnsTrue() {
        assertTrue(IsBinarySearchTree.isBinarySearchTree(null));
    }

    @Test
    public void nullRoot_returnsTrue() {
        assertTrue(IsBinarySearchTree.isBinarySearchTree(new BinaryTree(null)));
    }

    @Test
    public void singleNode_returnsTrue() {
        assertTrue(IsBinarySearchTree.isBinarySearchTree(new BinaryTree(new BinaryTree.Node(1))));
    }

    @Test
    public void leftChildGreaterThanParent_returnsFalse() {
        BinaryTree.Node one = new BinaryTree.Node(1);
        BinaryTree.Node two = new BinaryTree.Node(2);
        one.setLeft(two);
        assertFalse(IsBinarySearchTree.isBinarySearchTree(new BinaryTree(one)));
    }

    @Test
    public void leftChildLessThanParent_returnsTrue() {
        BinaryTree.Node one = new BinaryTree.Node(1);
        BinaryTree.Node two = new BinaryTree.Node(2);
        two.setLeft(one);
        assertTrue(IsBinarySearchTree.isBinarySearchTree(new BinaryTree(two)));
    }

    @Test
    public void leftChildEqualsParent_returnsTrue() {
        BinaryTree.Node one = new BinaryTree.Node(1);
        BinaryTree.Node anotherOne = new BinaryTree.Node(1);
        one.setLeft(anotherOne);
        assertTrue(IsBinarySearchTree.isBinarySearchTree(new BinaryTree(one)));
    }

    @Test
    public void rightChildLessThanParent_returnsFalse() {
        BinaryTree.Node one = new BinaryTree.Node(1);
        BinaryTree.Node two = new BinaryTree.Node(2);
        two.setRight(one);
        assertFalse(IsBinarySearchTree.isBinarySearchTree(new BinaryTree(two)));
    }

    @Test
    public void rightChildGreaterThanParent_returnsTrue() {
        BinaryTree.Node one = new BinaryTree.Node(1);
        BinaryTree.Node two = new BinaryTree.Node(2);
        one.setRight(two);
        assertTrue(IsBinarySearchTree.isBinarySearchTree(new BinaryTree(one)));
    }

    @Test
    public void rightChildEqualsParent_returnsTrue() {
        BinaryTree.Node one = new BinaryTree.Node(1);
        BinaryTree.Node anotherOne = new BinaryTree.Node(1);
        one.setRight(anotherOne);
        assertTrue(IsBinarySearchTree.isBinarySearchTree(new BinaryTree(one)));
    }

    @Test
    public void lowerLevelOutOfOrder_returnsFalse() {
        BinaryTree.Node four = new BinaryTree.Node(4);
        BinaryTree.Node five = new BinaryTree.Node(5);
        BinaryTree.Node six = new BinaryTree.Node(6);
        four.setRight(five);
        five.setLeft(six);
        assertFalse(IsBinarySearchTree.isBinarySearchTree(new BinaryTree(four)));
    }

    @Test
    public void bigTreeInOrder_returnsTrue() {
        BinaryTree.Node one = new BinaryTree.Node(1);
        BinaryTree.Node two = new BinaryTree.Node(2);
        BinaryTree.Node three = new BinaryTree.Node(3);
        BinaryTree.Node four = new BinaryTree.Node(4);
        BinaryTree.Node five = new BinaryTree.Node(5);
        BinaryTree.Node six = new BinaryTree.Node(6);
        BinaryTree.Node seven = new BinaryTree.Node(7);

        four.setLeft(two);
        four.setRight(six);

        two.setLeft(one);
        two.setRight(three);

        six.setLeft(five);
        six.setRight(seven);

        assertTrue(IsBinarySearchTree.isBinarySearchTree(new BinaryTree(one)));
    }

    @Test
    public void rightChildGreaterThanGrandparent_returnsFalse() {
        BinaryTree.Node root = new BinaryTree.Node(20);
        BinaryTree.Node leftChild = new BinaryTree.Node(10);
        root.setLeft(leftChild);
        BinaryTree.Node leftRightGrandchild = new BinaryTree.Node(25);
        leftChild.setRight(leftRightGrandchild);
        BinaryTree.Node rightChild = new BinaryTree.Node(30);
        root.setRight(rightChild);

        assertFalse(IsBinarySearchTree.isBinarySearchTree(new BinaryTree(root)));
    }

    @Test
    public void leftChildlessThanGrandparent_returnsFalse() {
        BinaryTree.Node root = new BinaryTree.Node(20);
        BinaryTree.Node leftChild = new BinaryTree.Node(10);
        root.setLeft(leftChild);
        BinaryTree.Node rightChild = new BinaryTree.Node(30);
        root.setRight(rightChild);
        BinaryTree.Node rightLeftGrandchild = new BinaryTree.Node(5);
        leftChild.setRight(rightLeftGrandchild);

        assertFalse(IsBinarySearchTree.isBinarySearchTree(new BinaryTree(root)));
    }
}
