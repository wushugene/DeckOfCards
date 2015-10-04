package com.wushugene.two;

/**
 * Created by emoy on 10/2/2015.
 */
import java.util.*;

public class Deck {

    private List<Card> cards = new ArrayList<>();
    private int deckSize;

    /*
     * Deck constructor - default sorted by value ascending upon deck creation
     */
    public Deck() {

        for (Rank r : Rank.values()) {
            for (Suit s : Suit.values()) {
                Card card = new Card(r, s);
                this.cards.add(card);
            }
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

    public void sortDeck(SortType sortType, SortDirection sortDirection) {
        if (sortType == SortType.VALUE) {
            if (sortDirection == SortDirection.ASCENDING){
                Collections.sort(cards, AscendingValueComparator);
            } else {
                Collections.sort(cards, DescendingValueComparator);
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
        return deckSize;
    }

    public String toString() {
        String s = "";
        for (Card c : cards) {
            s+= c.toString() + ", ";
        }
        return s;
    }

    public static Comparator<Card> AscendingValueComparator = new Comparator<Card>() {

        public int compare(Card c1, Card c2) {
            int result = c1.getValue().compareTo(c2.getValue());
            if (result == 0) {
                result = c2.getSuit().compareTo(c1.getSuit());
            }
            return result;
        }
    };

    public static Comparator<Card> DescendingValueComparator = new Comparator<Card>() {

        public int compare(Card c1, Card c2) {
            int result = c2.getValue().compareTo(c1.getValue());
            if (result == 0) {
                result = c1.getSuit().compareTo(c2.getSuit());
            }
            return result;
        }
    };

    public static Comparator<Card> AscendingSuitComparator = new Comparator<Card>() {

        public int compare(Card c1, Card c2) {
            int result = c1.getSuit().compareTo(c2.getSuit());
            if (result == 0) {
                result = c1.getValue().compareTo(c2.getValue());
            }
            return result;
        }
    };

    public static Comparator<Card> DescendingSuitComparator = new Comparator<Card>() {

        public int compare(Card c1, Card c2) {
            int result = c2.getSuit().compareTo(c1.getSuit());
            if (result == 0) {
                result = c2.getValue().compareTo(c1.getValue());
            }
            return result;
        }
    };

}