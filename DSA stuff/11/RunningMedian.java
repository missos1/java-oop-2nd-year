import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class RunningMedian {
    static class NumberWithIndex implements Comparable<NumberWithIndex> {
        int value;
        int index;

        NumberWithIndex(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(NumberWithIndex other) {
            if (this.value != other.value) {
                return Integer.compare(this.value, other.value);
            }
            return Integer.compare(this.index, other.index);
        }
    }

    public static List<Double> runningMedian(List<Integer> a) {
        List<Double> medians = new ArrayList<>();
        TreeSet<NumberWithIndex> lower = new TreeSet<>(); // smaller half (max heap equivalent)
        TreeSet<NumberWithIndex> upper = new TreeSet<>(); // larger half (min heap equivalent)
        
        for (int i = 0; i < a.size(); i++) {
            int num = a.get(i);
            NumberWithIndex element = new NumberWithIndex(num, i);
            
            // Add to appropriate set
            if (lower.isEmpty() || num <= lower.last().value) {
                lower.add(element);
            } else {
                upper.add(element);
            }
            
            if (lower.size() > upper.size() + 1) {
                upper.add(lower.pollLast());
            } else if (upper.size() > lower.size() + 1) {
                lower.add(upper.pollFirst());
            }
            
            if (lower.size() == upper.size()) {
                double median = (lower.last().value + upper.first().value) / 2.0;
                medians.add(median);
            } else if (lower.size() > upper.size()) {
                medians.add((double) lower.last().value);
            } else {
                medians.add((double) upper.first().value);
            }
        }
        
        return medians;
    }
}
