package tdd.pokerHands.gameServices;

import tdd.pokerHands.cards.FiveCardsArrangement;
import tdd.pokerHands.cards.Value;
import tdd.pokerHands.hand.ArrangementResult;
import tdd.pokerHands.hand.PokerHand;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Game{
  private Player playerOne;
  private Player playerTwo;
  private Boolean gameOver;


  public Game( Player playerOne, Player playerTwo ){
    this.playerOne = playerOne;
    this.playerTwo = playerTwo;
    this.gameOver = false;
  }

  public Player getPlayerOne(){
    return playerOne;
  }

  public Player getPlayerTwo(){
    return playerTwo;
  }

  public void setPlayerOne( PokerHand pokerHand ){
    this.playerOne.setPokerHand( pokerHand );
  }

  public void setPlayerTwo( PokerHand pokerHand ){
    this.playerTwo.setPokerHand( pokerHand );
  }

  public String compareTwoPlayers(){

    // First Cards Arrangement
    ArrangementResult arrangementResultOfPlayerOne = playerOne.getPokerHand( ).firstDealFiveCards( );
    ArrangementResult arrangementResultOfPlayerTwo = playerTwo.getPokerHand( ).firstDealFiveCards( );

    if(arrangementResultOfPlayerOne == null) return playerTwo.getName( );

    if(arrangementResultOfPlayerTwo == null) return playerOne.getName( );

    int compare = arrangementResultOfPlayerOne.getBestArrangement( ).getPoint( ) - arrangementResultOfPlayerTwo.getBestArrangement( ).getPoint( );

    if(compare > 0){
      return playerOne.getName( );
    }
    if(compare < 0){
      return playerTwo.getName( );
    }

    // if they have the same best arrangement after the fist dealt 5 cards

    // continue with second compare

    // in case:  full house - Three of a Kind
    if(arrangementResultOfPlayerOne.getBestArrangement( ) == FiveCardsArrangement.FULL_HOUSE || arrangementResultOfPlayerOne.getBestArrangement( ) == FiveCardsArrangement.THREE_OF_KIND){
      Value commonValueOfThreeCardsOfPlayerOne = arrangementResultOfPlayerOne.getFrequencyMapForValues( )
          .keySet( )
          .stream( )
          .findFirst( )
          .get( );

      Value commonValueOfThreeCardsOfPlayerTwo = arrangementResultOfPlayerTwo.getFrequencyMapForValues( )
          .keySet( )
          .stream( )
          .findFirst( )
          .get( );

      int compareCommonValues = commonValueOfThreeCardsOfPlayerOne.getIntValue( ) - commonValueOfThreeCardsOfPlayerTwo.getIntValue( );
      if(compareCommonValues > 0){
        return playerOne.getName( );
      }
      if(compareCommonValues < 0){
        return playerTwo.getName( );
      }
    }

    // in case:  two pairs or one pair

    if(arrangementResultOfPlayerOne.getBestArrangement( ) == FiveCardsArrangement.TWO_PAIRS || arrangementResultOfPlayerOne.getBestArrangement( ) == FiveCardsArrangement.ONE_PAIR ){
      List<Value> valuesInPairsOfPlayerOne = arrangementResultOfPlayerOne.getFrequencyMapForValues( )
          .keySet( )
          .stream( )
          .sorted( Comparator.comparing( Value::getIntValue ) )
          .collect( Collectors.toList( ) );

      List<Value> valuesInPairsOfPlayerTwo = arrangementResultOfPlayerTwo.getFrequencyMapForValues( )
          .keySet( )
          .stream( )
          .sorted( Comparator.comparing( Value::getIntValue ) )
          .collect( Collectors.toList( ) );

      for(int i =( valuesInPairsOfPlayerOne.size() - 1); i >= 0 ; i--){
        int compareTwoValues = valuesInPairsOfPlayerOne.get( i ).comparedTo( valuesInPairsOfPlayerTwo.get( i ) );
        if(compareTwoValues > 0){
          return playerOne.getName( );
        }
        if(compareTwoValues < 0){
          return playerTwo.getName( );
        }
      }
    }

    // in case: Straight flush - Four of a kind - Flush - Straight
    int compareTwoSetOfSortedCards = playerOne.getPokerHand( ).compareToHighestCardOf( playerTwo.getPokerHand( ) );

    if(compareTwoSetOfSortedCards > 0){
      return playerOne.getName( );
    }
    if(compareTwoSetOfSortedCards < 0){
      return playerTwo.getName( );
    }

    return "Tie";
  }
}
