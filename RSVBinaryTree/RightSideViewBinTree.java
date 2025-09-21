import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideViewBinTree {
    public static void main(String[] args) {
        tre root = new tre();
        root.data = 10;
        root.left = new tre();
        root.left.data = 6;
        root.right = new tre();
        root.right.data = 15;
        root.left.left = new tre();
        root.left.left.data = 3;
        root.left.left.left = new tre();
        root.left.left.left.data = 30;
        root.left.right = new tre();
        root.left.right.data = 8;
        root.left.right.left = new tre();
        root.left.right.left.data = 19;
        root.right.right = new tre();
        root.right.right.data = 20;

        for (int i : RSVBT(root)) {
            System.out.print(i + " ");
        }
    }

    public static List<Integer> RSVBT(tre root) {
        if (root == null) {
            return Collections.emptyList();
        }

        Queue<tre> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        q.add(root);
        

        while (!q.isEmpty()) {
            int len = q.size();
            List<Integer> currlv_candidates = new ArrayList<>();
            
            for (int i = 0; i < len; i++) {
                tre check = q.poll();
                currlv_candidates.add(check.data);

                if (check.right != null) {
                    q.add(check.right);
                }
                if (check.left != null) {
                    q.add(check.left);
                }
            }

            result.add(currlv_candidates.get(0));
        }
        return result;
    }
}


