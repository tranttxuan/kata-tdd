package tdd.examples;

import org.junit.jupiter.api.Test;
import tdd.exceptions.InvalidListException;

import static org.junit.jupiter.api.Assertions.*;

class NumberServiceTest {
    @Test
    public void testBiggestNumber(){
        int[] list = new int[]{10, 8, 9};
        NumberService numberService = new NumberService();
        int biggestNumber = numberService.biggestNumber(list);
        assertEquals(biggestNumber, 10);
    }

    @Test
    public void testBiggestNumberWithNegativeValue(){
        int[] list = new int[]{-10, -8, -9};
        NumberService numberService = new NumberService();
        int biggestNumber = numberService.biggestNumber(list);
        assertEquals(biggestNumber, -8);
    }

    @Test()
    public void testBiggestNumberWithNullValue(){
        NumberService numberService = new NumberService();
        assertThrows(InvalidListException.class, ()-> numberService.biggestNumber(null), "List must not be null");
    }
}