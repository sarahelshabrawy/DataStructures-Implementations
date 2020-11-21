package eg.edu.alexu.csd.datastructure.stack.cs28;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionEvaluatorTest {
ExpressionEvaluator test = new ExpressionEvaluator();
    @Test
    void infixToPostfix() {
        assertEquals("2 3 4 * +",test.infixToPostfix("2 + 3 * 4"));
        assertEquals("a b * 5 +",test.infixToPostfix("a * b + 5"));
        assertEquals("1 2 + 7 *",test.infixToPostfix("(1 + 2) * 7"));
        assertEquals("a b * c /",test.infixToPostfix("a * b / c"));
        assertEquals("a b c - d + / e a - * c *",test.infixToPostfix("(a / (b - c + d)) * (e - a) * c"));
        assertEquals("a b / c - d e * + a c * -",test.infixToPostfix("a / b - c + d * e - a * c"));
        assertEquals("3 4 5 * 6 / +",test.infixToPostfix("3+4*5/6"));
        assertEquals("300 23 + 43 21 - * 84 7 + /",test.infixToPostfix("(300+23)*(43-21)/(84+7) "));
        assertEquals("2 3 4 * +",test.infixToPostfix("2 + 3 * 4"));
        assertEquals("a b c * + d e / f * -",test.infixToPostfix("a+b*c-d/e*f"));
        assertThrows(java.lang.IllegalArgumentException.class,() ->test.infixToPostfix("3a*ab"),"Invalid expression !");
        assertThrows(java.lang.IllegalArgumentException.class,() ->test.infixToPostfix("())"),"Invalid expression !");
        assertThrows(java.lang.IllegalArgumentException.class,() ->test.infixToPostfix("((()))"),"Empty expression !");
    }

    @Test
    void evaluate() {
        assertEquals(78,test.evaluate(test.infixToPostfix("(300+23)*(43-21)/(84+7) ")));
        assertEquals(1,test.evaluate(test.infixToPostfix("1/8*8")));
        assertEquals(80,test.evaluate(test.infixToPostfix("75--5")));
        assertEquals(-44,test.evaluate(test.infixToPostfix("5 * -10 + 6")));
        assertEquals(100,test.evaluate(test.infixToPostfix("-10*-10")));
        assertEquals(10,test.evaluate(test.infixToPostfix("--10+0")));
        assertEquals(0,test.evaluate(test.infixToPostfix("0/10+1/8+6*0+-1+1")));
        assertEquals(3,test.evaluate(test.infixToPostfix("--1+1--1+1--1*-1")));
        assertEquals(700,test.evaluate(test.infixToPostfix("700*700/700")));
        assertThrows(java.lang.IllegalArgumentException.class,() ->test.infixToPostfix("abc+1"),"Expression contains unknowns..");

    }
}