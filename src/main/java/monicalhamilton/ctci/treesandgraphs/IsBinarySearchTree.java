package monicalhamilton.ctci.treesandgraphs;

/**
 * 4.5
 *
 * Implement a function to check if a binary tree is a binary search tree.
 */
public class IsBinarySearchTree {

    public static boolean isBinarySearchTree(BinaryTree binaryTree) {
        if (binaryTree == null) {
            return true;
        }
        return isBinarySearchTree(binaryTree.getRoot(), null);
    }

    private static boolean isBinarySearchTree(BinaryTree.Node node, BinaryTree.Node parent) {
        if (node == null) {
            return true;
        }
        if (node.getLeft() != null) {
            if (node.getLeft().getData() > node.getData()) {
                return false;
            }
            if (parent != null && parent.getRight().equals(node) && node.getLeft().getData() < parent.getData()) {
                return false;
            }
        }
        if (node.getRight() != null) {
            if (node.getRight().getData() < node.getData()) {
                return false;
            }
            if (parent != null && parent.getLeft().equals(node) && node.getRight().getData() > parent.getData()) {
                return false;
            }
        }
        return isBinarySearchTree(node.getLeft(), node) && isBinarySearchTree(node.getRight(), node);
    }
}
