import java.util.PriorityQueue;
import java.util.Queue;

public class Cookies {
    public static int cookies(int k, List<Integer> A) {
        Queue<Integer> pQueue = new PriorityQueue<>(A); // min-heap priority queue
        int iteration = 0;
        
        while (pQueue.size() > 1) {
            if (pQueue.peek() >= k) {
                return iteration; // all cookies are sweet enough
            }
            int m1 = pQueue.poll(); // least sweet cookie
            int m2 = pQueue.poll(); // second least sweet cookie
            pQueue.add(m1 + m2 * 2); // combine cookies
            iteration++; // increment operation count
        }
        
        if (pQueue.peek() >= k) { // check if last cookie is sweet enough
            return iteration;
        }
        
        return -1;
    }
}
