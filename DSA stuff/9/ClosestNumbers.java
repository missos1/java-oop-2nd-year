import java.util.ArrayList;
import java.util.List;

public class ClosestNumbers {
    private static void mergeSort(List<Integer> arr) {
        int length = arr.size();
        if (length <= 1) return;
        
        int mid = length / 2;
        List<Integer> left = new ArrayList<>(mid);
        List<Integer> right = new ArrayList<>(length - mid);
        
        for (int i = 0; i < length; i++) {
            if (i < mid) {
                left.add(arr.get(i));
            } else {
                right.add(arr.get(i));
            }
        }
        
        mergeSort(left);
        mergeSort(right);
        merge(left, arr, right);
    }
     
     
    private static void merge(List<Integer> left, List<Integer> arr, List<Integer> right) {
        int l = 0, r = 0, i = 0;
        while (l < left.size() && r < right.size()) {
            int templeft = left.get(l);
            int tempright = right.get(r);
            
            if (templeft < tempright) {
                arr.set(i++, templeft);
                l++;
            } else {
                arr.set(i++, tempright);
                r++;
            }
        }
        
        while (l < left.size()) {
            arr.set(i++, left.get(l++));
        }
        
        while (r < right.size()) {
            arr.set(i++, right.get(r++));
        }
    }

    public static List<Integer> closestNumbers(List<Integer> arr) {
        mergeSort(arr);
        int mindif = Integer.MAX_VALUE;
        
        for (int i = 0; i < arr.size() - 1; i++) {
            if (Math.abs(arr.get(i) - arr.get(i + 1)) < mindif) {
                mindif = Math.abs(arr.get(i) - arr.get(i + 1));
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < arr.size() - 1; i++) {
            if (Math.abs(arr.get(i) - arr.get(i + 1)) == mindif) {
                result.add(arr.get(i));
                result.add(arr.get(i + 1));
            }
        }
        
        return result;
    }
}
