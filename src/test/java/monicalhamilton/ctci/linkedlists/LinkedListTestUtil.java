package monicalhamilton.ctci.linkedlists;

import monicalhamilton.ctci.linkedlists.Node;

public class LinkedListTestUtil {
    static <T> Node<T> makeList(T... values) {
        Node<T> head = null;
        Node<T> prev = null;
        for (T v : values) {
            Node<T> n = new Node<>(v);
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
