package tdd.pokerHands.gameServices;

import tdd.pokerHands.cards.Cards;
import tdd.pokerHands.cards.FiveCardsArrangement;
import tdd.pokerHands.hand.ArrangementResult;
import tdd.pokerHands.hand.PokerHand;

public class Game{
  private Player playerOne;
  private Player playerTwo;
  private Boolean gameOver;


  public Game( Player playerOne, Player playerTwo ){
    this.playerOne = playerOne;
    this.playerTwo = playerTwo;
    this.gameOver = false;
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

    {
      int compare = arrangementResultOfPlayerOne.getBestArrangement( ).getPoint( ) - arrangementResultOfPlayerTwo.getBestArrangement( ).getPoint( );
      String winner = returnWinner( compare );
      if(winner != null) return winner;
    }

    // if they have the same best arrangement after the fist dealt 5 cards

    // continue with second compare
    // in case: full house - Three of a Kind -  Two pairs - One pair
    {
      if(arrangementResultOfPlayerOne.getBestArrangement( ) == FiveCardsArrangement.TWO_PAIRS || arrangementResultOfPlayerOne.getBestArrangement( ) == FiveCardsArrangement.ONE_PAIR){
        int compare = Cards.compareValuesOfTwoMaps( arrangementResultOfPlayerOne.getFrequencyMapForValues( ), arrangementResultOfPlayerTwo.getFrequencyMapForValues( ) );
        String winner = returnWinner( compare );
        if(winner != null) return winner;
      }
    }

    // in case: Straight flush - Four of a kind - Flush - Straight - and other cases

    {
      int compare = Cards.compareValuesOfTwoMaps( playerOne.getPokerHand( ).getCards( ).getFrequencyMap( ), playerTwo.getPokerHand( ).getCards( ).getFrequencyMap( ) );
      String winner = returnWinner( compare );
      if(winner != null) return winner;
    }

    return "Tie";
  }

  private String returnWinner( int compareValue ){
    if(compareValue > 0){
      return playerOne.getName( );
    }
    if(compareValue < 0){
      return playerTwo.getName( );
    }
    return null;
  }
}
