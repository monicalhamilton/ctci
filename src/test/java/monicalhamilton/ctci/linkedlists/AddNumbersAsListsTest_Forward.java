package monicalhamilton.ctci.linkedlists;

import org.junit.Test;

import monicalhamilton.ctci.linkedlists.AddNumbersAsLists;
import monicalhamilton.ctci.linkedlists.Node;

import static org.junit.Assert.assertEquals;

public class AddNumbersAsListsTest_Forward {

    @Test
    public void testSingleDigitNoCarryover() {
        Node<Integer> actual = AddNumbersAsLists.forwardOrder(new Node<>(1), new Node<>(2));
        Node<Integer> expected = new Node<>(3);
        assertEquals(expected, actual);
    }

    @Test
    public void testSingleDigitWithCarryover() {
        Node<Integer> actual = AddNumbersAsLists.forwardOrder(new Node<>(9), new Node<>(8));
        Node<Integer> expected = new Node<>(1);
        expected.add(7);
        assertEquals(expected, actual);
    }

    @Test
    public void testDoubleDigits() {
        Node<Integer> thirtyThree = new Node<>(3);
        thirtyThree.add(3);

        Node<Integer> twentyFour = new Node<>(2);
        twentyFour.add(4);

        Node<Integer> actual = AddNumbersAsLists.reverseOrder(thirtyThree, twentyFour);

        Node<Integer> expected = new Node<>(5);
        expected.add(7);

        assertEquals(expected, actual);
    }

    @Test
    public void testDifferentNumberOfDigits() {
        Node<Integer> oneHundredEleven = new Node<>(1);
        oneHundredEleven.add(1);
        oneHundredEleven.add(1);

        Node<Integer> two = new Node<>(2);

        Node<Integer> oneHundredThirteen = new Node<>(1);
        oneHundredThirteen.add(1);
        oneHundredThirteen.add(3);

        Node<Integer> bigPlusSmall = AddNumbersAsLists.forwardOrder(oneHundredEleven, two);

        assertEquals(oneHundredThirteen, bigPlusSmall);

        Node<Integer> smallPlusBig = AddNumbersAsLists.forwardOrder(two, oneHundredEleven);
        assertEquals(oneHundredThirteen, smallPlusBig);
    }

    @Test
    public void testMultipleCarryover() {
        Node<Integer> nineEightyThree = new Node<>(9);
        nineEightyThree.add(8);
        nineEightyThree.add(3);

        Node<Integer> seventyNine = new Node<>(7);
        seventyNine.add(9);

        Node<Integer> tenSixtyTwo = new Node<>(1);
        tenSixtyTwo.add(0);
        tenSixtyTwo.add(6);
        tenSixtyTwo.add(2);

        Node<Integer> bigPlusSmall = AddNumbersAsLists.forwardOrder(nineEightyThree, seventyNine);

        assertEquals(tenSixtyTwo, bigPlusSmall);

        Node<Integer> smallPlusBig = AddNumbersAsLists.forwardOrder(seventyNine, nineEightyThree);
        assertEquals(tenSixtyTwo, smallPlusBig);
    }
}