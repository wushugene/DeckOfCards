package com.wushugene.two;

/**
 * Created by emoy on 10/2/2015.
 */

public class Card {

    private Rank rank;
    private Suit suit;
    private Integer value;

    public Card(Rank r, Suit s) {
        this.rank = r;
        this.suit = s;
        this.value = r.getCardValue();
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.rank + " of " + this.suit;
    }

    @Override
    public boolean equals(Object card) {
        if (card == this) {
            return true;
        }
        if (card == null || card.getClass() != this.getClass()) {
            return false;
        }
        Card myCard = (Card) card;

        if (this.rank != myCard.getRank()) {
            return false;
        }
        if (!this.rank.equals(myCard.getRank())) {
            return false;
        }
        if (!this.suit.equals(myCard.getSuit())) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 29;
        int result = 1;

        result = prime * result
                + ((rank == null) ? 0 : rank.hashCode());
        result = prime * result + value;
        result = prime * result
                + ((suit == null) ? 0 : suit.hashCode());

        return result;
    }
}


