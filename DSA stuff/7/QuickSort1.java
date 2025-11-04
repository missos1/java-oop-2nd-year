import java.util.List;

public class QuickSort1 {
    public static List<Integer> quickSort(List<Integer> arr) {
        int i = arr.size();
        int j = i - 1;
        int pivot = arr.get(0);
        
        while (j > 0) {
            if (arr.get(j) >= pivot) {
                int temp = arr.get(--i);
                arr.set(i, arr.get(j));
                arr.set(j, temp );
            }
            j--;
        }
        arr.set(0, arr.get(--i));
        arr.set(i, pivot);
        
        return arr;
    }
}
