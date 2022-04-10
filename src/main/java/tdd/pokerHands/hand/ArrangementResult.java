package tdd.pokerHands.hand;

import tdd.pokerHands.cards.Value;
import tdd.pokerHands.cards.FiveCardsArrangement;

import java.util.Collections;
import java.util.Map;

public class ArrangementResult{
  private FiveCardsArrangement bestArrangement;
  private Map<Value, Integer> frequencyMapForValues;

  public ArrangementResult( FiveCardsArrangement bestArrangement ){
    this.bestArrangement = bestArrangement;
    this.frequencyMapForValues = Collections.emptyMap();
  }

  public ArrangementResult( FiveCardsArrangement bestArrangement, Map<Value, Integer> frequencyMapForValues ){
    this.bestArrangement = bestArrangement;
    this.frequencyMapForValues = frequencyMapForValues;
  }

  public FiveCardsArrangement getBestArrangement(){
    return bestArrangement;
  }

  public Map<Value, Integer> getFrequencyMapForValues(){
    return frequencyMapForValues;
  }
}
