package tdd.pokerHands.gameServices;

import tdd.pokerHands.hand.PokerHand;

public class Player{
  private String name;
  private PokerHand pokerHand;

  public Player( String name ){
    this.name = name;
  }

  public Player( String name, PokerHand pokerHand ){
    this.name = name;
    this.pokerHand = pokerHand;
  }

  public void setPokerHand( PokerHand pokerHand ){
    this.pokerHand = pokerHand;
  }

  public String getName(){
    return name;
  }

  public PokerHand getPokerHand(){
    return pokerHand;
  }
}
