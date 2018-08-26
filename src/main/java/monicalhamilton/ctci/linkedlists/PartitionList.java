package monicalhamilton.ctci.linkedlists;

/**
 * 2.4
 *
 * Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater
 * than or equal to x.
 */
public class PartitionList {

    public static Node<Integer> partitionList(Node<Integer> head, int x) {

        Sublist below = new Sublist(Type.BELOW);
        Sublist equal = new Sublist(Type.EQUAL);
        Sublist above = new Sublist(Type.ABOVE);

        Node<Integer> current = head;
        while (current != null) {
            SublistResponse response = findNextSublist(current, x);
            Sublist sublist = response.sublist;
            switch (sublist.type) {
                case BELOW:
                    below.extend(sublist);
                    break;
                case EQUAL:
                    equal.extend(sublist);
                    break;
                case ABOVE:
                    above.extend(sublist);
                    break;
                default:
                    throw new RuntimeException("Unknown type " + sublist.type);
            }
            current = response.next;
        }

        return makeList(below, equal, above);
    }

    private static Node<Integer> makeList(Sublist... sublists) {
        Sublist previous = null;
        Node<Integer> head = null;
        for (Sublist s : sublists) {
            if (!s.isEmpty()) {
                if (previous != null) {
                    previous.last.next = s.first;
                }
                if (head == null) {
                    head = s.first;
                }
                previous = s;
            }
        }
        if (previous != null) {
            previous.last.next = null;
        }
        return head;
    }

    private static class SublistResponse {
        Sublist sublist;
        Node<Integer> next;

        private SublistResponse(Sublist sublist, Node<Integer> next) {
            this.sublist = sublist;
            this.next = next;
        }
    }

    private static SublistResponse findNextSublist(Node<Integer> start, int x) {
        Sublist s = new Sublist(start, Type.from(start, x));

        Node<Integer> current = start;
        while (current.next != null && Type.from(current.next, x) == s.type) {
            s.add(current.next);
            current = current.next;
        }

        return new SublistResponse(s, current.next);
    }

    enum Type {
        BELOW,
        EQUAL,
        ABOVE;

        static Type from(Node<Integer> n, int x) {
            if (n.data < x) {
                return Type.BELOW;
            } else if (n.data == x) {
                return Type.EQUAL;
            } else {
                return Type.ABOVE;
            }
        }

    }

    static final class Sublist {
        Node<Integer> first;
        Node<Integer> last;
        final Type type;

        private Sublist(Node<Integer> start, Type type) {
            this.first = start;
            this.last = start;
            this.type = type;
        }

        Sublist(Type type) {
            this.type = type;
        }

        void add(Node<Integer> n) {
            if (first == null) {
                first = n;
            }
            last = n;
        }

        private boolean isEmpty() {
            return first == null;
        }

        private void extend(Sublist toInsert) {
            if (isEmpty()) {
                first = toInsert.first;
                last = toInsert.last;
            } else {
                last.next = toInsert.first;
                last = toInsert.last;
            }
        }

        @Override
        public String toString() {
            return "Sublist{" +
                "first=" + first +
                ", last=" + last +
                ", type=" + type +
                '}';
        }
    }
}
