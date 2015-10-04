DeckOfCards - A library to simulate a deck of cards
=====

## Example

```java

import com.wushugene.two.*;

public static void main(String[] args) {
   System.out.println("[Creating new Deck]");
   Deck d = new Deck();

   List<Card> myDeck = d.getCards();

   System.out.println("\nDisplaying first five cards in deck (default)");
   for (Card c : myDeck.subList(0, 5)) {
       System.out.println(c.toString());
   }

   System.out.println("\n[Shuffling Deck]");
   d.shuffleDeck();

   System.out.println("\nDisplaying first five cards in deck (shuffled)");
   for (Card c : myDeck.subList(0, 5)) {
       System.out.println(c.toString());
   }

   System.out.println("\n[Sorting Deck by suit, ascending value]");
   d.sortDeck(SortType.SUIT, SortDirection.ASCENDING);

   System.out.println("\nDisplaying first five cards in deck (sorted by suit, ascending value)");
   for (Card c : myDeck.subList(0, 5)) {
       System.out.println(c.toString());
   }
}

```

## Sample Output
[Creating new Deck]

Displaying first five cards in deck (default)
KING of DIAMONDS
KING of CLUBS
KING of HEARTS
KING of SPADES
QUEEN of DIAMONDS

[Shuffling Deck]

Displaying first five cards in deck (shuffled)
JACK of CLUBS
FIVE of HEARTS
NINE of CLUBS
KING of SPADES
KING of DIAMONDS

[Sorting Deck by suit, ascending value]

Displaying first five cards in deck (sorted by suit, ascending value)
ACE of DIAMONDS
TWO of DIAMONDS
THREE of DIAMONDS
FOUR of DIAMONDS
FIVE of DIAMONDS