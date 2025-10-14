package com.exception1;

public class Main {
    public static void main(String[] args) {
        Square tensquare = new Square(new Numeral(10)); // 10^2
        Numeral numeralThree = new Numeral(3); // 3
        Multiplication fourmultithree = new Multiplication(new Numeral(4), numeralThree); // 4 * 3
        Subtraction tenSqMinusThree = new Subtraction(tensquare, numeralThree); // (10^2 - 3)
        Addition innerExpression = new Addition(tenSqMinusThree, fourmultithree); // (10^2 - 3 + 4*3)
        Square result = new Square(innerExpression); // (10^2 - 3 + 4*3) ^ 2

        System.out.println(result.evaluate());
        System.out.println(result.toString());
    }
}