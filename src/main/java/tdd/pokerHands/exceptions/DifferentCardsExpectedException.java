package tdd.pokerHands.exceptions;

public class DifferentCardsExpectedException extends RuntimeException{
  public DifferentCardsExpectedException( ){
    super( "Please check all cards in deck" );
  }
}
