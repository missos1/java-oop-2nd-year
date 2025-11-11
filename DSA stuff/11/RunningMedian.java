import java.util.List;
import java.util.Set;

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
            if (this.value == other.value) {
                return Integer.compare(this.value, other.value);
            }
            return Integer.compare(this.index, other.index);
        }
    }

    public static List<Double> runningMedian(List<Integer> a) {
        List<Double> medians = new ArrayList<>();
        TreeSet<NumberWithIndex> numberSet = new TreeSet<>();
        return medians;
    }
}
