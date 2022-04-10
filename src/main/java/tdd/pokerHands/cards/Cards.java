package tdd.pokerHands.cards;

import java.util.*;
import java.util.stream.Collectors;

public class Cards{
  private final List<Card> cards;

  public Cards( List<Card> cards ){
    this.cards = sortCards(cards) ;
  }

  public Cards( String listShortCards ){
    String[] shortNames = listShortCards.trim( ).split( " " );
    List<Card> createdCards = new ArrayList<>( );
    for(String name : shortNames){
      createdCards.add( new Card( name ) );
    }
    this.cards = sortCards(createdCards  ) ;
  }

  public int size(){
    return cards.size( );
  }

  public boolean areDifference(){
    Set<Card> set = new HashSet<>( cards );
    return set.size( ) == cards.size( );
  }

  public boolean hasAllCardsOfTheSameSuit(){
    int countDiffSuit = (int) cards
        .stream( )
        .map( Card::getSuit )
        .collect( Collectors.toList( ) )
        .stream( )
        .distinct( )
        .count( );
    return countDiffSuit <= 1 ? true : false;
  }

  public List<Card> sortCards( List<Card> cards ){
    return cards
        .stream( )
        .sorted( Comparator.comparing( Card::getValue ) )
        .collect( Collectors.toList( ) );
  }

  public boolean hasConsecutiveValues(){
    for(int i = 0; i < cards.size( ) - 1; i++){
      if(cards.get( i ).getValue( ).getIntValue( ) != (cards.get( i + 1 ).getValue( ).getIntValue( ) - 1))
        return false;
    }
    return true;
  }

  public Map<Value, Integer> frequencyMapForValue(){
    Map<Value, Integer> frequencyMap = new HashMap<>( );

    for(Card card : cards){
      Integer count = frequencyMap.get( card.getValue( ) );
      if(count == null) count = 0;
      frequencyMap.put( card.getValue( ), count + 1 );
    }
    return frequencyMap;
  }

  private Map<Value, Integer> isNCardsOfTheSameValue( Integer n ){
    return frequencyMapForValue( )
        .entrySet()
        .stream()
        .filter( entry -> entry.getValue() == n)
        .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
  }

  public  Map<Value, Integer> hasFourCardsOfTheSameValue(){
    return isNCardsOfTheSameValue( 4 );
  }

  public  Map<Value, Integer> hasThreeCardsOfTheSameValue(){
    return isNCardsOfTheSameValue( 3 );
  }

  public  Map<Value, Integer> hasTwoCardsOfTheSameValue(){
    return isNCardsOfTheSameValue( 2 );
  }

  public Map<Value, Integer> hasTwoPairs(){
    Map<Value, Integer> frequencyMapForValues = isNCardsOfTheSameValue( 2 );
    return frequencyMapForValues.entrySet().stream().count() == 2 ? frequencyMapForValues : Collections.emptyMap();
  }

  public int compareTo( Cards cards2){
    for(int i= (cards.size() - 1); i >= 0; i--){
      int compare = cards.get( i ).compareTo(cards2.get(i));
      if(compare != 0){
        return compare;
      }
    }
    return 0;
  }

  public Card get(int index){
    return cards.get( index );
  }
}
