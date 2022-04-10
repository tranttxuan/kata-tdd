package tdd.pokerHands.cards;

import java.util.HashMap;
import java.util.Map;

public enum Value{
  TWO( 2 ,"2" ),
  THREE( 3, "3" ),
  FOUR( 4 ,"4"),
  FIVE( 5,"5" ),
  SIX( 6,"6" ),
  SEVEN( 7 ,"7"),
  EIGHT( 8,"8" ),
  NINE( 9 ,"9"),
  TEN( 10 ,"10"),
  JACK( 11 ,"J"),
  QUEEN( 12 ,"Q"),
  KING( 13,"K" ),
  ACE( 14 ,"A");

  private final int intValue;
  private final String shortName;

  private static final Map<String, Value> valueMap = new HashMap<>(  );
  static {
    for(Value value : values()){
      valueMap.put( value.getShortName(), value);
    }
  }

  public static Value parse(String shortName){
    return valueMap.get( shortName );
  }

  Value( int intValue, String shortName ){
    this.intValue = intValue;
    this.shortName = shortName;
  }

  public int getIntValue(){
    return intValue;
  }

  public String getShortName(){
    return shortName;
  }
  public boolean equal(Value otherValue){
    return intValue == otherValue.getIntValue();
  }
  public int comparedTo(Value otherValue){
    return intValue - otherValue.getIntValue();
  }
}
