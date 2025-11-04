import java.util.List;

public class InsertSort2 {
     public static void insertionSort2(int n, List<Integer> arr) {
        for (int i = 1; i < n; i++) {
            int temp = arr.get(i);
            int j = i - 1;
            while (j >= 0 && arr.get(j) > temp) {
                arr.set(j + 1, arr.get(j));
                j--;
            }
            arr.set(j + 1, temp);
            printArr(arr);
        }
        
    }
    
    private static void printArr(List<Integer> arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }
}
