package linkedlist;

/**
 * Created by ts250370 on 5/21/18.
 */
public class DLLConverBTree {

    class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    Node head;
    Node prev;

    Node createTree() {
        Node root = new Node(1);

        root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.left.right = new Node(5);
        root.left.right = new Node(10);
        root.right = new Node(9);
        root.right.left = new Node(6);
        root.right.right = new Node(12);

        return root;
    }

    void displayList() {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.right;
        }
        System.out.println();
    }

    void converToDLL(Node root) {
        inOrderUtil(root);
    }

    void inOrderUtil(Node root) {
        if (root == null) {
            return;
        }

        inOrderUtil(root.left);

        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        inOrderUtil(root.right);

    }

    public static void main(String[] args) {
        DLLConverBTree dllConverBTree = new DLLConverBTree();
        Node root = dllConverBTree.createTree();
        dllConverBTree.converToDLL(root);
        dllConverBTree.displayList();
    }
}
