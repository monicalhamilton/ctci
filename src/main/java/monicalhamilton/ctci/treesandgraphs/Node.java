package monicalhamilton.ctci.treesandgraphs;

import java.util.LinkedList;
import java.util.List;

public class Node {
    private int data; // Skipping the generics for simplicity
    private Node left;
    private Node right;

    public Node(int data) {
        this.data = data;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    /**
     * Returns true if the tree is balanced.
     *
     * A tree is balanced if the heights of the two subtrees of any node never differ by more than one.
     */
    public boolean isBalanced() {
        return heightIfBalanced(this) >= 0;
    }

    /**
     * Returns the height of the tree or -1 if unbalanced
     */
    private int heightIfBalanced(Node n) {
        if (n == null) {
            return 0;
        }
        int left = heightIfBalanced(n.left);
        if (left < 0) return -1;
        int right = heightIfBalanced(n.right);
        if (right < 0) return -1;
        if (Math.abs(left - right) > 1) return -1;
        else return Math.max(left, right) + 1;
    }

    /**
     * Returns the height of a tree.
     */
    public int height() {
        int leftHeight = left == null ? 0 : left.height();
        int rightHeight = right == null ? 0 : right.height();
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public String printTree() {
        return printInternal().toString();
    }

    private Print printInternal() {
        Print leftPrint = left == null ? Print.empty() : left.printInternal();
        Print rightPrint = right == null ? Print.empty() : right.printInternal();

        int childWidth = Math.max(leftPrint.width(), rightPrint.width());
        int totalWidth = childWidth * 2 + 1;

        Print newPrint = new Print(totalWidth);
        int i = Math.max(leftPrint.height(), rightPrint.height()) - 1;
        while (i >= 0) {
            newPrint.addToTop(leftPrint.get(i, childWidth) + " " + rightPrint.get(i, childWidth));
            i--;
        }
        newPrint.addToTop(Print.pad(String.valueOf(data), totalWidth));
        return newPrint;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }

    private static class Print {
        private final List<String> lines = new LinkedList<>();
        private final int width;

        private Print(int width) {
            this.width = width;
        }

        private static Print empty() {
            return new Print(0);
        }

        private void addToTop(String string) {
            if (string.length() != width) {
                throw new IllegalArgumentException("String does not match print width");
            }
            lines.add(0, string);
        }

        private String get(int lineNumber, int paddedWidth) {
            String line = (lineNumber >= lines.size() || lines.isEmpty()) ? "" : lines.get(lineNumber);
            return pad(line, paddedWidth);
        }

        private static String pad(String line, int totalWidth) {
            StringBuilder stringBuilder = new StringBuilder();
            int totalPadding = totalWidth - line.length();
            int leftPad = totalPadding / 2;
            int rightPad = totalPadding - leftPad;
            for (int i = 0; i < leftPad; i++) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(line);
            for (int i = 0; i < rightPad; i++) {
                stringBuilder.append(" ");
            }
            return stringBuilder.toString();
        }

        private int width() {
            return lines.stream().findFirst().map(String::length).orElse(0);
        }

        private int height() {
            return lines.size();
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            for (String line : lines) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
            return stringBuilder.toString();
        }
    }

}


