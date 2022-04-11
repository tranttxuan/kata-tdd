package tdd.pokerHands.gameServices;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.pokerHands.cards.Card;
import tdd.pokerHands.exceptions.CardSuitExpectedException;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class Standard52CardDeckTest{
  Standard52CardDeck cardDeck;

  @BeforeEach
  void createCards(){
    cardDeck = new Standard52CardDeck();
  }

  @Test
  void createCardDesk_shouldContain52Cards(){
    assertEquals( cardDeck.cards.size(), 52 );
  }

  @Test
    void createCardDesk_shouldNotContainUnknownCard(){
      assertThrows( CardSuitExpectedException.class, ()->cardDeck.cards.contains( new Card( "2M" ) ) );
  }


  @Test
  void createCardDesk_shouldContainDifferent52Cards(){
    assertEquals( cardDeck.cards.size(), new HashSet<>( cardDeck.cards ).size() );
  }
}