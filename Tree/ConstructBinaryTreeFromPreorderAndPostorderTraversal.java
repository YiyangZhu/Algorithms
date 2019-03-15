package Tree;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre.length == 0) {
            return null;
        }

        if (pre.length == 1) {
            return new TreeNode(pre[0]);
        }

        TreeNode root = new TreeNode(pre[0]);
        int n = pre.length;
        int i = 1;
        int j = n - 2;

        if (pre[i] == post[j]) {
            int[] pre1 = new int[n - 1];
            int[] post1 = new int[n - 1];
            for (int a = 0; a < n - 1; a++) {
                pre1[a] = pre[a + 1];
            }
            for (int a = 0; a < n - 1; a++) {
                post1[a] = post[a];
            }
            root.left = constructFromPrePost(pre1, post1);
            return root;
        } else {
            
            int k1;
            for (k1 = 1; k1 < n; k1++) {
                if (pre[k1] == post[j]) {
                    break;
                }
            }
            int[] leftPre = new int[k1 - 1];
            int[] rightPre = new int[n - k1];
            for (int a = 0; a < leftPre.length; a++) {
                leftPre[a] = pre[a + 1];
            }
            for (int a = 0; a < rightPre.length; a++) {
                rightPre[a] = pre[a + k1];
            }

            int k2;
            for (k2 = 0; k2 < n - 2; k2++) {
                if (post[k2] == pre[i]) {
                    break;
                }
            }

            int[] leftPost = new int[k2 + 1];
            int[] rightPost = new int[n - 2 - k2];
            for (int a = 0; a < leftPost.length; a++) {
                leftPost[a] = post[a];
            }
            for (int a = 0; a < rightPost.length; a++) {
                rightPost[a] = post[a + k2 + 1];
            }

            root.left = constructFromPrePost(leftPre, leftPost);
            root.right = constructFromPrePost(rightPre, rightPost);
        }

        return root;
    }
}
