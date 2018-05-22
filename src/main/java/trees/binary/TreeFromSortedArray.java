package trees.binary;

import linkedlist.LinkedList;

/**
 * Created by ts250370 on 9/13/17.
 */
public class TreeFromSortedArray {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        Node root = createTree(arr, 0, arr.length);
        Tree tree = new Tree();
        tree.root = root;

        Traversal traversal = new Traversal(tree);

        traversal.doInOrder();

        createList(tree);
    }

    static int getMaxDepth(Node node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(getMaxDepth(node.leftChild), getMaxDepth(node.rightChild));
    }


    static void createList(Tree tree) {
            Node start = tree.root;
            LinkedList[] nodesAtHeight = new LinkedList[getMaxDepth(tree.root)];
            preOrder(start, 0, nodesAtHeight);

            for (int i=0; i<nodesAtHeight.length; i++) {
                System.out.println();
                nodesAtHeight[i].print();
            }
    }

    static void preOrder(Node node, int depth, LinkedList[] nodesAtHeight) {
        if(node == null) {
            return;
        }

        if (nodesAtHeight[depth] == null) {
            nodesAtHeight[depth] = new LinkedList();
        }
        nodesAtHeight[depth].insertAtEndOfList(node);

        preOrder(node.leftChild, depth + 1, nodesAtHeight);
        preOrder(node.rightChild, depth + 1, nodesAtHeight);
    }


    static Node createTree(int [] arr, int start, int end) {
        if (start >= end) {
            return null;
        }

        int median = (start + end) / 2;
        Node root = new Node(null);
        root.key = arr[median];
        root.leftChild = createTree(arr, start, median);
        root.rightChild = createTree(arr, median+1, end);

        return root;
    }
}
