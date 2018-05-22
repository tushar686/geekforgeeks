package trees.binary;

/**
 * Created by ts250370 on 9/13/17.
 */
public class IsBalancedTree {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(null, 18);
        tree.insert(null, 16);
        tree.insert(null, 15);
        tree.insert(null, 17);
        tree.insert(null, 24);
        tree.insert(null, 38);
        tree.insert(null, 40);

        int maxDepth = maxDepth(tree.root);
        int minDepth = minDepth(tree.root);

        System.out.println(maxDepth + " " + minDepth);
        System.out.println(maxDepth - minDepth <= 1);
    }

    private static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.leftChild), maxDepth(root.rightChild));
    }

    private static int minDepth(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.min(minDepth(root.leftChild), minDepth(root.rightChild));
    }
}
