package graphs;

import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;

public class Height {
    static class Node {
        Node left;
        Node right;
        int key;

        Node(int key) {
            this.key = key;
        }
    }

    static void printLevelOrder(Node root, int level) {
        if (level == 1) {
            if (root != null) {
                System.out.println(root.key);
            }
            return;
        }
        printLevelOrder(root.left, level-1);
        printLevelOrder(root.right, level-1);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.right = new Node(8);

        int h = findHeight(root);
        System.out.println(h);
        for (int level=1; level<=h; level++) {
            printLevelOrder(root, level);
        }
    }

	private static int findHeight(Node root) {
        if (root == null) {
            return 0;
        }

        int lh = 1 + findHeight(root.left);
        int rh = 1 + findHeight(root.right);

        return Math.max(lh, rh);
	}
}