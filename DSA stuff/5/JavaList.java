import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaList {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            sc.nextLine();
            String s = sc.nextLine();
            
            if (s.equals("Insert")) {
                int index = sc.nextInt();
                int val = sc.nextInt();
                arr.add(index, val);
            } else {
                int index = sc.nextInt();
                arr.remove(index);
            }
        }
        
        for (int i : arr) {
            System.out.print(i + " ");
        }
        sc.close();
    }
}
