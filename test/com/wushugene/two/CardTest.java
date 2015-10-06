package com.wushugene.two;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by emoy on 10/4/2015.
 */
public class CardTest {

    private Card card1;
    private Card card2;
    private Card card3;

    @Before
    public void setUp() throws Exception {
        card1 = new Card(Rank.QUEEN, Suit.HEARTS);
        card2 = new Card(Rank.SEVEN, Suit.SPADES);
        card3 = new Card(Rank.QUEEN, Suit.HEARTS);

        assertFalse(card1 == null);
    }

    /*
     * Test Card's equals function (overwritten)
     * @throws Exception
     */
    @Test
    public void testEquals() throws Exception {

        Card blackJoker = new Card(1);
        Card redJoker = new Card(2);
        Card blackJokerPrime = new Card(1);


        assertTrue(card1.equals(card3));
        assertFalse(card1.equals(card2));
        assertFalse(card2.equals(null));
        assertFalse(card1.equals("Queen"));
        assertFalse(card2.equals(8));
        assertNotEquals(blackJoker, redJoker);
        assertEquals(blackJoker, blackJokerPrime);
    }

    @Test
    public void testGetRank() throws Exception {
        assertNotEquals(card1.getRank(), "King");
        assertEquals(card2.getRank(), Rank.SEVEN);
    }

    @Test
    public void testGetSuit() throws Exception {
        assertEquals(card1.getSuit(), Suit.HEARTS);
        assertNotEquals(card1.getSuit(), Suit.DIAMONDS);
    }

    @Test
    public void testGetValue() throws Exception {
        assertEquals(card2.getValue(), Integer.valueOf(7));
        assertNotEquals(card2.getValue(), card1.getValue());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals(card1.toString(), "QUEEN of HEARTS");
        assertNotEquals(card2.toString(), "7 of SPADES");
    }

}