package trees.binary;


import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DeleteNodeFromBST {
    int maxHeightClassLevel = 0;
    Map<Integer, Map<Set, Integer>> preCalculatedHeightsFromRootToDifferentPaths = new HashMap<>();

    public static void main(String[] args) {
        long start = Calendar.getInstance().getTimeInMillis();
        DeleteNodeFromBST solution = new DeleteNodeFromBST();

//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(3);
//        root.right = new TreeNode(6);
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(4);
//        root.right.right = new TreeNode(7);

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);

        solution.print(root);
        TreeNode newRoot = solution.deleteNode(root, 2);
        System.out.println();
        solution.print(newRoot);

    }

    private void print(TreeNode root) {
        if (root == null)
            return;
        else {
            System.out.print(root.val + " ");
            print(root.left);
            print(root.right);
        }

    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val == key && root.left == null && root.right == null) {
            return null;
        }

        TreeNode[] nodes = search(key, root, root);
        if (nodes == null) {
            return root;
        }
        TreeNode node = nodes[0];
        TreeNode parent = nodes[1];
        if (node == null) {
            return root;
        }

        //leaf node; just delete it
        if (node.left == null && node.right == null) {
            if (parent.left != null && parent.left.val == node.val) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            return root;
        }

        //left node is not null so find leftSuccessor
        if (node.left != null) {
            TreeNode leftSuccessor = findLeftSuccessor(node.left);
            node.val = leftSuccessor.val;
            leftSuccessor.val = key;
            return deleteNode(root, key);
        }

        //left node is null but right node is not null so find rightSuccessor
        if (node.right != null) {
            TreeNode rightSuccessor = findRightSuccessor(node.right);
            node.val = rightSuccessor.val;
            rightSuccessor.val = key;
            return deleteNode(root, key);
        }

        return root;
    }

    private TreeNode findLeftSuccessor(TreeNode leftSuccessor) {
        if (leftSuccessor.right == null) {
            return leftSuccessor;
        }
        return findLeftSuccessor(leftSuccessor.right);

    }

    private TreeNode findRightSuccessor(TreeNode rightSuccessor) {
        if (rightSuccessor.left == null) {
            return rightSuccessor;
        }
        return findRightSuccessor(rightSuccessor.left);

    }

    private TreeNode[] search(int key, TreeNode root, TreeNode parent) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            return new TreeNode[] {root, parent};
        }

        TreeNode[] nodes = search(key, root.left, root);
        if (nodes != null) {
            return nodes;
        }

        nodes = search(key, root.right, root);
        if (nodes != null) {
            return nodes;
        }

        return null;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}