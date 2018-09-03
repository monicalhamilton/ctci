package monicalhamilton.ctci.treesandgraphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class BinaryTree {
    private final Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public boolean isBalanced() {
        return root.isBalanced();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryTree that = (BinaryTree) o;
        return Objects.equals(root, that.root);
    }

    @Override
    public int hashCode() {
        return Objects.hash(root);
    }

    @Override
    public String toString() {
        return  root.prettyPrint();
    }

    public Node getRoot() {
        return root;
    }

    public static class Node {
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

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public int getData() {
            return data;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public boolean isLeftChild(Node parent) {
            if (parent == null) {
                return false;
            }
            return parent.getLeft() != null && parent.getLeft() == this;
        }

        public boolean isRightChild(Node parent) {
            if (parent == null) {
                return false;
            }
            return parent.getRight() != null && parent.getRight() == this;
        }

        /**
         * Returns true if the tree is balanced.
         *
         * A tree is balanced if the heights of the two subtrees of any node never differ by more than one.
         */
        private boolean isBalanced() {
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
        private int height() {
            int leftHeight = left == null ? 0 : left.height();
            int rightHeight = right == null ? 0 : right.height();
            return Math.max(leftHeight, rightHeight) + 1;
        }

        private String prettyPrint() {
            return print().toString();
        }

        private Print print() {
            Print leftPrint = left == null ? Print.empty() : left.print();
            Print rightPrint = right == null ? Print.empty() : right.print();

            int thisWidth = String.valueOf(data).length();
            int childWidth = Math.max(leftPrint.width(), rightPrint.width());
            int totalWidth = childWidth * 2 + thisWidth;

            Print newPrint = new Print(totalWidth);
            int i = Math.max(leftPrint.height(), rightPrint.height()) - 1;
            while (i >= 0) {
                StringBuilder string = new StringBuilder(leftPrint.get(i, childWidth));
                for (int j = 0; j < thisWidth; j++) {
                    string.append(" ");
                }
                string.append(rightPrint.get(i, childWidth));
                newPrint.addToTop(string.toString());
                i--;
            }
            newPrint.addToTop(Print.pad(String.valueOf(data), totalWidth));
            return newPrint;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return data == node.data &&
                Objects.equals(left, node.left) &&
                Objects.equals(right, node.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data, left, right);
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
}


