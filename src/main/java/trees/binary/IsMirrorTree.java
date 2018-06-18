package trees.binary;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ts250370 on 6/4/18.
 */
public class IsMirrorTree {

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(2);
//
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(3);


        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);

        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);
        root.right.left.left = new TreeNode(9);
        root.right.left.right = new TreeNode(8);





        IsMirrorTree isMirrorTree = new IsMirrorTree();

        System.out.println(isMirrorTree.isSymmetric(root));
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<LinkedList<TreeNode>> q = new ArrayDeque<>();

        LinkedList<TreeNode> currentLevelNodes = new LinkedList<>();
        currentLevelNodes.add(root.left);
        currentLevelNodes.add(root.right);
        q.add(currentLevelNodes);

        return isSymmetricRec(q);
    }

    public boolean isSymmetricRec(Queue<LinkedList<TreeNode>> q) {
        if (q.isEmpty()) {
            return true;
        }

        LinkedList<TreeNode> currentLevelNodes = q.poll();
        LinkedList<TreeNode> nextLevelNodes = new LinkedList<>();

        String levelStr = "";
        String levelStrRev = "";
        while (!currentLevelNodes.isEmpty()) {
            TreeNode node = currentLevelNodes.remove();
            if (node != null) {
                levelStr += node.val;
                levelStrRev = node.val + levelStrRev;
                nextLevelNodes.add(node.left);
                nextLevelNodes.add(node.right);
            } else {
                levelStr += "n"; //n = null
                levelStrRev = "n" + levelStrRev;
            }
        }

        if (!levelStr.equals(levelStrRev)) {
            return false;
        }

        if (!nextLevelNodes.isEmpty()) {
            q.add(nextLevelNodes);
        }

        return isSymmetricRec(q);
    }
}
