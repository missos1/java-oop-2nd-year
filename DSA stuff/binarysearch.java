import java.util.Scanner;

public class binarysearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(binarysearch_sqrt(n));
    }

    // public static int binarysearch(int[] a, int n, int left, int right) {
    //     if (right < left) return -1;
        
    //     int mid = left + (right - left) / 2;
    //     if (a[mid] == n) return mid;

    //     else if (n > a[mid]) return binarysearch(a, n, mid + 1, right);
    //     return binarysearch(a, n, left, mid - 1);
    // }

    /**
     * This function calculates the square root of a number to the 
     * maximum accuracy of the double bit representation.
     * @param n any positive double number
     * @return the square root of n 
     */
    public static double binarysearch_sqrt(double n) {
        if (n < 0.0) return -1.0;
        double left = 1;
        double right = n;
        double temp = 0;
        while (true) {
            double mid = left + (right - left) / 2;
            if (mid == temp) return mid;
            if (mid * mid > n) right = mid;
            else left = mid;
            temp = mid;
        }
    }
}