package monicalhamilton.ctci.treesandgraphs;

/**
 * 4.6
 *
 * Write an algorithm to find the 'next' node (i.e., in-order successor) of a given node in a binary search tree. You
 * may assume that each node has a link to its parent.
 */
public class FindNextNode {

    public static BinaryTree.Node findNextNode(NodeWithParent node) {
        if (node == null) {
            return null;
        }
        if (node.getRight() != null) {
            return firstRightNodeWithoutLeftChild(node);
        } else {
            if (node.isLeftChild()) {
                return node.getParent();
            }
            if (node.isRightChild()) {
                return firstParentOfLeftNode(node);
            } else {
                return null; // root is only node
            }
        }
    }

    private static BinaryTree.Node firstParentOfLeftNode(NodeWithParent node) {
        NodeWithParent current = node.getParent();
        while (current.getParent() != null && !current.isLeftChild()) {
            current = current.getParent();
        }
        return current.getParent();
    }

    private static BinaryTree.Node firstRightNodeWithoutLeftChild(NodeWithParent node) {
        BinaryTree.Node current = node.getRight();
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }
}
