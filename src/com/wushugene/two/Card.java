package com.wushugene.two;

/**
 * Created by emoy on 10/2/2015.
 */

public class Card {

    private Integer cardId;
    private Rank rank;
    private Suit suit;
    private Integer value;

    /**
     * Create a standard (52) playing card from supplied rank and suit
     * unique(*) cardId generated from concatenation of Rank + Suit values
     *       (*) - unique to the deck
     * @param r Rank
     * @param s Suit
     */
    public Card(Rank r, Suit s) {
        this.rank = r;
        this.suit = s;
        this.cardId = Integer.parseInt(r.getCardValue().toString() + s.getSuitId().toString());
        this.value = r.getCardValue();
    }

    /**
     * Create joker card w/ unique(*) cardId generated from jokerId
     *                            (*) - unique to the deck
     * @param jokerId
     * @throws IllegalArgumentException
     */
    public Card(int jokerId)  throws IllegalArgumentException {
        if (jokerId != 1 && jokerId !=2) {
            throw new IllegalArgumentException("Invalid jokerId - use 1 or 2");
        } else {
            this.rank = Rank.JOKER;
            this.suit = Suit.values()[jokerId+3];   // offset for Suit enum values array positions 4 & 5
            this.cardId = jokerId;
            this.value = this.rank.getCardValue();
        }
    }

    public int getCardId() {
        return this.cardId;
    }

    public Rank getRank() {
        return this.rank;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * Returns a string output of the card's name (e.g. SIX of Diamonds)
     * @return
     */
    @Override
    public String toString() {
        String name = "";
        if (this.rank.equals(Rank.JOKER)) {
            name += this.suit.toString();
        } else {
            name += this.rank.toString() + " of " + this.suit.toString();
        }
        return name;
    }

    /**
     * Compares two Cards for equality
     * @param card
     * @return true or false depending on comparison result
     */
    @Override
    public boolean equals(Object card) {
        if (card == this) {
            return true;
        }
        if (card == null || card.getClass() != this.getClass()) {
            return false;
        }
        Card myCard = (Card) card;

        if (!this.cardId.equals(myCard.getCardId())) {
            return false;
        }
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

    /**
     * Used for equals() function
     * @return new hashcode
     */
    @Override
    public int hashCode() {
        final int prime = 29;
        int result = 1;

        result = prime * result
                + ((rank == null) ? 0 : rank.hashCode());
        result = prime * result + this.cardId;
        result = prime * result
                + ((suit == null) ? 0 : suit.hashCode());

        return result;
    }
}


