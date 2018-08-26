package linkedlists;

/**
 * 2.5
 *
 * You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in
 * reverse order, such that the 1s digit is at the head of the list. Write a function that adds the two numbers and
 * returns the sum as a linked list.
 *
 * EXAMPLE Input:(7-> 1 -> 6) + (5 -> 9 -> 2).That is, 617 + 295. Output: 2 -> 1 -> 9. That is, 912.
 *
 * FOLLOW UP Suppose the digits are stored in forward order. Repeat the above problem. EXAMPLE Input:(6 -> 1 -> 7) + (2
 * -> 9 -> 5).That is,617 + 295. Output: 9 -> 1 -> 2. That is, 912.
 */
public class AddNumbersAsLists {

    private static final int BASE = 10;

    public static Node<Integer> reverseOrder(Node<Integer> number1, Node<Integer> number2) {
        int prevCarryover = 0;
        Node<Integer> answerHead = null;
        Node<Integer> answerCurrentDigit = null;
        Node<Integer> digit1 = number1;
        Node<Integer> digit2 = number2;

        while (digit1 != null || digit2 != null) {
            int sum = (digit1 == null ? 0 : digit1.data) + (digit2 == null ? 0 : digit2.data) + prevCarryover;
            Division d = new Division(sum, BASE);
            if (answerHead == null) {
                answerHead = new Node<>(d.remainder);
                answerCurrentDigit = answerHead;
            } else {
                answerCurrentDigit.next = new Node<>(d.remainder);
                answerCurrentDigit = answerCurrentDigit.next;
            }
            prevCarryover = d.quotient;
            digit1 = digit1 == null ? null : digit1.next;
            digit2 = digit2 == null ? null : digit2.next;
        }
        if (prevCarryover != 0) {
            answerCurrentDigit.next = new Node<>(prevCarryover);
        }
        return answerHead;
    }

    private static class Division {
        private final int dividend;
        private final int divisor;
        private final int quotient;
        private final int remainder;

        private Division(int dividend, int divisor) {
            this.divisor = divisor;
            this.dividend = dividend;
            this.quotient = dividend / divisor;
            this.remainder = dividend % divisor;
        }
    }
}
