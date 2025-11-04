import java.util.ArrayList;
import java.util.List;

public class CountingSort2 {
    public static List<Integer> countingSort(List<Integer> arr) {
        List<Integer> countList = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            countList.add(0);
        }
        
        for (int i : arr) {
            countList.set(i, countList.get(i) + 1);
        }
        
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < countList.size(); i++) {
            int temp = countList.get(i);
            while (temp-- != 0) {
                result.add(i);
            }
        }
        
        return result;
    }
}
