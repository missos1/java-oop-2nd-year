import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuickSort2 {
    private static int partition(int left, int right, List<Integer> arr) {
        int i = left - 1; // index of smaller element
        int pivot = arr.get(right); // pivot element
        
        for (int j = left; j < right; j++) { // iterate through elements
            if (arr.get(j) <= pivot) {
                int temp = arr.get(++i); // swap arr[i] and arr[j]
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        
        arr.set(right, arr.get(++i));
        arr.set(i, pivot);
        
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
        
        return i;
    }   
    
    public static void quickSort(int left, int right, List<Integer> arr) {
        if (left >= right || left < 0) return;
        
        int p = partition(left, right, arr);
        
        quickSort(left, p - 1, arr); 
        quickSort(p + 1, right, arr);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        List<Integer> arr = new ArrayList<>();
        
        while (n-- > 0) {
            int x = in.nextInt();
            arr.add(x);
        }
        
        quickSort(0, arr.size() - 1, arr);
        
        in.close();
    }
}
