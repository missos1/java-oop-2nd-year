import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaArrayList {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> twodArray = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int d = sc.nextInt();
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < d; j++) {
                temp.add(sc.nextInt());
            }
            twodArray.add(temp);
        }
        
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int xth = sc.nextInt();
            int yth = sc.nextInt();
            try {
                System.out.println(twodArray.get(xth - 1).get(yth - 1));
            } catch (Exception e) {
                System.out.println("ERROR!");
            }
        }
        sc.close();
    }
}
