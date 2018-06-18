package trees.binary;

/**
 * Created by ts250370 on 6/8/18.
 */
public class MinDepthBinaryTree {

    public static void main(String[] args) {
        MinDepthBinaryTree minDepthBinaryTree = new MinDepthBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        int minDepth = minDepthBinaryTree.minDepth(root);
        System.out.println(minDepth);
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return minDepthUtil(root, 1);
    }

    public int minDepthUtil(TreeNode root, int depth) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.left == null && root.right == null) {
            return depth;
        }

        int minDepth = Math.min(minDepthUtil(root.left, depth+1), minDepthUtil(root.right, depth+1));
        return minDepth;
    }

}
