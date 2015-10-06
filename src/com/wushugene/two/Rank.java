package com.wushugene.two;

/**
 * Created by emoy on 10/4/2015.
 */
public enum Rank {
    JOKER(15),
    ACE(14),
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
    TWO(2);

    private final Integer cardValue;

    Rank(Integer value){
        this.cardValue = value;
    }

    public Integer getCardValue() {
        return this.cardValue;
    }
}
