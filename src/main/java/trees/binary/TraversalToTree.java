package trees.binary;

public class TraversalToTree {
    public static void main(String[] args) {
        TraversalToTree traversalToTree = new TraversalToTree();
         Node root = traversalToTree.convert("D B E A F C".split(" "), "A B D E C F".split(" "));
//        Node root = traversalToTree.convert(new int[] {4, 8, 10, 12, 14, 20, 22}, new int[] {20, 8, 22, 4, 12, 10, 14}, 0);
        System.out.println(root);
    }

    public Node convert(String [] inOrder, String [] preOrder) {
        return buildTree(inOrder, 0, inOrder.length-1, preOrder, 0, preOrder.length-1);
    }

    public Node buildTree(String [] inOrder, int inStart, int inEnd, String [] preOrder, int preStart, int preEnd) {
        if (inStart > inEnd) {
            return null;
        }

        Node root = new Node(preOrder[preStart]);

        int mid = findMid(inOrder, inStart, inEnd, preOrder[preStart]);
        root.leftChild = buildTree(inOrder, inStart, mid-1, preOrder, preStart+1, preStart + (mid-inStart) );
        root.rightChild = buildTree(inOrder, mid+1, inEnd, preOrder, preStart + (mid-inStart)+1, preEnd);

        return root;
    }

    private int findMid(String [] inOrder, int inStart, int inEnd, String key) {
        for (int i=inStart; i<= inEnd; i++) {
            if (inOrder[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

//    private Node convertFromLevelOrder(int [] inOrder, int [] levelOrder, int start) {
//        return buildTree_1(inOrder, 0, inOrder.length-1, levelOrder);
//    }
//
//    public Node buildTree_1(int [] inOrder, int inStart, int inEnd, int [] levelOrder) {
//        if (inStart > inEnd) {
//            return null;
//        }
//
//        Node root = levelOrder[0];
//
//        int mid = findMid_1(inOrder, inStart, inEnd, levelOrder[levelStart]);
//
//        int [] leftLevelOrder = new int[mid];
//        int [] rightLevelOrder = new int[levelOrder.length-mid];
//
//        int leftIdx = 0;
//        int rightIdx = 0;
//        for (int i =0; i<levelOrder.length; i++) {
//            if (inOrderContains(inOrder, inStart, mid-1, levelOrder[i])) {
//                leftLevelOrder[leftIdx++] = levelOrder[i];
//            } else {
//                rightLevelOrder[rightIdx++] = levelOrder[i];
//            }
//        }
//
//        root.leftChild = buildTree_1(inOrder, inStart, mid-1, leftLevelOrder);
//        root.rightChild = buildTree_2(inOrder, mid+1, inEnd, rightLevelOrder);
//
//        return root;
//    }

    private boolean inOrderContains(int[] inOrder, int start, int end, int key) {
        for (int i=start; i<=end; i++) {
            if (key == inOrder[i]) {
                return true;
            }
        }
        return false;
    }

    private int findMid_1(int [] inOrder, int inStart, int inEnd, int key) {
        for (int i=inStart; i<= inEnd; i++) {
            if (inOrder[i] == key) {
                return i;
            }
        }
        return -1;
    }
}