package monicalhamilton.ctci.stacks;

import monicalhamilton.ctci.linkedlists.Node;

/**
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore, in real life, we would
 * likely start a new stack when the previous stack exceeds some threshold. Implement a data structure SetOfStacks that
 * mimics this. SetOfStacks should be composed of several stacks and should create a new stack once the previous one
 * exceeds capacity. SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack (that is,
 * pop() should return the same values as it would if there were just a single stack).
 *
 * FOLLOW UP
 *
 * Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
 */
public class SetOfStacks {

    private Node<Node<Integer>> stacks;
    private final int maxHeight;
    private int currentHeight = 0;

    public SetOfStacks(int maxHeight) {
        if (maxHeight <= 0) {
            throw new IllegalStateException("Max height must be greater than 0");
        }
        this.maxHeight = maxHeight;
    }

    public void push(int data) {
        Node<Integer> newNode = new Node<>(data);
        if (currentHeight == 0 || currentHeight >= maxHeight) {
            Node<Node<Integer>> newStack = new Node<>(newNode);
            newStack.next = stacks;
            stacks = newStack;
            currentHeight = 0;
        } else {
            newNode.next = stacks.data;
            stacks.data = newNode;
        }
        currentHeight++;
    }

    public Integer pop() {
        if (stacks == null) {
            return null;
        }
        int dataToReturn = stacks.data.data;
        currentHeight--;
        if (currentHeight == 0) {
            stacks = stacks.next;
            currentHeight = maxHeight;
        } else {
            stacks.data = stacks.data.next;
        }
        return dataToReturn;
    }

    protected int numStacks() {
        if (stacks == null) {
            return 0;
        }
        int numStacks = 1;
        Node<Node<Integer>> current = stacks;
        while (current.next != null) {
            current = current.next;
            numStacks++;
        }
        return numStacks;
    }
}
