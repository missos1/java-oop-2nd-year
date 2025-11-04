import java.util.Stack;

public class PreOrder {
    public static void preOrderRecursive(Node root) {
        System.out.print(root.data + " ");
        
        if (root.left != null) {
            preOrder(root.left);
        }
        if (root.right != null) {
            preOrder(root.right);
        }
    }

    public static void preOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            System.out.print(temp.data + " ");
            
            if (temp.right != null) {
                stack.add(temp.right);
            }
            if (temp.left != null) {
                stack.add(temp.left);
            }
        } 
    }
}
