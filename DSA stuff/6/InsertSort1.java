import java.util.List;

public class InsertSort1 {
    public static void insertionSort1(int n, List<Integer> arr) {
        if (n <= 0) {
            return;
        }
        
        if (n == 1) {
            printArr(arr);
            return;
        }

        int temp = arr.get(n - 1);
        int j = n - 2;
        while (j >= 0 && arr.get(j) > temp) {
            arr.set(j + 1, arr.get(j));
            printArr(arr);
            j--;
        }
        arr.set(j + 1, temp);
        printArr(arr);
    }
    
    private static void printArr(List<Integer> arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }
}
