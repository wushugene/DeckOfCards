package com.wushugene.two;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

/**
 * Created by emoy on 10/4/2015.
 */
public class DeckTest {

    private Deck normalDeck;
    private Deck deckWithTwoJokers;

    private Deck defaultDeckWithTwoJokers;
    private Deck shuffledDeckWithTwoJokers;

    @Before
    public void setUp() throws Exception {
        // Create normal deck
        normalDeck = new Deck();

        // Create deck with two jokers
        deckWithTwoJokers = new Deck(2);

        defaultDeckWithTwoJokers = new Deck(2);
        shuffledDeckWithTwoJokers = new Deck(2);
    }

    /*
     * Test Deck's shuffle function - verify that deck has 52 unique cards post-operation
     * @throws Exception
     */
    @Test
    public void testShuffleDeck() throws Exception {

        normalDeck.shuffleDeck();
        deckWithTwoJokers.shuffleDeck();

        assertEquals(normalDeck.getDeckSize(), 52);
        assertEquals(deckWithTwoJokers.getCards().size(), 54);
        assertEquals(deckWithTwoJokers.getNumJokers(), 2);
        assertNotEquals(normalDeck.getDeckSize(), "apple");
        assertNotEquals(deckWithTwoJokers.getNumJokers(), 0);

        HashSet<Card> deckSet = new HashSet<Card>();

        // Filter out duplicate cards
        for (Card c : deckWithTwoJokers.getCards()) {
            deckSet.add(c);
        }

        // Verify deck size is still 52 + 2 jokers
        assertTrue(deckSet.size() == 54);
    }

    /*
     * Test Deck's sort function with
     * @throws Exception
     */
    @Test
    public void testSortDeck() throws Exception {

        // Create two decks, each with 52 cards + 2 jokers

        System.out.println("\nDefault deck: pre-sort");
        for (int i=0; i<10; i++) {
            System.out.println(defaultDeckWithTwoJokers.getCards().get(i).toString());
        }

        // Shuffle one deck
        shuffledDeckWithTwoJokers.shuffleDeck();

        System.out.println("\nShuffled deck: pre-sort");
        for (int i=0; i<10; i++) {
            System.out.println(shuffledDeckWithTwoJokers.getCards().get(i).toString());
        }

        // Sort shuffled deck to default sort-order
        shuffledDeckWithTwoJokers.sortDeck(SortType.RANK, SortDirection.DESCENDING);

        System.out.println("\nShuffled deck: post-sort");
        for (int i=0; i<10; i++) {
            System.out.println(shuffledDeckWithTwoJokers.getCards().get(i).toString());
        }

        // Verify shuffled/sorted deck is identical in content and order as the untouched default deck
        assertArrayEquals(defaultDeckWithTwoJokers.getCards().toArray(), shuffledDeckWithTwoJokers.getCards().toArray());

        Card threeOfDiamonds = new Card(Rank.THREE, Suit.DIAMONDS);
        Card aceOfSpades = new Card(Rank.ACE, Suit.SPADES);
        Card blackJoker = new Card(1);

        // Verify correct order of cards
        assertEquals(threeOfDiamonds, shuffledDeckWithTwoJokers.getCards().get(49));
        assertEquals(aceOfSpades, shuffledDeckWithTwoJokers.getCards().get(2));

        assertNotEquals(blackJoker, shuffledDeckWithTwoJokers.getCards().get(0));
        assertNotEquals(threeOfDiamonds, shuffledDeckWithTwoJokers.getCards().get(25));

        // Verify correct joker position
        assertEquals(blackJoker, shuffledDeckWithTwoJokers.getCards().get(1));

    }
}