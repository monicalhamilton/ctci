package monicalhamilton.ctci.treesandgraphs;

/**
 * 4.1
 *
 * Implement a function to check if a binary tree is balanced. For the purposes of this question, a balanced tree is
 * defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.
 */
public class BinaryTreeIsBalanced {

    public static boolean isBalanced(BinaryTree binaryTree) {
        if (binaryTree == null) {
            return true;
        }
        return binaryTree.isBalanced();
    }
}
