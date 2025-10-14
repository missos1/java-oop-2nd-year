// package com.exception1;

public abstract class Expression {
    /**
     * toString method to be overriden.
     * 
     * @return String format or the expression with proper parentheses
     */
    public abstract String toString();

    /**
     * evaluate method for the expression.
     * 
     * @return the actual value in double of the expression 
     */
    public abstract double evaluate();
}
