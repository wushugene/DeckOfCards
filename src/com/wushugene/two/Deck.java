package com.wushugene.two;

/**
 * Created by emoy on 10/2/2015.
 */
import java.util.*;

public class Deck {

    private List<Card> cards = new ArrayList<Card>();
    private int numJokers = 0;

    /**
     * Create new 52-Card Deck
     */
    public Deck() {

        for (Rank r : Rank.values()) {
            if (!r.equals(Rank.JOKER)) {
                for (int s=3; s>=0; s--) {
                    Card card = new Card(r, Suit.values()[s]);
                    this.cards.add(card);
                }
            }
        }
    }

    /**
     * Creates new 52-Card Deck along with jokers
     * @param numJokers should be between 1 or 2
     * @throws IllegalArgumentException
     */
    public Deck(int numJokers) throws IllegalArgumentException {

        if (numJokers > 0 && numJokers <=2) {
            for (int i=numJokers; i >= 1; i--) {
                Card joker = new Card(i);
                this.cards.add(joker);
            }
            this.numJokers = numJokers;
        } else {
            throw new IllegalArgumentException("Invalid number of jokers specified - please specify 1 or 2");
        }

        // Create rest of the deck
        for (Rank r : Rank.values()) {
            if (!r.equals(Rank.JOKER)) {
                for (int s=3; s>=0; s--) {
                    Card card = new Card(r, Suit.values()[s]);
                    this.cards.add(card);
                }
            }
        }
    }

    /**
     * Shuffle deck order
     */
    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

    /**
     * Sort Deck by rank/suit in ascending/descending order
     * @param sortType
     * @param sortDirection
     */
    public void sortDeck(SortType sortType, SortDirection sortDirection) {
        if (sortType == SortType.RANK) {
            if (sortDirection == SortDirection.ASCENDING){
                Collections.sort(cards, AscendingRankComparator);
            } else {
                Collections.sort(cards, DescendingRankComparator);
            }
        } else {
            if (sortDirection == SortDirection.ASCENDING) {
                Collections.sort(cards, AscendingSuitComparator);
            } else {
                Collections.sort(cards, DescendingSuitComparator);
            }
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getDeckSize() {
        return cards.size();
    }

    public int getNumJokers() { return numJokers; }

    public String toString() {
        String s = "";
        for (Card c : cards) {
            s+= c.toString() + ", ";
        }
        return s;
    }

    public static Comparator<Card> AscendingRankComparator = new Comparator<Card>() {

        public int compare(Card c1, Card c2) {
            int result = c2.getRank().compareTo(c1.getRank());
            if (result == 0) {
                result = c1.getSuit().compareTo(c2.getSuit());
            }
            return result;
        }
    };

    public static Comparator<Card> DescendingRankComparator = new Comparator<Card>() {

        public int compare(Card c1, Card c2) {
            int result = c1.getRank().compareTo(c2.getRank());
            if (result == 0) {
                result = c2.getSuit().compareTo(c1.getSuit());
            }
            return result;
        }
    };

    public static Comparator<Card> AscendingSuitComparator = new Comparator<Card>() {

        public int compare(Card c1, Card c2) {
            int result = c1.getSuit().compareTo(c2.getSuit());
            if (result == 0) {
                result = c2.getRank().compareTo(c1.getRank());
            }
            return result;
        }
    };

    public static Comparator<Card> DescendingSuitComparator = new Comparator<Card>() {

        public int compare(Card c1, Card c2) {
            int result = c2.getSuit().compareTo(c1.getSuit());
            if (result == 0) {
                result = c1.getRank().compareTo(c2.getRank());
            }
            return result;
        }
    };

}