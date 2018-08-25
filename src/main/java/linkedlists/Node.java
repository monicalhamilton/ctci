package linkedlists;

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
}
