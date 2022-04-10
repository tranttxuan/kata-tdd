package tdd.pokerHands.hand;

import tdd.pokerHands.cards.Cards;
import tdd.pokerHands.cards.Value;
import tdd.pokerHands.exceptions.DifferentCardsExpectedException;
import tdd.pokerHands.exceptions.FiveCardsExpectedException;
import tdd.pokerHands.cards.FiveCardsArrangement;

import java.util.Map;

public class PokerHand{
  private Cards cards;
  private FiveCardsArrangement bestArrangement;

  public PokerHand( Cards cards ){
    if(!hasFiveCardsInHand( cards )){
      throw new FiveCardsExpectedException( );
    }
    if(!hasDifferentCardsInHand( cards )){
      throw new DifferentCardsExpectedException( );
    }
    this.cards = cards;
  }

  public Cards getCards(){
    return cards;
  }

  private boolean hasFiveCardsInHand( Cards cards ){
    if(cards.size( ) != 5) return false;
    return true;
  }

  private boolean hasDifferentCardsInHand( Cards cards ){
    return cards.areDifference( );
  }

  public ArrangementResult firstDealFiveCards(){
    if(cards.hasConsecutiveValues( ) && cards.hasAllCardsOfTheSameSuit( )){
      return new ArrangementResult(FiveCardsArrangement.STRAIGHT_FLUSH);
    }

    Map<Value, Integer> mapForFourCardsOfTheSameValue = cards.hasFourCardsOfTheSameValue( );
    if(!mapForFourCardsOfTheSameValue.isEmpty()){
      return new ArrangementResult(FiveCardsArrangement.FOUR_OF_KIND);
    }

    Map<Value, Integer> mapForThreeCardsOfTheSameValue =cards.hasThreeCardsOfTheSameValue( );
    Map<Value, Integer> mapForTwoCardsOfTheSameValue =cards.hasTwoCardsOfTheSameValue( );
    if(!mapForThreeCardsOfTheSameValue.isEmpty() && !mapForTwoCardsOfTheSameValue.isEmpty()){
      return new ArrangementResult( FiveCardsArrangement.FULL_HOUSE, mapForThreeCardsOfTheSameValue);
    }

    if(cards.hasAllCardsOfTheSameSuit( )){
      return new ArrangementResult(FiveCardsArrangement.FLUSH);
    }
    if(cards.hasConsecutiveValues( )){
      return new ArrangementResult(FiveCardsArrangement.STRAIGHT);
    }

    if(!mapForThreeCardsOfTheSameValue.isEmpty()){
      return new ArrangementResult(FiveCardsArrangement.THREE_OF_KIND, mapForThreeCardsOfTheSameValue);
    }

    Map<Value, Integer> mapForTwoPairs = cards.hasTwoPairs( );
    if(!mapForTwoPairs.isEmpty()){
      return new ArrangementResult(FiveCardsArrangement.TWO_PAIRS, mapForTwoPairs );
    }
    if(!mapForTwoCardsOfTheSameValue.isEmpty()){
      return new ArrangementResult(FiveCardsArrangement.ONE_PAIR, mapForTwoCardsOfTheSameValue);
    }
    return null;
  }

  public int compareToHighestCardOf( PokerHand hand2){
      return cards.compareTo( hand2.getCards() );
  }
}
