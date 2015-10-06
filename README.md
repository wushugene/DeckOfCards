DeckOfCards - A library to simulate a deck of cards
=====

## Example

```java

import com.wushugene.two.*;

public static void main(String[] args) {
   SortType sortType = SortType.RANK;
   SortDirection sortDirection = SortDirection.DESCENDING;
   int numCardsRetrieved = 10;
   
   System.out.println("[Creating new Deck with two jokers]");
   Deck deck = new Deck(2);
   
   System.out.println("\n[Displaying all cards in deck (default)]");
   for (Card card : deck.getCards()) {
       System.out.println(card.toString());
   }
   
   System.out.println("\n[Shuffling Deck]");
   deck.shuffleDeck();
   
   System.out.println("\n[Displaying first " + numCardsRetrieved + " cards in deck (shuffled)]");
   for (Card card : deck.getCards().subList(0, numCardsRetrieved)) {
        System.out.println(card.toString());
   }
   
   System.out.println("\n[Sorting Deck by " + sortDirection + " " + sortType.toString() + "]");
   deck.sortDeck(sortType, sortDirection);
   
   System.out.println("\n[Displaying first " + numCardsRetrieved + " cards in deck sorted by " + sortDirection + " " + sortType.toString() + "]");
   for (Card card : deck.getCards().subList(0, numCardsRetrieved)) {
       System.out.println(card.toString());
   }
}

```

## Sample Output
```
[Creating new Deck with two jokers]  
                                       
[Displaying all cards in deck (default)]  
JOKER 1                                     
JOKER 2                                       
ACE of SPADES                                   
ACE of HEARTS                                      
ACE of CLUBS                                         
ACE of DIAMONDS                                         
KING of SPADES                                            
KING of HEARTS                                             
KING of CLUBS                                               
KING of DIAMONDS                                              
QUEEN of SPADES                                                 
QUEEN of HEARTS                                                   
QUEEN of CLUBS                                                      
QUEEN of DIAMONDS                                                     
JACK of SPADES                                                           
JACK of HEARTS                                                              
JACK of CLUBS                                                                  
JACK of DIAMONDS                                                                  
TEN of SPADES                                                                       
TEN of HEARTS                                                                         
TEN of CLUBS                                                                           
TEN of DIAMONDS                                                                         
NINE of SPADES                                                                            
NINE of HEARTS                                                                              
NINE of CLUBS
NINE of DIAMONDS
EIGHT of SPADES
EIGHT of HEARTS                                                                              
EIGHT of CLUBS                                                                                 
EIGHT of DIAMONDS                                                                               
SEVEN of SPADES                                                                                  
SEVEN of HEARTS                                                                                   
SEVEN of CLUBS                                                                                     
SEVEN of DIAMONDS                                                                                   
SIX of SPADES                                                                                        
SIX of HEARTS                                                                                         
SIX of CLUBS                                                                                             
SIX of DIAMONDS                                                                                             
FIVE of SPADES                                                                                                 
FIVE of HEARTS                                                                                                     
FIVE of CLUBS
FIVE of DIAMONDS
FOUR of SPADES
FOUR of HEARTS
FOUR of CLUBS
FOUR of DIAMONDS
THREE of SPADES
THREE of HEARTS
THREE of CLUBS
THREE of DIAMONDS
TWO of SPADES
TWO of HEARTS
TWO of CLUBS
TWO of DIAMONDS

[Shuffling Deck]

[Displaying first 10 cards in deck (shuffled)]
ACE of DIAMONDS
FIVE of HEARTS
THREE of SPADES
FOUR of CLUBS
JACK of SPADES
ACE of HEARTS
THREE of HEARTS
FIVE of DIAMONDS
FOUR of DIAMONDS
FOUR of SPADES

[Sorting Deck by DESCENDING RANK]

[Displaying first 10 cards in deck sorted by DESCENDING RANK]
JOKER 1
JOKER 2
ACE of SPADES
ACE of HEARTS
ACE of CLUBS
ACE of DIAMONDS
KING of SPADES
KING of HEARTS
KING of CLUBS
KING of DIAMONDS
```

## Usage  

* Initialize a new ```Deck``` to create a standard 52-card Deck. ```Deck(int numJokers)``` will create a deck with jokers (specify 1 or 2).
* The ```shuffle``` method randomizes the Deck's card order.
* The  ```sortDeck(SortType, SortDirection)``` method sorts the Deck by rank/suit in ascending/descending order.
* Decks are sorted by rank in descending order by default.


## Assumptions
* Red joker trumps black joker
* Suit (most powerful -> least powerful):  Spades, Hearts, Clubs, Diamonds
