import java.util.Scanner;

public class Fibo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(fibonacci(n));
    }

    /**
    * calculates the nth fibonacci number.
    * @param n the index (must be >= 0)
    * @return the nth Fibonacci number, or -1 if n < 0 or result overflows long
    */
    public static long fibonacci(long n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n < 0) {
            return -1;
        } 

        long i = 2;
        long a = 0;
        long b = 1;
        long tmp = 0;

        while (i <= n) {
            if (Long.MAX_VALUE - b < a) {
                return Long.MAX_VALUE;
            }

            tmp = a + b;
            a = b;
            b = tmp;
            i++;
        }
        
        return tmp;
    }
}