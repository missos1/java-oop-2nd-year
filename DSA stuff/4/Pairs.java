import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pairs {
    public static int pairs(int k, List<Integer> arr) {
        Set<Integer> myset = new HashSet<>();
        for (int i = 0; i < arr.size(); i++) {
            myset.add(arr.get(i));
        }
        
        int count = 0;
        for (int i : myset) {
            if (myset.contains(i - k)) count++;
        }
        return count;
    }
}
