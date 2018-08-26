package stacks;

/**
 * 3.1
 *
 * Describe how you could use a single array to implement three stacks.
 */
public class ArrayBackedStacks {

    private static final int EMPTY_STACK = -1;
    private final Integer[] stacks = new Integer[1000];
    private final int numStacks;
    private final int[] tops;

    public ArrayBackedStacks(int numStacks) {
        this.numStacks = numStacks;
        tops = new int[numStacks];
        initializeTops();
    }

    private void initializeTops() {
        int i = 0;
        while (i < numStacks) {
            tops[i] = EMPTY_STACK;
            i++;
        }
    }

    public void push(int data, int stackId) {
        if (stackId > numStacks) {
            throw new RuntimeException("Stack id " + stackId + " is greater than max number of stacks");
        }
        int top = tops[stackId];
        int newTop = top == EMPTY_STACK ? stackId : top + numStacks;
        stacks[newTop] = data;
        tops[stackId] = newTop;
    }

    public Integer pop(int stackId) {
        Integer peeked = peek(stackId);
        tops[stackId] = Math.max(tops[stackId] - numStacks, EMPTY_STACK);
        return peeked;
    }

    public Integer peek(int stackId) {
        int top = tops[stackId];
        if (top == EMPTY_STACK) {
            return null;
        } else {
            return stacks[top];
        }
    }

}
