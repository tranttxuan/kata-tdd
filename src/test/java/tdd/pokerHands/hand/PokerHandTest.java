package tdd.pokerHands.hand;

import org.junit.jupiter.api.Test;
import tdd.pokerHands.cards.Card;
import tdd.pokerHands.exceptions.DifferentCardsExpectedException;
import tdd.pokerHands.exceptions.FiveCardsExpectedException;
import tdd.pokerHands.cards.FiveCardsArrangement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PokerHandTest{
  List<Card> cards = new ArrayList<>( );

  @Test
  void aPokerHand_ShouldHaveOnly5Cards(){
    assertThrows( FiveCardsExpectedException.class, () -> {
      PokerHand hand = new PokerHand( "player", "8D 5H 7S JS 9H 7C" );
    } );
  }

  @Test
  void aPokerHand_ShouldHaveFiveDifferentCards(){
    assertThrows( DifferentCardsExpectedException.class, () -> {
      PokerHand hand = new PokerHand( "player","5H 7S JS 9H 5H" );
    } );
  }

  @Test
  void firstDealtFiveCards_shouldReturn_STRAIGHT_FLUSH_WhenInputCanBeArrangedIn_Straight_Flush(){
    PokerHand hand = new PokerHand("player",  "5H 7H 6H 9H 8H"  );
    FiveCardsArrangement bestArrangement = hand.firstDealFiveCards().getBestArrangement();
    assertEquals( bestArrangement, FiveCardsArrangement.STRAIGHT_FLUSH );
    assertEquals( bestArrangement, FiveCardsArrangement.STRAIGHT_FLUSH );
  }

  @Test
  void firstDealtFiveCards_shouldReturn_FOUR_OF_KIND_WhenInputCanBeArrangedIn_FOUR_OF_KIND(){
    PokerHand hand = new PokerHand( "player", "5H 5D 5S 5C 8H" );
    FiveCardsArrangement bestArrangement = hand.firstDealFiveCards().getBestArrangement();
    assertEquals( bestArrangement, FiveCardsArrangement.FOUR_OF_KIND );
    assertEquals( bestArrangement, FiveCardsArrangement.FOUR_OF_KIND );
  }

  @Test
  void firstDealtFiveCards_shouldReturn_FULL_HOUSE_WhenInputCanBeArrangedIn_FULL_HOUSE(){
    PokerHand hand = new PokerHand("player","5H 5D 5S 8C 8H" );
    FiveCardsArrangement bestArrangement = hand.firstDealFiveCards().getBestArrangement();
    assertEquals( bestArrangement, FiveCardsArrangement.FULL_HOUSE );
    assertEquals( bestArrangement, FiveCardsArrangement.FULL_HOUSE );
  }

  @Test
  void firstDealtFiveCards_shouldReturn_FLUSH_WhenInputCanBeArrangedIn_FLUSH(){
    PokerHand hand = new PokerHand( "player","9H 10H 5H AH 2H"  );
    FiveCardsArrangement bestArrangement = hand.firstDealFiveCards().getBestArrangement();
    assertEquals( bestArrangement, FiveCardsArrangement.FLUSH );
    assertEquals( bestArrangement, FiveCardsArrangement.FLUSH );
  }

  @Test
  void firstDealtFiveCards_shouldReturn_STRAIGHT_WhenInputCanBeArrangedIn_STRAIGHT(){
    PokerHand hand = new PokerHand( "player", "9H 10D JD KS QC" );
    FiveCardsArrangement bestArrangement = hand.firstDealFiveCards().getBestArrangement();
    assertEquals( bestArrangement, FiveCardsArrangement.STRAIGHT );
    assertEquals( bestArrangement, FiveCardsArrangement.STRAIGHT );
  }

  @Test
  void firstDealtFiveCards_shouldReturn_THREE_OF_KIND_WhenInputCanBeArrangedIn_THREE_OF_KIND(){
    PokerHand hand = new PokerHand( "player", "9H 9D JD 9S QC"  );
    FiveCardsArrangement bestArrangement = hand.firstDealFiveCards().getBestArrangement();
    assertEquals( bestArrangement, FiveCardsArrangement.THREE_OF_KIND );
    assertEquals( bestArrangement, FiveCardsArrangement.THREE_OF_KIND );
  }
  @Test
  void firstDealtFiveCards_shouldReturn_TWO_PAIRS_WhenInputCanBeArrangedIn_TWO_PAIRS(){
    PokerHand hand = new PokerHand( "player","9D QD JD 9S JC" );
    FiveCardsArrangement bestArrangement = hand.firstDealFiveCards().getBestArrangement();
    assertEquals( bestArrangement, FiveCardsArrangement.TWO_PAIRS );
    assertEquals( bestArrangement, FiveCardsArrangement.TWO_PAIRS );
  }
  @Test
  void firstDealtFiveCards_shouldReturn_One_PAIR_WhenInputCanBeArrangedIn_One_PAIR(){
    PokerHand hand = new PokerHand( "player", "9H QD AD 9S JC" );
    FiveCardsArrangement bestArrangement = hand.firstDealFiveCards().getBestArrangement();
    assertEquals( bestArrangement, FiveCardsArrangement.ONE_PAIR );
    assertEquals( bestArrangement, FiveCardsArrangement.ONE_PAIR );
  }
}
