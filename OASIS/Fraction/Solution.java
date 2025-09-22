public class Solution {
    private int numerator;
    private int denominator = 1;

    /**
     * Computes the greatest common divisor (GCD) of two integers using the
     * euclidean algorithm.
     *
     * @param a the first integer
     * @param b the second integer
     * @return the greatest common divisor of {@code a} and {@code b}
     */
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    /**
     * Normalize this fraction.
     *
     */
    private void normalizer() {
        if (denominator < 0) {
            denominator = -denominator;
            numerator = -numerator;
        }
    }

    /**
     * Constructs a {@code Solution} with the specified numerator and denominator.
     *
     * @param numerator the numerator of the fraction
     * @param denominator the denominator of the fraction (must not be zero)
     */
    public Solution(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator != 0) {
            this.denominator = denominator;
        }

        this.normalizer();
    }

    /**
     * Sets the numerator of this fraction.
     *
     * @param numerator the new numerator
     */
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    /**
     * Sets the denominator of this fraction.
     * If {@code denominator} is zero, the value is not changed.
     *
     * @param denominator the new denominator
     */
    public void setDenominator(int denominator) {
        if (denominator == 0) {
            return;
        }
        this.denominator = denominator;
    }

    /**
     * Returns the numerator of this fraction.
     *
     * @return the numerator
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * Returns the denominator of this fraction.
     *
     * @return the denominator
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * Reduces this fraction to its lowest terms.
     *
     * @return this {@code Solution} object after reduction
     */
    public Solution reduce() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
        return this;
    }

    /**
     * Adds another fraction to this one.
     *
     * @param other the fraction to add
     * @return this {@code Solution} after performing the addition
     */
    public Solution add(Solution other) {
        numerator = numerator * other.denominator + other.numerator * denominator;
        denominator = denominator * other.denominator;
        this.reduce();
        return this;
    }

    /**
     * Subtracts another fraction from this one.
     *
     * @param other the fraction to subtract
     * @return this {@code Solution} after performing the subtraction
     */
    public Solution subtract(Solution other) {
        numerator = numerator * other.denominator - other.numerator * denominator;
        denominator = denominator * other.denominator;
        this.reduce();
        return this;
    }

    /**
     * Multiplies this fraction by another.
     *
     * @param other the fraction to multiply by
     * @return this {@code Solution} after performing the multiplication
     */
    public Solution multiply(Solution other) {
        numerator = numerator * other.numerator;
        denominator = denominator * other.denominator;
        this.reduce();
        return this;
    }

    /**
     * Divides this fraction by another.
     * If the other numerator is zero, no operation is performed.
     *
     * @param other the fraction to divide by
     * @return this {@code Solution} after performing the division
     */
    public Solution divide(Solution other) {
        if (other.numerator != 0) {
            numerator = numerator * other.denominator;
            denominator = denominator * other.numerator;
            this.reduce();
        }
        return this;
    }

    /**
     * Checks if this fraction is equal to another object.
     * Two fractions are considered equal if they are numerically equivalent
     * after reduction.
     *
     * @param obj the object to compare with
     * @return {@code true} if the objects represent the same fraction;
     *         {@code false} otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Solution)) {
            return false;
        }
        Solution other = (Solution) obj;
        other.reduce();
        this.reduce();
        this.normalizer();
        other.normalizer();
        return numerator == other.numerator && denominator == other.denominator;
    }
}