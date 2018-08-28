package monicalhamilton.ctci.stacks;

import monicalhamilton.ctci.linkedlists.Node;

/**
 * 3.2
 *
 * How would you design a stack which, in addition to push and pop, also has a function min which returns the minimum
 * element? Push, pop and min should all operate in 0(1) time.
 */
public class StackWithMin {

    private Node<Integer> stack = null;
    private Node<Integer> mins = null;

    public void push(int data) {
        if (mins == null || data <= mins.data) {
            Node<Integer> newMin = new Node<>(data);
            newMin.next = mins;
            mins = newMin;
        }
        Node<Integer> newNode = new Node<>(data);
        newNode.next = stack;
        stack = newNode;
    }

    public Integer pop() {
        if (stack == null) {
            return null;
        }
        int nextData = stack.data;
        if (nextData == mins.data) {
            mins = mins.next;
        }
        stack = stack.next;
        return nextData;
    }

    public Integer min() {
        return mins == null ? null : mins.data;
    }
}
