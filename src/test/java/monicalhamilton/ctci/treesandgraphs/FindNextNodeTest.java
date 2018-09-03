package monicalhamilton.ctci.treesandgraphs;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindNextNodeTest {

    @Test
    public void null_returnsNull() {
        assertNull(FindNextNode.findNextNode(new NodeWithParent(1)));
    }

    @Test
    public void singleton_returnsNull() {
        assertNull(FindNextNode.findNextNode(new NodeWithParent(1)));
    }

    @Test
    public void fullAndComplete() {
        NodeWithParent one = new NodeWithParent(1);
        NodeWithParent two = new NodeWithParent(2);
        NodeWithParent three = new NodeWithParent(3);
        NodeWithParent four = new NodeWithParent(4);
        NodeWithParent five = new NodeWithParent(5);
        NodeWithParent six = new NodeWithParent(6);
        NodeWithParent seven = new NodeWithParent(7);
        four.setLeft(two); // root
        two.setLeft(one);
        two.setRight(three);
        four.setRight(six);
        six.setLeft(five);
        six.setRight(seven);

        assertEquals(two, FindNextNode.findNextNode(one));
        assertEquals(three, FindNextNode.findNextNode(two));
        assertEquals(four, FindNextNode.findNextNode(three));
        assertEquals(five, FindNextNode.findNextNode(four));
        assertEquals(six, FindNextNode.findNextNode(five));
        assertEquals(seven, FindNextNode.findNextNode(six));
        assertNull(FindNextNode.findNextNode(seven));
    }

    @Test
    public void unbalanced() {
        NodeWithParent n13 = new NodeWithParent(13);
        NodeWithParent n14 = new NodeWithParent(14);
        NodeWithParent n15 = new NodeWithParent(15);
        NodeWithParent n20 = new NodeWithParent(20);
        NodeWithParent n25 = new NodeWithParent(25);
        NodeWithParent n30 = new NodeWithParent(30);
        NodeWithParent n40 = new NodeWithParent(40);
        NodeWithParent n43 = new NodeWithParent(43);
        NodeWithParent n44 = new NodeWithParent(44);
        NodeWithParent n45 = new NodeWithParent(45);

        n30.setLeft(n20); // root
        n30.setRight(n40);

        n20.setLeft(n15);
        n20.setRight(n25);
        n15.setLeft(n14);
        n14.setLeft(n13);

        n40.setRight(n45);
        n45.setLeft(n43);
        n43.setRight(n44);

        BinaryTree tree = new BinaryTree(n30);
        assertTrue(IsBinarySearchTree.isBinarySearchTree(tree));
        System.out.println(tree);

        assertEquals(n14, FindNextNode.findNextNode(n13));
        assertEquals(n15, FindNextNode.findNextNode(n14));
        assertEquals(n20, FindNextNode.findNextNode(n15));
        assertEquals(n25, FindNextNode.findNextNode(n20));
        assertEquals(n30, FindNextNode.findNextNode(n25));
        assertEquals(n40, FindNextNode.findNextNode(n30));
        assertEquals(n43, FindNextNode.findNextNode(n40));
        assertEquals(n44, FindNextNode.findNextNode(n43));
        assertEquals(n45, FindNextNode.findNextNode(n44));
        assertNull(FindNextNode.findNextNode(n45));
    }
}
