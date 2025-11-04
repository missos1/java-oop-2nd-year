import java.util.ArrayList;
import java.util.List;

public class Arrays {
    public static List<Integer> reverseArray(List<Integer> a) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < a.size(); i++) {
            result.add(i, a.get(a.size() - 1 - i));
        } 
        return result;
    }
}
