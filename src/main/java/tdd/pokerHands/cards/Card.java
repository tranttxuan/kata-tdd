package tdd.pokerHands.cards;

import tdd.pokerHands.exceptions.CardSuitExpectedException;
import tdd.pokerHands.exceptions.CardValueExpectedException;

import java.util.Objects;

public class Card{
  private Value value;
  private Suit suit;

  public Card(String shortNameCard){
    String nameCard = shortNameCard.trim();
    parsedValueFromShortName(nameCard);
    parsedSuitFromShortName(nameCard);
  }

  public Card( Value value, Suit suit ){
    this.value = value;
    this.suit = suit;
  }

  public Value getValue(){
    return value;
  }

  public Suit getSuit(){
    return suit;
  }
  public int compareTo( Card card2){
    return value.getIntValue() - card2.getValue().getIntValue();
  }

  @Override
  public boolean equals( Object o ){
    if(this == o) return true;
    if(o == null || getClass( ) != o.getClass( )) return false;
    Card card = (Card) o;
    return value == card.value && suit == card.suit;
  }

  @Override
  public int hashCode(){
    return Objects.hash( value, suit );
  }
  private void parsedValueFromShortName(String nameCard){
    String shortNameOfValue = nameCard.substring( 0,  nameCard.length() - 1)  ;
    Value parsedValue = Value.parse( shortNameOfValue );
    if(parsedValue == null) throw new CardValueExpectedException(nameCard + " has the wrong value");
    this.value = parsedValue;

  }

  private void parsedSuitFromShortName(String nameCard){
    Character suit = nameCard.charAt( nameCard.length() - 1);
    Suit parsedSuit = Suit.parse( suit );
    if(parsedSuit == null) throw new CardSuitExpectedException( nameCard + " has the wrong suit name");
    this.suit = parsedSuit;
  }
}
