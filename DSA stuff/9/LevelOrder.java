import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOrder {
    public static void levelOrder(Node root) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int currentSize = q.size();
            for (int i = 0; i < currentSize; i++) {
                Node temp = q.poll();
                System.out.print(temp.data + " ");
                if (temp.left != null) q.offer(temp.left);
                if (temp.right != null) q.offer(temp.right);
            }
        }
    }
}