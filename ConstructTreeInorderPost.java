public class ConstructTreeInorderPost {
    public static void main(String[] args) {
        int[] inorder = {4, 2, 5, 1, 6, 7, 3, 8};
        int[] postorder = {4, 5, 2, 6, 7, 8, 3, 1};
        TreeNode r = buildTree(inorder, postorder);
        inorder(r);
    }

    public static void inorder(TreeNode root){
        if(root == null){
            return;
        }
        printInorder(root);
    }
    public static void printInorder(TreeNode root){
        if(root == null){
            return;
        }
        printInorder(root.left);
        System.out.println(root.val);
        printInorder(root.right);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null){
            return null;
        }
        int inStart = 0;
        int inEnd = inorder.length - 1;
        int postStart = 0;
        int postEnd = postorder.length - 1;
        return buildTree(inorder,inStart ,inEnd ,postorder ,postStart ,postEnd );
    }

    public static TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if(inStart > inEnd || postStart > postEnd){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int k = 0;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == root.val){
                k = i;
                break;
            }
        }
        root.left = buildTree(inorder,inStart,k - 1,postorder,postStart ,postStart + k - inStart - 1);
        root.right = buildTree(inorder,k+1,inEnd,postorder,postStart + k - inStart,postEnd-1);
        return root;
    }
}
