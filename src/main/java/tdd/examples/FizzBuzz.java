package tdd.examples;

import tdd.exceptions.InvalidListException;

// kata: https://codingdojo.org/kata/FizzBuzz/
public class FizzBuzz {
    public String check(Integer number){
        if(number < 1 ||  number>100) throw new InvalidListException("number " + number + " not in range from 1 to 100");
        if(isDivisibleByThree(number) && isDivisibleByFive(number)) return "FizzBuzz";
        if(isDivisibleByThree(number)) return "Fizz";
        if(isDivisibleByFive(number)) return "Buzz";
        return String.valueOf(number);
    }

    private boolean isDivisibleByThree(int number){
        return number % 3 == 0;
    }

    private boolean isDivisibleByFive(int number){
        return number % 5 == 0;
    }
}
