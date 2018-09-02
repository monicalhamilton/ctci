package monicalhamilton.ctci.stacks;

/**
 * 3.4
 *
 * In the classic problem of the Stacks of Hanoi, you have 3 Stacks and N disks of different sizes which can slide on to
 * any Stack. The puzzle starts with disks sorted in ascending order of size from top to bottom (i.e., each disk sits on
 * top of an even larger one). You have the following constraints:
 *
 * <pre>
 * (1) Only one disk can be moved at a time.
 * (2) A disk is slid off the top of one Stack onto the next Stack.
 * (3) A disk can only be placed on top of a larger disk.
 * </pre>
 *
 * Write a program to move the disks from the first Stack to the last using stacks.
 */
public class TowersOfHanoi {

    public static void towersOfHanoi(Stack<Integer> left, Stack<Integer> middle, Stack<Integer> right) {
        if (left.isEmpty()) {
            return;
        }
        move(left.size() - 1, left, middle, right);
    }

    private static void move(int index, Stack<Integer> origin, Stack<Integer> spare, Stack<Integer> destination) {
        if (index == 0) {
            Integer disk = origin.pop();
            Integer topOfDestination = destination.peek();
            if (topOfDestination != null && topOfDestination < disk) {
                throw new IllegalStateException(String.format("Disk %s cannot be stacked onto disk %s", disk, topOfDestination));
            }
            destination.push(disk);
        } else {
            int prevIndex = index - 1;
            move(prevIndex, origin, destination, spare);
            move(0, origin, spare, destination);
            move(prevIndex, spare, origin, destination);
        }
    }
}
