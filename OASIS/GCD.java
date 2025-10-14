import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(gcd(a, b));
        sc.close();
    }

    /**
     * calculates the gcd of 2 integers.
     * @param a the 1st integer
     * @param b the 2nd integer
     * @return the gcd of a and b
     */
    public static int gcd(int a, int b) {
        // if (b > a) {
        //     int temp = a;
        //     a = b;
        //     b = temp;
        // }

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }
}