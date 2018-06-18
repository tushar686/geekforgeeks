package arrays;


import trees.binary.GenerateTreeFromTraversal.TreeNode;

import java.util.*;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<List<TreeNode>> q = new LinkedList<>();
        Stack<List<Integer>> stk = new Stack<>();

        List<TreeNode> list = new LinkedList<>();
        list.add(root);
        q.add(list);

        levelOrder(q, stk);

        List<List<Integer>> result = new LinkedList<>();
        while (!stk.isEmpty()) {
            result.add(stk.pop());
        }

        return result;
    }

    public void levelOrder(Queue<List<TreeNode>> q, Stack<List<Integer>> stk) {
        if (q.isEmpty()) {
            return;
        }

        List<TreeNode> cList = q.remove();
        List<TreeNode> nList = new LinkedList<>();
        List<Integer> stkList = new LinkedList<>();

        for (TreeNode node: cList) {
            if (node != null) {
                stkList.add(node.val);
                if (node.left != null) {
                    nList.add(node.left);
                }
                if (node.right != null) {
                    nList.add(node.right);
                }
            }
        }

        if (nList.size() > 0) {
            q.add(nList);
        }

        if (stkList.size() > 0) {
            stk.add(stkList);
        }

        levelOrder(q, stk);

    }
}