package monicalhamilton.ctci.linkedlists;

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
            int remainder = sum % BASE;
            int carryover = sum / BASE;
            if (answerHead == null) {
                answerHead = new Node<>(remainder);
                answerCurrentDigit = answerHead;
            } else {
                answerCurrentDigit.next = new Node<>(remainder);
                answerCurrentDigit = answerCurrentDigit.next;
            }
            prevCarryover = carryover;
            digit1 = digit1 == null ? null : digit1.next;
            digit2 = digit2 == null ? null : digit2.next;
        }
        if (prevCarryover != 0) {
            answerCurrentDigit.next = new Node<>(prevCarryover);
        }
        return answerHead;
    }

    public static Node<Integer> forwardOrder(Node<Integer> number1, Node<Integer> number2) {

        int size1 = getSize(number1);
        int size2 = getSize(number2);
        if (size1 < size2) {
            int zerosToAdd = size2 - size1;
            number1 = padWithZeros(number1, zerosToAdd);
        } else if (size2 < size1) {
            int zerosToAdd = size1 - size2;
            number2 = padWithZeros(number2, zerosToAdd);
        }

        PartialResult result = add(number1, number2);
        if (result.carryover > 0) {
            Node<Integer> lastNode = new Node<>(result.carryover);
            lastNode.next = result.node;
            return lastNode;
        }
        return result.node;
    }

    private static int getSize(Node<Integer> list) {
        if (list == null) {
            return 0;
        }
        int size = 1;
        Node<Integer> current = list;
        while (current.next != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    private static Node<Integer> padWithZeros(Node<Integer> number, int numZeros) {
        if (numZeros < 1) {
            throw new RuntimeException("Must pass 1 or more zeros");
        }

        Node<Integer> headZero = new Node<>(0);
        Node<Integer> previousZero = headZero;
        int zerosAdded = 1;
        while (zerosAdded < numZeros) {
            Node<Integer> nextZero = new Node<>(0);
            previousZero.next = nextZero;
            previousZero = nextZero;
            zerosAdded++;
        }
        previousZero.next = number;
        return headZero;
    }

    private static PartialResult add(Node<Integer> n1, Node<Integer> n2) {
        if (n1 == null && n2 == null) {
            return new PartialResult(null, 0);
        }
        PartialResult r = add(n1 == null ? null : n1.next, n2 == null ? null : n2.next); // 2, null
        Node<Integer> previousNode = r.node;
        int previousCarryover = r.carryover;
        int sum = n1.data + n2.data + previousCarryover;
        int remainder = sum % BASE;
        int newCarryover = sum / BASE;
        Node<Integer> newNode = new Node<>(remainder);
        newNode.next = previousNode;
        return new PartialResult(newNode, newCarryover);

    }

    private static class PartialResult {
        Node<Integer> node;
        int carryover;

        private PartialResult(Node<Integer> node, int carryover) {
            this.node = node;
            this.carryover = carryover;
        }
    }
}
