package tdd.pokerHands.gameServices;

import tdd.pokerHands.cards.Card;
import tdd.pokerHands.cards.Suit;
import tdd.pokerHands.cards.Value;

import java.util.*;

public class Standard52CardDeck{

 public Set<Card> cards = new HashSet<>( );

  public Standard52CardDeck(){
    for(Value value : Value.values( )){
      for(int i = 0; i < 4; i++){
        cards.add( new Card( value, Suit.values( )[i] ) );
      }
    }
  }
}
