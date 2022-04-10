package tdd.pokerHands.cards;

public enum FiveCardsArrangement{
  STRAIGHT_FLUSH (9),
  FOUR_OF_KIND (8),
  FULL_HOUSE (7),
  FLUSH (6),
  STRAIGHT (5),
  THREE_OF_KIND (4),
  TWO_PAIRS (3),
  ONE_PAIR(2);

  private int getPoint;

  private FiveCardsArrangement( int getPoint ){
    this.getPoint = getPoint;
  }

  public int getPoint(){
    return getPoint;
  }
}
