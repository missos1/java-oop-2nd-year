public class IsThisBST {
    boolean checkBST(Node root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean isBSTUtil(Node node, int min, int max) {
        // empty tree is BST
        if (node == null) {
            return true;
        }

        // false if this node violates the min/max constraint
        if (node.data < min || node.data > max) {
            return false;
        }

        // check the subtrees recursively tightening the min/max constraints
        return (isBSTUtil(node.left, min, node.data - 1) &&
                isBSTUtil(node.right, node.data + 1, max));
    }
}
