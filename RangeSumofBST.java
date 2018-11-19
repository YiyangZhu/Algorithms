import java.util.ArrayList;
import java.util.List;

public class RangeSumofBST {
    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(18);
        rangeSumBST(root,root.left.right.val ,root.right.val);
    }

    public static void rangeSumBST(TreeNode root, int L, int R) {


        List<Integer> list1 = new ArrayList<>();
        inorder(root,list1);
        int index1 = list1.indexOf(L);
        int index2 = list1.indexOf(R);
        System.out.println(index1);
        System.out.println(index2);
        System.out.println(list1);
        int sum = 0;
        for(int i = index1;i <= index2;i++){
            sum += list1.get(i);
        }
        System.out.println(sum);

    }

    public static void inorder(TreeNode node, List<Integer> list1){
        if(node == null){
            return;
        }
        inorder(node.left,list1 );
        list1.add(node.val);
        inorder(node.right,list1 );
    }

}
