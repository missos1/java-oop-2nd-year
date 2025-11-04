public class InsertBST {
    public static Node insert(Node root,int data) {
        // if (root == null) {
        //     return new Node(data);
        // }
        
        // if (data < root.data) root.left = insert(root.left, data);
        // else root.right = insert(root.right, data); 
    	// return root;
        
        Node temp = new Node(data);
        if (root == null) return temp;
        
        Node curr = root;
        
        while (curr != null) {
            if (data > curr.data && curr.right != null) {
                curr = curr.right;
            } else if (data < curr.data && curr.left != null) {
                curr = curr.left;
            } else {
                break;
            }
        }
        
        if (curr.data > data) {
            curr.left = temp;
        } else {
            curr.right = temp;
        }
        
        return root;
    }
}
