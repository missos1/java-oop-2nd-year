import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MissingNumber {
    public static List<Integer> missingNumbers1(List<Integer> arr, List<Integer> brr) {
        Map<Integer, Integer> brrCount = new HashMap<>();
        Map<Integer, Integer> arrCount = new HashMap<>();
        
        for (int num : brr) {
            brrCount.put(num, brrCount.getOrDefault(num, 0) + 1);
        }
        
        for (int num : arr) {
            arrCount.put(num, arrCount.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> miss = new ArrayList<>();
        
        for (int num : brrCount.keySet()) {
            int brrCnt = brrCount.get(num);
            int arrCnt = arrCount.getOrDefault(num, 0);
            
            if (brrCnt > arrCnt) {
                miss.add(num);
            }
        }
        
        Collections.sort(miss);
        return miss;
    }

     public static List<Integer> missingNumbers2(List<Integer> arr, List<Integer> brr) {
        Map<Integer, Integer> brrCount = new HashMap<>();
        Map<Integer, Integer> arrCount = new HashMap<>();
        // brr always has equal or larger size 
        for (int num : brr) { // O(m)
            brrCount.put(num, brrCount.getOrDefault(num, 0) + 1);
        }
        
        for (int num : arr) { // O(n) with n <= m 
            arrCount.put(num, arrCount.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> miss = new ArrayList<>();
        
        for (int num : brrCount.keySet()) { // O(k) with k is the key count
            int brrCnt = brrCount.get(num);
            int arrCnt = arrCount.getOrDefault(num, 0);
            
            if (brrCnt > arrCnt) {
                miss.add(num);
            }
        }
        
        Collections.sort(miss);
        /* O(k log k) and will be O(m log m + n log n) worst
        case */ 
        return miss;
    }

    public static List<Integer> missingNumbers3(List<Integer> arr, List<Integer> brr) {
        Collections.sort(brr); // m log m
        Collections.sort(arr); // n log n

        Set<Integer> miss = new TreeSet<>();
        
        int i = 0;
        int j = 0;
        
        while (i < arr.size() && j < brr.size()) { // m + n
            if (!arr.get(i).equals(brr.get(j))) {
                miss.add(brr.get(j));
                j++;
            } else {
                i++;
                j++;
            }
        }
        
        while (j < brr.size()) { // 
            miss.add(brr.get(j));
            j++;
        }
        
        return new ArrayList<>(miss);
    }

}
