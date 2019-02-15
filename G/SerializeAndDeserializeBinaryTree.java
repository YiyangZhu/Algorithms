package G;



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return sb.toString();
    }

    private void helper(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null ");
        } else {
            sb.append(root.val+" ");
            helper(root.left,sb );
            helper(root.right, sb);
        }
    }

    public TreeNode deserialize(String data) {
        String[] node = data.split(" ");
        int[] index = new int[1];
        index[0] = 0;
        return constructNode(node,index);
    }

    private TreeNode constructNode(String[] data, int[] index){
        if(data[index[0]].equals("null")){
            return null;
        } else {
            int value = Integer.parseInt(data[index[0]]);
            TreeNode node = new TreeNode(value);

            index[0]++;
            node.left = constructNode(data, index);

            index[0]++;
            node.right = constructNode(data, index);

            return node;
        }

    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
