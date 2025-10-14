// package com.exception1;

public class Multiplication extends BinaryExpression {
    /**
     * Constructor.
     * 
     * @param left left expression
     * @param right right expression
     */
    public Multiplication(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public String toString() {
        return "(" + left + " * " + right + ")";
    }

    @Override
    public double evaluate() {
        return left.evaluate() * right.evaluate();
    }
}
