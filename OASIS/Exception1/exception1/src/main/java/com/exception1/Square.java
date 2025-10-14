// package com.exception1;

public class Square extends Expression {
    private Expression expression;

    /**
     * Constructor.
     * 
     * @param expression input expression
     */
    public Square(Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "(" + expression + ") ^ 2"; 
    }

    @Override
    public double evaluate() {
        return expression.evaluate() * expression.evaluate();
    }
}
