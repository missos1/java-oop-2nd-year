import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class RunningMedian {
    public static List<Double> runningMedian(List<Integer> a) {
        // store 1st smaller half 
        Queue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder()); 
        // store 2nd larger half
        Queue<Integer> minPQ = new PriorityQueue<>();
        
        List<Double> result = new ArrayList<>();
        
        for (int i : a) {
            if (maxPQ.isEmpty() || i <= maxPQ.peek()) {
                maxPQ.add(i);
            } else {
                minPQ.add(i);
            }
            
            // balancing 
            /* example:insert 12 then 4  max {4, 12} -> {4}
            *                            min {}         {12}
            */
            if (maxPQ.size() > minPQ.size() + 1) {
                minPQ.add(maxPQ.poll());
            } else if (minPQ.size() > maxPQ.size() + 1) {
                maxPQ.add(minPQ.poll());
            }
            
            if (maxPQ.size() == minPQ.size()) {
                double n = (double) maxPQ.peek();
                double m = (double) minPQ.peek();
                result.add((m + n) / 2);
            } else if (maxPQ.size() > minPQ.size()) {
                result.add((double) maxPQ.peek());
            } else {
                result.add((double) minPQ.peek());
            }
            
        }
        
        return result;
    }

}
