public class HeightOfBinTree {
    public static int height(Node root) {
        if (root == null) return -1;
      	
        int left_subheight = 1 + height(root.left);
        
        int right_subheight = 1 + height(root.right);
        
        return Math.max(left_subheight, right_subheight);
    }
}
