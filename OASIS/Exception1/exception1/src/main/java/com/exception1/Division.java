// package com.exception1;

public class Division extends BinaryExpression {
    /**
     * Constructor.
     * 
     * @param left left expression
     * @param right right expression
     */
    public Division(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public String toString() {
        return "(" + left + " / " + right + ")";
    }

    @Override
    public double evaluate() {
        if (right.evaluate() == 0) {
            throw new ArithmeticException("Lỗi chia cho 0");
        }
        return left.evaluate() / right.evaluate();
    }
}
