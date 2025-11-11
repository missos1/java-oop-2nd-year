import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ConnectedCells {
    public static int rows;
    public static int cols;
    
    private static boolean isNotValidNode(int i, int j, List<List<Integer>> matrix, List<List<Boolean>> visited) {
        return i < 0 || j < 0 || i >= rows || j >= cols
                || visited.get(i).get(j) 
                || matrix.get(i).get(j) == 0;
    }
    
    public static int dfs(int i, int j, List<List<Integer>> matrix, List<List<Boolean>> visited) {
        if (isNotValidNode(i, j, matrix, visited) ) {
            return 0;
        }
        
        int[] rowoffset = {-1, 0, 1};
        int[] coloffset = {-1, 0, 1};
        
        visited.get(i).set(j, true); // Mark as visited
        int currentSize = 1;         // Count this node   
        
        for (int u : rowoffset) {
            for (int v : coloffset) {
                if (u == 0 && v == 0) continue; 
                int newI = i + u;
                int newJ = j + v;
                
                currentSize += dfs(newI, newJ, matrix, visited);
            }
        }
        
        return currentSize;
    }
    
    public static int bfs(int beginI, int beginJ, List<List<Integer>> matrix, List<List<Boolean>> visited) {
        if (isNotValidNode(beginI, beginJ, matrix, visited)) {
            return 0;
        }
        
        int[] rowoffset = {-1, 0, 1};
        int[] coloffset = {-1, 0, 1};
        
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.add(new int[] {beginI, beginJ});
        visited.get(beginI).set(beginJ, true);
        
        int count = 0;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int i = current[0];
            int j = current[1];

            count++;
            for (int u : rowoffset) {
                for (int v : coloffset) {
                    if (u == 0 && v == 0) continue; 
                   
                    int newI = i + u;
                    int newJ = j + v;
                    if (!isNotValidNode(newI, newJ, matrix, visited)) {
                        queue.add(new int[] {newI, newJ});
                        visited.get(newI).set(newJ, true);
                    }
                }
            }  
        }
        return count; 
    }

    public static int connectedCell(List<List<Integer>> matrix) {
        rows = matrix.size();
        cols = matrix.get(0).size();
        
        List<List<Boolean>> visited = new ArrayList<>();
        
        for (int i = 0; i < rows; i++) {
            List<Boolean> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add(false);
            }
            visited.add(row);
        }
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // max = Math.max(max, dfs(i, j, matrix, visited));
                max = Math.max(max, bfs(i, j, matrix, visited));
            }
        }
        
        return max;
    }
}