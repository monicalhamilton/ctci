package monicalhamilton.ctci.treesandgraphs;

public class NodeWithParent extends BinaryTree.Node {
    private NodeWithParent parent;

    public NodeWithParent(int data) {
        super(data);
    }

    private void setParent(NodeWithParent parent) {
        this.parent = parent;
    }

    public NodeWithParent getParent() {
        return parent;
    }

    public boolean isLeftChild() {
        return super.isLeftChild(parent);
    }

    public boolean isRightChild() {
        return super.isRightChild(parent);
    }

    public void setLeft(NodeWithParent left) {
        super.setLeft(left);
        left.setParent(this);
    }

    public void setRight(NodeWithParent right) {
        super.setRight(right);
        right.setParent(this);
    }
}


