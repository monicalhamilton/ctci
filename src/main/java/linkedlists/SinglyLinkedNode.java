package linkedlists;

class SinglyLinkedNode<T> {
    T data;
    SinglyLinkedNode<T> next;

    SinglyLinkedNode(T data) {
        this.data = data;
    }

    SinglyLinkedNode<T> add(T data) {
        SinglyLinkedNode n = this;
        while (n.next != null) {
            n = n.next;
        }
        SinglyLinkedNode<T> newNode = new SinglyLinkedNode<>(data);
        n.next = newNode;
        return newNode;
    }
}
