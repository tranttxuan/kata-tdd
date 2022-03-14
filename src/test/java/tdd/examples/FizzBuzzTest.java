package tdd.examples;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import tdd.exceptions.InvalidListException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {
    @Test
    public void testFizzCase() {
        FizzBuzz checkFizzBuzz = new FizzBuzz();
        String fizz = checkFizzBuzz.check(3);
        assertEquals("Fizz", fizz);
    }

    @Test
    public void testBuzzCase() {
        FizzBuzz checkFizzBuzz = new FizzBuzz();
        String buzz = checkFizzBuzz.check(5);
        assertEquals("Buzz", buzz);
    }

    @Test
    public void testFizzBuzzCase() {
        FizzBuzz checkFizzBuzz = new FizzBuzz();
        String fizzbuzz = checkFizzBuzz.check(15);
        assertEquals("FizzBuzz", fizzbuzz);
    }

    @Test
    public void testNumber0NotInRange(){
        FizzBuzz checkFizzBuzz = new FizzBuzz();
        assertThrows(InvalidListException.class, ()-> checkFizzBuzz.check(0), "number 0 not in range from 1 to 100");
    }

    @Test
    public void testNumber101NotInRange(){
        FizzBuzz checkFizzBuzz = new FizzBuzz();
        assertThrows(InvalidListException.class, ()-> checkFizzBuzz.check(101), "number 0 not in range from 1 to 100");
    }

    @Test
    public void testFizzBuzzCases() {
        List<Integer> numberList = IntStream.rangeClosed(1, 15).boxed().collect(Collectors.toList());
        FizzBuzz checkFizzBuzz = new FizzBuzz();
        List<String> returnList = numberList.stream().map(number -> checkFizzBuzz.check(number)).collect(Collectors.toList());
        List<String> expectedList = Arrays.asList("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz");
        Assert.assertEquals(returnList, expectedList);
    }
}