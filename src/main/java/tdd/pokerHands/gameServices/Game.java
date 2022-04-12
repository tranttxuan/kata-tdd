package tdd.pokerHands.gameServices;

import tdd.pokerHands.cards.Card;
import tdd.pokerHands.cards.Cards;
import tdd.pokerHands.cards.FiveCardsArrangement;
import tdd.pokerHands.hand.ArrangementResult;
import tdd.pokerHands.hand.PokerHand;

import java.util.*;

public class Game{
  private PokerHand playerOne;
  private PokerHand playerTwo;
  private Boolean gameOver;

  public Game( PokerHand playerOne, PokerHand playerTwo ){
    this.playerOne = playerOne;
    this.playerTwo = playerTwo;
    this.gameOver = false;
  }

  public String play(){
    dealCardsToPlayer( );
    System.out.println( playerOne.getName( ) + ": " + playerOne.toString( ) );
    System.out.println( playerTwo.getName( ) + ": " + playerTwo.toString( ) );
    return compareTwoPlayers( );
  }

  private void dealCardsToPlayer(){
    List<Card> cardDeck = new ArrayList<>( new Standard52CardDeck( ).cards );
    Collections.shuffle( cardDeck );

    List<Integer> integerList = new ArrayList<>( );
    int count = 1;
    while(count <= 10){
      int randomInteger = new Random( ).nextInt( 52 );
      if(!integerList.contains( randomInteger )){
        integerList.add( randomInteger );
        count++;
      }
    }

    List<Card> cardsForPlayerOne = new ArrayList<>( );
    List<Card> cardsForPlayerTwo = new ArrayList<>( );

    for(int i = 0; i < 10; i++){
      if(i % 2 == 0) cardsForPlayerOne.add( cardDeck.get( integerList.get( i ) ) );
      else cardsForPlayerTwo.add( cardDeck.get( integerList.get( i ) ) );
    }

    setPlayerOne( new Cards( cardsForPlayerOne ) ) ;
    setPlayerTwo( new Cards( cardsForPlayerTwo ) );
  }

  public String play( String cardsForPlayerOne, String cardsForPlayerTwo ){
    setPlayerOne( cardsForPlayerOne );
    setPlayerTwo(cardsForPlayerTwo );
    return compareTwoPlayers( );
  }

  public void setPlayerOne( Cards cards ){
    this.playerOne.setCards( cards );
  }

  public void setPlayerTwo( Cards cards  ){
    this.playerTwo.setCards( cards );
  }

  public void setPlayerOne( String cards ){
    this.playerOne.setCards( cards );
  }

  public void setPlayerTwo( String cards  ){
    this.playerTwo.setCards( cards );
  }

  public PokerHand getPlayerOne(){
    return playerOne;
  }

  public PokerHand getPlayerTwo(){
    return playerTwo;
  }

  public String compareTwoPlayers(){

    // First Cards Arrangement
    ArrangementResult arrangementResultOfPlayerOne = playerOne.firstDealFiveCards( );
    ArrangementResult arrangementResultOfPlayerTwo = playerTwo.firstDealFiveCards( );

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
      int compare = Cards.compareValuesOfTwoMaps( playerOne.getCards( ).getFrequencyMap( ), playerTwo.getCards( ).getFrequencyMap( ) );
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
