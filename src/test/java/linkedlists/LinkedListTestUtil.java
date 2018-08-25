package linkedlists;

public class LinkedListTestUtil {
    static <T> SinglyLinkedNode makeList(T... values) {
        SinglyLinkedNode head = null;
        SinglyLinkedNode prev = null;
        for (T v : values) {
            SinglyLinkedNode n = new SinglyLinkedNode<T>(v);
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
