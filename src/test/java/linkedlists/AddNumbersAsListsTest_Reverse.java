package linkedlists;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddNumbersAsListsTest_Reverse {

    @Test
    public void testSingleDigitNoCarryover() {
        Node<Integer> actual = AddNumbersAsLists.reverseOrder(new Node<>(1), new Node<>(2));
        Node<Integer> expected = new Node<>(3);
        assertEquals(expected, actual);
    }

    @Test
    public void testSingleDigitWithCarryover() {
        Node<Integer> actual = AddNumbersAsLists.reverseOrder(new Node<>(9), new Node<>(8));
        Node<Integer> expected = new Node<>(7);
        expected.add(1);
        assertEquals(expected, actual);
    }

    @Test
    public void testDoubleDigits() {
        Node<Integer> thirtyThree = new Node<>(3);
        thirtyThree.add(3);

        Node<Integer> twentyFour = new Node<>(4);
        twentyFour.add(2);

        Node<Integer> actual = AddNumbersAsLists.reverseOrder(thirtyThree, twentyFour);

        Node<Integer> expected = new Node<>(7);
        expected.add(5);

        assertEquals(expected, actual);
    }

    @Test
    public void testDifferentNumberOfDigits() {
        Node<Integer> oneHundredEleven = new Node<>(1);
        oneHundredEleven.add(1);
        oneHundredEleven.add(1);

        Node<Integer> two = new Node<>(2);

        Node<Integer> oneHundredThirteen = new Node<>(3);
        oneHundredThirteen.add(1);
        oneHundredThirteen.add(1);

        Node<Integer> bigPlusSmall = AddNumbersAsLists.reverseOrder(oneHundredEleven, two);

        assertEquals(oneHundredThirteen, bigPlusSmall);

        Node<Integer> smallPlusBig = AddNumbersAsLists.reverseOrder(two, oneHundredEleven);
        assertEquals(oneHundredThirteen, smallPlusBig);
    }

    @Test
    public void testMultipleCarryover() {
        Node<Integer> nineEightyThree = new Node<>(3);
        nineEightyThree.add(8);
        nineEightyThree.add(9);

        Node<Integer> seventyNine = new Node<>(9);
        seventyNine.add(7);

        Node<Integer> tenSixtyTwo = new Node<>(2);
        tenSixtyTwo.add(6);
        tenSixtyTwo.add(0);
        tenSixtyTwo.add(1);

        Node<Integer> bigPlusSmall = AddNumbersAsLists.reverseOrder(nineEightyThree, seventyNine);

        assertEquals(tenSixtyTwo, bigPlusSmall);

        Node<Integer> smallPlusBig = AddNumbersAsLists.reverseOrder(seventyNine, nineEightyThree);
        assertEquals(tenSixtyTwo, smallPlusBig);
    }
}