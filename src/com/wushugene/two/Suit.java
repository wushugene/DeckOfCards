package com.wushugene.two;

/**
 * Created by emoy on 10/4/2015.
 */
public enum Suit {
    DIAMONDS(1),
    CLUBS(2),
    HEARTS(3),
    SPADES(4),
    BLACK_JOKER(5),
    RED_JOKER(6);

    private final Integer suitId;

    Suit(Integer suitId) {
        this.suitId = suitId;
    }

    public Integer getSuitId() {
        return this.suitId;
    }
}
