package monicalhamilton.ctci.treesandgraphs;

/**
 * 4.3
 *
 * Given a sorted (increasing order) array with unique integer elements, write an algorithm to create a binary search
 * tree with minimal height.
 */
public class BinarySearchTreeFromSortedArray {

    public static BinaryTree createBST(int[] sortedArray) {
        if (sortedArray == null || sortedArray.length == 0) {
            return null;
        }
        return new BinaryTree(createBST(sortedArray, 0, sortedArray.length - 1));
    }

    private static BinaryTree.Node createBST(int[] sortedArray, int leftIndex, int rightIndex) {
        int midIndex = (rightIndex - leftIndex) / 2 + leftIndex;
        BinaryTree.Node n = new BinaryTree.Node(sortedArray[midIndex]);
        if (leftIndex != midIndex) {
            n.setLeft(createBST(sortedArray, leftIndex, midIndex - 1));
        }
        if (rightIndex != midIndex) {
            n.setRight(createBST(sortedArray, midIndex + 1, rightIndex));
        }
        return n;
    }
}
