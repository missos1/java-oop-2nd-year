import java.util.List;

public class Sherlock {
    public static String balancedSums(List<Integer> arr) {
        int total = 0;
        for (int i = 0; i < arr.size(); i++) {
            total += arr.get(i);
        }
        
        int leftsum = 0;
        for (int i = 0; i < arr.size(); i++) {
            int rightsum = total - leftsum - arr.get(i);
            if (rightsum == leftsum) {
                return "YES";
            }
            leftsum += arr.get(i);
        }
        return "NO";
    }
}
