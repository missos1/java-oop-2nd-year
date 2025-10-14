// package com.exception1;

public class Numeral extends Expression {
    private double value;

    /**
     * Default constructor.
     */
    public Numeral() {

    }

    /**
     * Constructor takes in value.
     * 
     * @param value input value
     */
    public Numeral(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Math.round(value) + "";
    }

    @Override
    public double evaluate() {
        return value;
    }
}
