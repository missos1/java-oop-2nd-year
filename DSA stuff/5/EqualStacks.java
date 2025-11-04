import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class EqualStacks {
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        int totalH1 = sumofList(h1);
        int totalH2 = sumofList(h2);
        int totalH3 = sumofList(h3);
        
        int min = Math.min(totalH1, Math.min(totalH2, totalH3));
        
        Collections.reverse(h1);
        Collections.reverse(h2);
        Collections.reverse(h3);
        
        Stack<Integer> stackH1 = new Stack<>();
        Stack<Integer> stackH2 = new Stack<>();
        Stack<Integer> stackH3 = new Stack<>();
        
        stackH1.addAll(h1);
        stackH2.addAll(h2);
        stackH3.addAll(h3);
        
        while (min > 0) {
            if (totalH1 == totalH2 && totalH2 == totalH3) {
                return min;
            }
            if (totalH1 > min) {
                totalH1 -= stackH1.pop();
            }
            if (totalH2 > min) {
                totalH2 -= stackH2.pop();
            }
            if (totalH3 > min) {
                totalH3 -= stackH3.pop();
            }
            min = Math.min(totalH1, Math.min(totalH2, totalH3));
        }
        return 0;
    }
}
