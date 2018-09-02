package monicalhamilton.ctci.stacks;

import monicalhamilton.ctci.linkedlists.Node;

public class Stack<T> {
    private Node<T> top;

    public int size() {
        int size = 0;
        Node current = top;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
    }

    public T pop() {
        if (top == null) {
            return null;
        }
        Node<T> toReturn = top;
        top = toReturn.next;
        return toReturn.data;
    }

    public T peek() {
        return top == null ? null : top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
