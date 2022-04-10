package tdd.pokerHands.cards;

import org.junit.jupiter.api.Test;
import tdd.pokerHands.exceptions.CardSuitExpectedException;
import tdd.pokerHands.exceptions.CardValueExpectedException;

import static org.junit.jupiter.api.Assertions.*;

class CardTest{
  @Test
  void createCard_WhenInjectingShortNameOfACard_2C(){
    Card newCard = new Card( "2C" );
    System.out.println( newCard.getValue( ) );
    assertEquals( newCard.getValue( ), Value.TWO );
    assertEquals( newCard.getSuit( ), Suit.CLUB );
  }

  @Test
  void createCard_WhenInjectingShortNameOfACard_JC(){
    Card newCard = new Card( "JC" );
    assertEquals( newCard.getValue( ), Value.JACK );
    assertEquals( newCard.getSuit( ), Suit.CLUB );
  }

  @Test
  void createCard_WhenInjectingShortNameOfACard_10H(){
    Card newCard = new Card( "10C" );
    assertEquals( newCard.getValue( ), Value.TEN );
    assertEquals( newCard.getSuit( ), Suit.CLUB );
  }

  @Test
  void createCard_WhenInjectingValueAndSuitObjects(){
    Card newCard = new Card( Value.TWO, Suit.CLUB );
    assertEquals( newCard.getValue( ), Value.TWO );
    assertEquals( newCard.getSuit( ), Suit.CLUB );
  }

  @Test
  void createCard_shouldThrowException_WhenInjectingWrongShortNameOfACard(){
    assertThrows( CardSuitExpectedException.class, () -> new Card( "2L" ), "2L has a wrong suit name" );
  }

  @Test
  void createCard_shouldThrowException_WhenInjectingWrongValueOfACard(){
    assertThrows( CardValueExpectedException.class, () -> new Card( "1C" ), "12C has a wrong suit name" );
  }

  @Test
  void compareToOtherCard_shouldReturnAnIntegerGreaterThan0_WhenGivenValueCardGreaterThanValueCardOfOther(){
    Card card = new Card( Value.ACE, Suit.CLUB );
    Card otherCard = new Card( Value.FIVE, Suit.CLUB );
    int compared = card.compareTo( otherCard);
 assertTrue( compared > 0 );
  }

  @Test
  void compareToOtherCard_shouldReturnAnIntegerLessThan0_WhenGivenValueCardGreaterThanValueCardOfOther(){
    Card card = new Card( Value.TWO, Suit.CLUB );
    Card otherCard = new Card( Value.FIVE, Suit.CLUB );
    int compared = card.compareTo( otherCard);
    assertTrue( compared < 0 );
  }
  @Test
  void compareToOtherCard_shouldReturnAnIntegerEqualThan0_WhenGivenValueCardGreaterThanValueCardOfOther(){
    Card card = new Card( Value.TWO, Suit.CLUB );
    Card otherCard = new Card( Value.TWO, Suit.HEART );
    int compared = card.compareTo( otherCard);
    assertTrue( compared == 0 );
  }
}