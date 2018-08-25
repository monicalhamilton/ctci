package linkedlists;

public class LinkedListTestUtil {
    static <T> Node makeList(T... values) {
        Node head = null;
        Node prev = null;
        for (T v : values) {
            Node n = new Node<T>(v);
            if (head == null) {
                head = n;
            } else {
                prev.next = n;
            }
            prev = n;
        }
        return head;
    }
}
