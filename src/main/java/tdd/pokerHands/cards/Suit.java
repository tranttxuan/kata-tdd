package tdd.pokerHands.cards;

import java.util.HashMap;
import java.util.Map;

public enum Suit{
  CLUB('C'),
  DIAMOND('D'),
  HEART('H'),
  SPADE('S');

  private Character suit;

  private static final Map<Character, Suit> suitMap = new HashMap<>(  );
  static {
    for(Suit aSuit : values()){
      suitMap.put( aSuit.getSuit(), aSuit);
    }
  }

  Suit( Character suit ){
    this.suit = suit;
  }

  public static Suit parse(Character shortSuit){
    return suitMap.get( shortSuit );
  }

  public Character getSuit(){
    return suit;
  }
}
