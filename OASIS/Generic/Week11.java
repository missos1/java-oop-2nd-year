import java.util.List;

public interface Week11<T extends Comparable<T>> {
    /**
     * Generic insertion sort.
     * 
     * @param list generic list
     * @return sorted list
     */
    default List<T> sortGeneric(List<T> list) {
        for (int i = 1; i < list.size(); i++) {
            T value = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).compareTo(value) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, value);
        }

        return list;
    }
} 
