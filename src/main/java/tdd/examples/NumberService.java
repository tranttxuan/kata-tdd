package tdd.examples;

import tdd.exceptions.InvalidListException;

public class NumberService {
    public int biggestNumber (int[] list){

        if(list == null) throw new InvalidListException("List must not be null");

        int maxNumber = Integer.MIN_VALUE;

        for(int i = 0; i < list.length; i++){
            if(list[i] > maxNumber) maxNumber = list[i];
        }
        return maxNumber;
    }
}
