package tdd.expression;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("an arithmetic expression test")
class ExpressionTest {
    private Expression arithmeticExpression;

    @BeforeEach
    void setUp(){
        this.arithmeticExpression = Expression.build();
    }

    @Test
    void testEvalAddExpression(){
        final String expression = "1+2";
        assertEquals(arithmeticExpression.eval(expression), 3.00);
    }

    @Test
    void testEvalSubstractExpression(){
        final String expression = "2-1";
        assertEquals(arithmeticExpression.eval(expression), 1.00);
    }

    @Test
    void testEvalMultipleExpression(){
        final String expression = "2*1";
        assertEquals(arithmeticExpression.eval(expression), 2.00);
    }

    @Test
    void testEvalDivideExpression(){
        final String expression = "4/2";
        assertEquals(arithmeticExpression.eval(expression), 2.00);
    }

    @Test
    void ThrowExceptionWhenExpressionIsBlank(){
        assertThrows(IllegalArgumentException.class, ()-> arithmeticExpression.eval(""));
    }

    @Test
    void ThrowExceptionWhenExpressionIsNull(){
        assertThrows(IllegalArgumentException.class, ()-> arithmeticExpression.eval(null));
    }

    @Test
    void ThrowExceptionWhenExpressionContainsUnsupportedOperator(){
        assertThrows(IllegalArgumentException.class, ()-> arithmeticExpression.eval("1?2"));
    }

    @Test
    void ThrowExceptionWhenExpressionMissOperator(){
        assertThrows(IllegalArgumentException.class, ()-> arithmeticExpression.eval("12"));
    }

    @Test
    void ThrowExceptionWhenExpressionMissOperand(){
        assertThrows(IllegalArgumentException.class, ()-> arithmeticExpression.eval("1+"));
    }

    @Test
    void ThrowExceptionWhenDivisorIsZero(){
        assertThrows(IllegalArgumentException.class, ()-> arithmeticExpression.eval("1/0"));
    }

    @Test
    void ThrowExceptionWhenOperandIsNotNumber(){
        assertThrows(IllegalArgumentException.class, ()-> arithmeticExpression.eval("x+y"));
    }
}