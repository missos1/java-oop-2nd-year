import java.util.List;

public class Intro {
     public static int introTutorial(int V, List<Integer> arr) {
        return binarySearch(V, arr);
    }
    
    private static int binarySearch(int V, List<Integer> arr) {
        int high = arr.size() - 1;
        int low = 0;
        
        while (high > low) {
            if (arr.get(high) == V) return high;
            if (arr.get(low) == V) return low;
            int mid = low + ((high - low) / 2); // avoid integer overflow
            if (arr.get(mid) > V) high = mid - 1;  
            else if (arr.get(mid) < V) low = mid + 1;
            else return mid;
        }
        return -1;
    }
}
