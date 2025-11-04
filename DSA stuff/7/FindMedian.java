import java.util.List;

public class FindMedian {
    private static int partition(int lo, int hi, List<Integer> arr) {
        int i = lo - 1;
        int pivot = arr.get(hi);
        for (int j = lo; j < hi; j++) { // 1st iteration is n then n / 2, n / 4
            if (arr.get(j) < pivot) {
                int temp = arr.get(++i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        
        arr.set(hi, arr.get(++i));
        arr.set(i, pivot);
        
        if (i < (arr.size() >> 1)) { 
            return partition(i + 1, hi, arr); // find in right half
        } 
        if (i > (arr.size() >> 1)) {
            return partition(lo, i - 1, arr); // find in left half
        }
        
        return i; // found median
    }

    public static int findMedian(List<Integer> arr) {
        return arr.get(partition(0, arr.size() - 1, arr));
    }
}
