package tdd.pokerHands.gameServices;

import org.junit.jupiter.api.Test;
import tdd.pokerHands.cards.Cards;
import tdd.pokerHands.hand.PokerHand;

import static org.junit.jupiter.api.Assertions.*;

class GameTest{
  Game game = new Game(new Player( "Player1" ), new  Player(  "Player2" ) );

  @Test
  void comparedTwoPlayers_Player1HasStraightFlush_Beats_Player2HasFourOfAKind(){
    game.setPlayerOne(new PokerHand( new Cards(  "5H 7H 6H 9H 8H") ));
    game.setPlayerTwo(new PokerHand( new Cards(  "5H 5D 5C 5S 8H ") ));
    String winner = game.compareTwoPlayers();
    assertEquals( winner, "Player1");
  }

  @Test
  void comparedTwoPlayers_Player1HasOnePair_LosesTo_Player2FullHouse(){
    game.setPlayerOne(new PokerHand( new Cards(  "5H 7H 6H 8H 5D") ));
    game.setPlayerTwo(new PokerHand( new Cards(  "5H 5D 5C 8S 8H ") ));
    String winner = game.compareTwoPlayers();
    assertEquals( winner, "Player2");
  }
  @Test
  void comparedTwoPlayers_Player1HasNoThing_LosesTo_Player2FullHouse(){
    game.setPlayerOne(new PokerHand( new Cards(  "5H 7D 10H 9C 8H") ));
    game.setPlayerTwo(new PokerHand( new Cards(  "5H 8D 5C 5S 8H ") ));
    String winner = game.compareTwoPlayers();
    assertEquals( winner, "Player2");
  }

  @Test
  void comparedTwoPlayers_ShouldReturnPlayer2Wins_WhenPlayer2HasHighestCard_GivenTwoPlayersHaveTheSameBestArrangementFromTheFirstDealtTheirCards_StraightFlush(){
    game.setPlayerOne(new PokerHand( new Cards(  "5H 7H 6H 9H 8H") ));
    game.setPlayerTwo(new PokerHand( new Cards(  "10D 7D 6D 9D 8D") ));
    String winner = game.compareTwoPlayers();
    assertEquals( winner, "Player2");
  }

  @Test
  void comparedTwoPlayers_ShouldReturnPlayer2Wins_WhenPlayer2HasHigherCard_GivenTwoPlayersHaveTheSameBestArrangementFromTheFirstDealtTheirCards_Flush(){
    game.setPlayerOne(new PokerHand( new Cards(  "5H AH 6H 9H 8H") ));
    game.setPlayerTwo(new PokerHand( new Cards(  "10D 7D AD 9D 8D") ));
    String winner = game.compareTwoPlayers();
    assertEquals( winner, "Player2");
  }

  @Test
  void comparedTwoPlayers_ShouldReturnPlayer2Wins_WhenPlayersHaveDifferentHigherPairs_GivenTwoPlayersHaveTheSameBestArrangementFromTheFirstDealtTheirCards_TwoPairs(){
    game.setPlayerOne(new PokerHand( new Cards(  "10H 10C 5D 5H AH") ));
    game.setPlayerTwo(new PokerHand( new Cards(  "QD 2H QS 2D 8D") ));
    String winner = game.compareTwoPlayers();
    assertEquals( winner, "Player2");
  }

  @Test
  void comparedTwoPlayers_ShouldReturnPlayer2Wins_WhenPlayersHaveSameHigherPairs_GivenTwoPlayersHaveTheSameBestArrangementFromTheFirstDealtTheirCards_TwoPairs(){
    game.setPlayerOne(new PokerHand( new Cards(  "10H 10C 5D 5H AH") ));
    game.setPlayerTwo(new PokerHand( new Cards(  "10D JH 10S JD 8D") ));
    String winner = game.compareTwoPlayers();
    assertEquals( winner, "Player2");
  }
  @Test
  void comparedTwoPlayers_ShouldReturnPlayer2Wins_WhenPlayersHaveSameTwoPairs_GivenTwoPlayersHaveTheSameBestArrangementFromTheFirstDealtTheirCards_TwoPairs(){
    game.setPlayerOne(new PokerHand( new Cards(  "10H 10C 5D 5H 8H") ));
    game.setPlayerTwo(new PokerHand( new Cards(  "10D 5C 10S 5S AD") ));
    String winner = game.compareTwoPlayers();
    assertEquals( winner, "Player2");
  }

  @Test
  void comparedTwoPlayers_ShouldReturnPlayer2Wins_WhenPlayersHaveDifferentPair_GivenTwoPlayersHaveTheSameBestArrangementFromTheFirstDealtTheirCards_OnePair(){
    game.setPlayerOne(new PokerHand( new Cards(  "2H 2C QD 5H JH") ));
    game.setPlayerTwo(new PokerHand( new Cards(  "4D 3H 4S 2D 8D") ));
    String winner = game.compareTwoPlayers();
    assertEquals( winner, "Player2");
  }
  @Test
  void comparedTwoPlayers_ShouldReturnPlayer2Wins_WhenPlayersHaveSametPair_GivenTwoPlayersHaveTheSameBestArrangementFromTheFirstDealtTheirCards_OnePair(){
    game.setPlayerOne(new PokerHand( new Cards(  "10H 10C QD 5H JH") ));
    game.setPlayerTwo(new PokerHand( new Cards(  "10D 3H 10S 2D AD") ));
    String winner = game.compareTwoPlayers();
    assertEquals( winner, "Player2");
  }
}