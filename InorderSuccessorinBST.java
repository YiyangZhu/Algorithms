import java.util.Arrays;
import java.util.HashMap;

public class InorderSuccessorinBST {
    public class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(){

        }
        public TreeNode(int value){
            val = value;
        }
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null){
            return null;
        }
        HashMap<Integer, TreeNode> map = new HashMap<>();
        inorderMap(map,root);
        int[] values = new int[map.size()];
        int i = 0;
        for(int key: map.keySet()){
            values[i] = key;
            i++;
        }
        Arrays.sort(values);
        for(int j = 0; j < values.length-1;j++){
            if(p.val == values[j]){
                return map.get(values[j+1]);
            }
        }
        return null;

    }

    public void inorderMap(HashMap<Integer, TreeNode> map,TreeNode root){
        if(root == null){
            return;
        }
        inorderMap(map,root.left );
        map.put(root.val,root);
        inorderMap(map,root.right );

    }
}
