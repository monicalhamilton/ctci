package monicalhamilton.ctci.treesandgraphs;

public class BinaryTreeIsBalancedNonOO {

    public static boolean isBalanced(BinaryTree.Node root) {
        if (root == null) {
            return true;
        }
        return recursiveIsBalanced(root).balanced;
    }

    private static BalanceAndHeight recursiveIsBalanced(BinaryTree.Node node) {
        if (node.isLeaf()) {
            return BalanceAndHeight.leaf();
        }

        final int leftHeight;
        final boolean leftIsBalanced;
        if (node.getLeft() != null) {
            BalanceAndHeight balanceAndHeight = recursiveIsBalanced(node.getLeft());
            leftHeight = balanceAndHeight.height;
            leftIsBalanced = balanceAndHeight.balanced;
        } else {
            leftHeight = 0;
            leftIsBalanced = true;
        }

        final int rightHeight;
        final boolean rightIsBalanced;
        if (node.getRight() != null) {
            BalanceAndHeight balanceAndHeight = recursiveIsBalanced(node.getRight());
            rightHeight = balanceAndHeight.height;
            rightIsBalanced = balanceAndHeight.balanced;
        } else {
            rightHeight = 0;
            rightIsBalanced = true;
        }
        boolean isBalanced = leftIsBalanced && rightIsBalanced && Math.abs(leftHeight - rightHeight) <= 1;
        return new BalanceAndHeight(1 + Math.max(leftHeight, rightHeight), isBalanced);
    }


    private static class BalanceAndHeight {
        int height;
        boolean balanced;

        BalanceAndHeight(int height, boolean balanced) {
            this.height = height;
            this.balanced = balanced;
        }

        private static BalanceAndHeight leaf() {
            return new BalanceAndHeight(1, true);
        }
    }
}
