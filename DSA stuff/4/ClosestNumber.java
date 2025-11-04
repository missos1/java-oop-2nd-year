import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClosestNumber {
    public static List<Integer> closestNumbers(List<Integer> arr) {
        Collections.sort(arr);
        int mindiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.size() - 1; i++) {
            if (Math.abs(arr.get(i+1) - arr.get(i)) < mindiff) {
                mindiff = Math.abs(arr.get(i+1) - arr.get(i));
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < arr.size() - 1; i++) {
            if (Math.abs(arr.get(i+1) - arr.get(i)) == mindiff) {
                result.add(arr.get(i));
                result.add(arr.get(i+1));
            }
        }
        
        return result;
    }
}
