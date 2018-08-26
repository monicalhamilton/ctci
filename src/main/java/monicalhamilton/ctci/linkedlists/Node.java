package monicalhamilton.ctci.linkedlists;

import java.util.Objects;

class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
    }

    Node<T> add(T data) {
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        Node<T> newNode = new Node<>(data);
        n.next = newNode;
        return newNode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(data, node.data) &&
            Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, next);
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("[");
        b.append(this.data);
        Node<T> current = this.next;
        while (current != null) {
            b.append(", ");
            b.append(current.data);
            current = current.next;
        }
        b.append("]");
        return b.toString();
    }
}
