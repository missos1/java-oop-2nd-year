public class Prime {
    public static void main(String[] args) {
        
    }
    /**
     * This function checks whether a number is prime.
     * @param n the input int 
     * @return whether a number is prime
     */
    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 7; i * i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}