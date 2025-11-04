import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BfsShortest {
    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        List<List <Integer>> adjList = new ArrayList<>(n + 1);

        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        //  convert egdes to adjList
        // example: edges {1,2}, {2,3}, {3,1}
        for (List<Integer> edge : edges) {  
            int u = edge.get(0); // got 1, 2 ,3
            int v = edge.get(1); // got 2, 3 ,1
            adjList.get(u).add(v); // list at key 1 added 2, list at key 2 added 3, etc
            adjList.get(v).add(u); // reverse because undirected graph
        }

        int[] distances = new int[n + 1]; // extra space cuz we dont use 0
        Arrays.fill(distances, -1); // mark all node as unvisited (those can't be visited will remain -1)

        distances[s] = 0; // distance to self is 0

        Queue<Integer> queue = new ArrayList<>();
        queue.offer(s); // enqueue the start node

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int adjNode : adjList.get(current)) { // for each adjNode
                if (distances[adjNode] == -1) { // if unreached
                    distances[adjNode] = distances[current] + 6; // now reach 
                    queue.offer(adjNode); 
                }
            }
        }
        
        List<Integer> result = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (s != i) {
                result.add(distances[i]);
            }
        }

        return result;
    }
}
