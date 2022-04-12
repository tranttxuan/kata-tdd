package tdd.pokerHands;

import tdd.pokerHands.gameServices.Game;
import tdd.pokerHands.gameServices.Player;
import tdd.pokerHands.hand.PokerHand;

// https://codingdojo.org/kata/PokerHands/
//https://codegym.vn/blog/2017/04/21/kata-poker-hands/
public class Main{
  public static void main( String[] args ){
      Game poker = new Game( new PokerHand( "xuan" ), new PokerHand( "xiu" ) );
    String winner =  poker.play();
    System.out.println("Winner is " + winner);
  }
}
