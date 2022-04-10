package tdd.pokerHands.cards;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class CardsTest{

  @Test
  void createCardsSet_WhenInjectingListOfCardShortName(){
    Cards fiveCards = new Cards( "8D 5D 7D JD 10H" );
      assertEquals( fiveCards.size(), 5 );
  }

  @Test
  void createCardsSet_WhenInjectingListOfCards(){
    List<Card> cards = new ArrayList<>( );
    cards.add( new Card( Value.EIGHT, Suit.DIAMOND ) );
    cards.add( new Card( Value.FIVE, Suit.DIAMOND ) );
    cards.add( new Card( Value.SEVEN, Suit.DIAMOND ) );
    cards.add( new Card( Value.JACK, Suit.DIAMOND ) );
    cards.add( new Card( Value.NINE, Suit.DIAMOND ) );
    Cards fiveCards = new Cards( cards );
    assertEquals( fiveCards.size(), 5 );
  }

  @Test
  void hasAllCardsOfTheSameSuit_ShouldReturnTrue(){
    Cards fiveCards = new Cards( "8D 5D 7D JD 9D" );
    assertTrue( fiveCards.hasAllCardsOfTheSameSuit() );
  }

  @Test
  void hasAllCardsOfTheSameSuit_ShouldReturnFalse(){
    Cards fiveCards = new Cards( "8D 5C 7D JD 9D" );
    assertFalse( fiveCards.hasAllCardsOfTheSameSuit() );
  }

  @Test
  void hasConsecutiveValues_ShouldReturnTrue(){
    Cards fiveCards = new Cards( "5D 6D 7D 8D 9D" );
    boolean result = fiveCards.hasConsecutiveValues();
    assertTrue( result );
  }
  @Test
  void hasConsecutiveValues_ShouldReturnFalse(){
    Cards fiveCards = new Cards( "5D 6D JD 8D 9D" );
    assertFalse( fiveCards.hasConsecutiveValues() );
  }
  @Test
  void hasFourCardsOfTheSameValue_ShouldReturnTrue(){
    Cards fourCards = new Cards( "5D 5C 5H 8D 5S" );
    assertNotNull( fourCards.hasFourCardsOfTheSameValue()  );
  }

  @Test
  void hasFourCardsOfTheSameValue_ShouldReturnFalse(){
    Cards fourCards = new Cards( "5D 6C 5H 8D 5S" );
    assertNotNull( fourCards.hasFourCardsOfTheSameValue() );
  }

  @Test
  void hasThreeCardsOfTheSameValue_ShouldReturnTrue(){
    Cards threeCards = new Cards( "5D 5C 10H 8D 5S" );
    assertNotNull( threeCards.hasThreeCardsOfTheSameValue() );
  }

  @Test
  void hasThreeCardsOfTheSameValue_ShouldReturnFalse(){
    Cards threeCards = new Cards( "5D 9C 10H 8D 5S" );
    assertNotNull( threeCards.hasThreeCardsOfTheSameValue() );
  }
  @Test
  void hasTwoCardsOfTheSameValue_ShouldReturnTrue(){
    Cards twoCards = new Cards( "5D 9C 10H 8D 5S" );
    assertNotNull( twoCards.hasTwoCardsOfTheSameValue() );
  }
  @Test
  void hasTwoCardsOfTheSameValue_ShouldReturnFalse(){
    Cards twoCards = new Cards( "5D 9C 10H 8D 2S" );
    assertNotNull( twoCards.hasTwoCardsOfTheSameValue() );
  }
  @Test
  void hasTwoPairs_ShouldReturnTrue(){
    Cards twoPairs = new Cards( "5D 5C 10H 10D 8S" );
    assertNotNull( twoPairs.hasTwoPairs() );
  }
  @Test
  void hasTwoPairs_ShouldReturnFalse(){
    Cards twoPairs = new Cards( "5D 5C 10H 8D 5S" );
    assertNotNull( twoPairs.hasTwoPairs() );
  }

  @Test
  void compareToOtherSortedSCardSet_ShouldReturnAnIntegerGreaterThan0_WhenGivenCardSetHasHigherCard(){
    Cards cards1 = new Cards( "5D 5C 10H 8D 5S" );
    Cards cards2 = new Cards( "5D 5C 8H 8D 5S" );
    int compare = cards1.compareTo( cards2);
    assertTrue( compare >0 );
  }

  @Test
  void compareToOtherSortedSCardSet_ShouldReturnAnIntegerLessThan0_WhenTheOtherCardSetHasHigherCard(){
    Cards cards1 = new Cards( "5D 5C 10H 8D 5S" );
    Cards cards2 = new Cards( "5D AC 8H 8D 5S" );
    int compare = cards1.compareTo( cards2);
    assertTrue( compare <0 );
  }

  @Test
  void compareToOtherSortedSCardSet_ShouldReturnAnIntegerEqual0_WhenTheyHaveCardsWithSameValue(){
    Cards cards1 = new Cards( "5D 5C 10H 8D 5S" );
    Cards cards2 = new Cards( "5C 5H 10C 8S 5S" );
    int compare = cards1.compareTo( cards2);
    assertTrue( compare == 0 );
  }
}
