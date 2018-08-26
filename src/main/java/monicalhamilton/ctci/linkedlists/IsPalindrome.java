package monicalhamilton.ctci.linkedlists;

/**
 * 2.7
 *
 * Implement a function to check if a linked list is a palindrome.
 */
public class IsPalindrome<T> {

    private final Node<T> head;
    private Node<T> secondHalfPointer = null;

    public IsPalindrome(Node<T> head) {
        this.head = head;
    }

    public boolean check() {
        if (head == null) {
            // Empty list not a palindrome
            return false;
        }
        if (head.next == null) {
            // Singleton list is a palindrome
            return true;
        }
        return isPalindrome(head, head.next);
    }

    private boolean isPalindrome(Node<T> slow, Node<T> fast) {
        if (fast == null) {
            secondHalfPointer = slow;
            return true;
        } else if (fast.next == null) {
            secondHalfPointer = slow.next;
            return secondHalfPointer.data.equals(slow.data);
        }
        boolean wasPalindrome = isPalindrome(slow.next, fast.next.next);
        secondHalfPointer = secondHalfPointer.next;
        return secondHalfPointer.data.equals(slow.data) && wasPalindrome;
    }
}
