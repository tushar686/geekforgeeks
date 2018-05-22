package solutions;

import java.util.LinkedList;

class ConnectNodesAtSameLevel {
    class Node {
        int data;
        Node left, right, nextRight;

        Node(int item) {
        data = item;
        left = right = nextRight = null;
        }
    }

    void createTree() {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);

        root.left.left = new Node(40);
        root.left.right = new Node(60);

        connect(root);
        traverseLevelorder(root);
        System.out.println();

        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(60);

        root.right.left = new Node(70);
        root.left.left = new Node(40);

        connect(root);
        traverseLevelorder(root);
        System.out.println();

        connect_Q(root);
        traverseLevelorder(root);
        System.out.println();

//        traverseInorder(root);
        System.out.println();
        traverseLevelorder(root);
    }

    void traverseInorder(Node root) {
        if (root == null) {
            return;
        }
        traverseInorder(root.left);
        System.out.print(root.data + " ");
        traverseInorder(root.right);
    }

    void traverseLevelorder(Node root) {
        if (root == null) {
            return;
        }
        Node levelRunner = root;
        while (levelRunner != null) {
            System.out.print(levelRunner.data + " ");
            levelRunner = levelRunner.nextRight;
        }

        root = jumptToNextLevel(root);
        traverseLevelorder(root);
    }

    Node jumptToNextLevel(Node prevLevel) {
        if (prevLevel != null) {
            if (prevLevel.left != null) {
                return prevLevel.left;
            }
            if (prevLevel.right != null) {
                return prevLevel.right;
            }
            return jumptToNextLevel(prevLevel.nextRight);
        }
        return null;
    }

    void connect(Node root) {
        if (root == null) {
            return;
        }
        Node left = root.left;
        Node right = root.right;
        if (left != null) {
            left.nextRight = right;
        }
        if (right != null && root.nextRight != null) {
            right.nextRight = root.nextRight.left;
        }
        connect(left);
        connect(right);
    }

    void connect_Q(Node root) {
        java.util.Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node current = q.remove();

            if (current != null) {
                Node top = q.peek();
                current.nextRight = top;

                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }

            } else {
                if (!q.isEmpty()) {
                    q.add(null);
                }
            }

        }
    }

    public static void main (String[] args) {
        ConnectNodesAtSameLevel gfg = new ConnectNodesAtSameLevel();
        gfg.createTree();
    }

}