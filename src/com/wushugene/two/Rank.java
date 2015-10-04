package com.wushugene.two;

/**
 * Created by emoy on 10/4/2015.
 */
public enum Rank {
    KING(13),
    QUEEN(12),
    JACK(11),
    TEN(10),
    NINE(9),
    EIGHT(8),
    SEVEN(7),
    SIX(6),
    FIVE(5),
    FOUR(4),
    THREE(3),
    TWO(2),
    ACE(1);

    private final int cardValue;

    Rank(int value){
        this.cardValue = value;
    }

    public int getCardValue() {
        return this.cardValue;
    }
}
