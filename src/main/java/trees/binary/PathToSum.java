package trees.binary;

/**
 * Created by ts250370 on 6/9/18.
 */
public class PathToSum {

    public static void main(String[] args) {
        PathToSum pathToSum = new PathToSum();
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(4);
//        root.left.left = new TreeNode(11);
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(2);
//
//        root.right = new TreeNode(8);
//        root.right.left = new TreeNode(13);
//        root.right.right = new TreeNode(4);
//        root.right.right.right = new TreeNode(1);
//        System.out.println(pathToSum.hasPathSum(root, 22)); //true

//        TreeNode root = new TreeNode(-2);
//        root.right = new TreeNode(-3);
//        System.out.println(pathToSum.hasPathSum(root, -5)); //true

        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(-1);
        root.left.right = new TreeNode(-6);
        root.left.left.right = new TreeNode(1);
        root.left.left.right.left = new TreeNode(-7);

        System.out.println(pathToSum.hasPathSum(root, 0)); //true


    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        return preOrderTraversal(root, root.val, sum);
    }

    private boolean preOrderTraversal(TreeNode root, int sum, int targetSum) {
        if (root.left == null && root.right == null && sum == targetSum) {
            return true;
        }
        if (root.left == null && root.right == null && sum != targetSum) {
            return false;
        }

        boolean leftPathSum = root.left != null ? preOrderTraversal(root.left, sum + root.left.val, targetSum) : false;
        boolean rightPathSum = root.right != null ? preOrderTraversal(root.right, sum + root.right.val, targetSum) : false;

        return leftPathSum || rightPathSum;
    }
}
