// package com.exception1;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExpressionTest {
    Square tensquare = new Square(new Numeral(10)); // 10^2
    Numeral numeralMinusThree = new Numeral(-3); // 3
    Multiplication fourmultithree = new Multiplication(new Numeral(4), new Numeral(3)); // 4 * 3
    Addition tenSqPlusMinusThree = new Addition(tensquare, numeralMinusThree); // (10^2 - 3)
    Addition innerExpression = new Addition(tenSqPlusMinusThree, fourmultithree); // (10^2 - 3 + 4*3)
    Square result = new Square(innerExpression); // (10^2 - 3 + 4*3) ^ 2

    @Test
    public void testEvaluate() {
        assertEquals(11881, result.evaluate(), 0.000001);
    }

    @Test
    public void testToString() {
        assertEquals("((((10) ^ 2 + -3) + (4 * 3))) ^ 2", result.toString());
    }

     @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    // 2. Initialize your expression object to cause a divide-by-zero
    Expression expression = new Division(new Numeral(10), new Numeral(0));

    @Test
    public void testDividedbyZero_Rule() {
        // 3. Set the expected exception type
        thrown.expect(ArithmeticException.class);
        
        // 4. Set the expected exception message (can use Hamcrest matchers)
        thrown.expectMessage("Lỗi chia cho 0");

        // 5. Execute the code that should throw the exception
        expression.evaluate(); 
        
        // The test passes only if an ArithmeticException is thrown AND its message matches "Lỗi chia cho 0".
    }
}
