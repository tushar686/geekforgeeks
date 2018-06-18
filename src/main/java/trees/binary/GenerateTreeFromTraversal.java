package trees.binary;


import java.util.*;

public class GenerateTreeFromTraversal {
    int maxHeightClassLevel = 0;
    Map<Integer, Map<Set, Integer>> preCalculatedHeightsFromRootToDifferentPaths = new HashMap<>();

    public static void main(String[] args) {
        long start = Calendar.getInstance().getTimeInMillis();
        GenerateTreeFromTraversal solution = new GenerateTreeFromTraversal();

        TreeNode root = solution.buildTree(new int[]{3,9,21,22,20,15,7}, new int[]{21,9,22,3,15,20,7});
//        TreeNode root = solution.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        System.out.println(root.val);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0 || inorder.length == 0 ) {
            return null;
        }

        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);

        int rootPosInsideInOrder = getRootPos(rootVal, inorder);
        int[] leftInOrder = Arrays.copyOfRange(inorder, 0, rootPosInsideInOrder);
        int[] rightInOrder = Arrays.copyOfRange(inorder, rootPosInsideInOrder+1, inorder.length);

        int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, leftInOrder.length+1);
        int[] rightPreOrder = Arrays.copyOfRange(preorder, leftPreOrder.length+1, preorder.length);

        root.left = buildTree(leftPreOrder, leftInOrder);
        root.right = buildTree(rightPreOrder, rightInOrder);

        return root;
    }

    private int getRootPos(int rootVal, int[] inorder) {
        for (int i = 0; i<inorder.length; i++) {
            if (inorder[i] == rootVal) {
                return i;
            }
        }
        return 0;
    }

    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

}