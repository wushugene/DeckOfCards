package com.wushugene.two;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

/**
 * Created by emoy on 10/4/2015.
 */
public class DeckTest {

    private Deck myDeck;

    @Before
    public void setUp() throws Exception {
        myDeck = new Deck();
    }

    /*
     * Test Deck's shuffle function - verify that deck has 52 unique cards post-operation
     * @throws Exception
     */
    @Test
    public void testShuffleDeck() throws Exception {
        myDeck.shuffleDeck();
        assertTrue(myDeck.getCards().size() == 52);

        HashSet<Card> deckSet = new HashSet<>();

        for (Card c : myDeck.getCards()) {
            deckSet.add(c);
        }
        assertTrue(deckSet.size() == 52);
    }

    /*
     * Test Deck's sort function
     * @throws Exception
     */
    @Test
    public void testSortDeck() throws Exception {
        myDeck.sortDeck(SortType.SUIT, SortDirection.ASCENDING);

        Card aceOfSpades = new Card(Rank.ACE, Suit.SPADES);

        assertEquals(aceOfSpades, myDeck.getCards().get(0));
        assertNotEquals(aceOfSpades, myDeck.getCards().get(5));

        Deck sortedDeck = new Deck();
        myDeck.shuffleDeck();
        myDeck.sortDeck(SortType.VALUE, SortDirection.DESCENDING);

        System.out.println("Sorted deck");
        for (int i=0; i<5; i++) {
            System.out.println(sortedDeck.getCards().get(i).toString());
        }

        System.out.println("\n");
        System.out.println("myDeck - post sort");
        for (int i=0; i<5; i++) {
            System.out.println(myDeck.getCards().get(i).toString());
        }

        assertArrayEquals(sortedDeck.getCards().toArray(), myDeck.getCards().toArray());

    }
}