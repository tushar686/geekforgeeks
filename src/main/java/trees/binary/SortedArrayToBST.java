package trees.binary;


import java.util.Arrays;

public class SortedArrayToBST {

    public static void main(String[] args) {
        SortedArrayToBST solution = new SortedArrayToBST();
        solution.sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }

        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);

        buildBTree(root, Arrays.copyOfRange(nums, 0, mid), Arrays.copyOfRange(nums, mid+1, nums.length));

        System.out.println(root.val);

        return root;
    }

    private void buildBTree(TreeNode root, int[] nums_1, int[] nums_2) {

        if (nums_1 != null && nums_1.length > 0) {
            if (nums_1.length == 1) {
                root.left = new TreeNode(nums_1[0]);
            } else {
                int mid = nums_1.length / 2;
                root.left = new TreeNode(nums_1[mid]);
                buildBTree(root.left, Arrays.copyOfRange(nums_1, 0, mid), Arrays.copyOfRange(nums_1, mid+1, nums_1.length));
            }
        }

        if (nums_2 != null && nums_2.length > 0) {
            if (nums_2.length == 1) {
                root.right = new TreeNode(nums_2[0]);
            } else {
                int mid = nums_2.length / 2;
                root.right = new TreeNode(nums_2[mid]);
                buildBTree(root.right, Arrays.copyOfRange(nums_2, 0, mid), Arrays.copyOfRange(nums_2, mid+1, nums_2.length));
            }
        }

    }
}