public class LowestCommonAncestor {
    public static Node lca(Node root, int v1, int v2) {
      	if (root == null) return null;
        
        while (root != null) {
            if (v1 < root.data && v2 < root.data) {
                root = root.left;
            } else if (v1 > root.data && v2 > root.data) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
