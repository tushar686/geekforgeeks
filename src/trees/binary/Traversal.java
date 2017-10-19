package trees.binary;

import java.util.Queue;

/**
 * Created by ts250370 on 8/18/17.
 */
public class Traversal {
    Tree tree;

    public Traversal(Tree tree) {
        this.tree = tree;
    }

    public static void main(String[] args) {

    }

    public void doInOrder() {
        Node start = tree.root;
        inOrder(start);
    }
    public void doPreOrder() {
        Node start = tree.root;
        preOrder(start);
    }
    public void doPostOrder() {
        Node start = tree.root;
        postOrder(start);
    }

    public void doLevelOrder() {
        Node start = tree.root;
        int h = calculateHeighOfTree(start, 1);
        System.out.println("Height " + h);
        for (int i=1; i<h; i++) {
            levelOrder(start, i);
        }
    }

    public void doLevelOrder_1() {
        Node start = tree.root;
        Queue q = new ArrayDeque();
        q.add(start);
        levelOrder_1(q);
    }

    private void levelOrder_1(Queue q) {
        Node node = q.poll();
        if (node == null) {
            return;
        }
        processNode(node);
        q.add(node.leftChild);
        q.add(node.rightChild);
        levelOrder_1(q);
    }

    private int calculateHeighOfTree(Node runner, int h) {
        if (runner == null) {
            return h;
        }
        return Math.max(calculateHeighOfTree(runner.leftChild, h+1), calculateHeighOfTree(runner.rightChild, h+1));
    }

    private void levelOrder(Node runner, int h) {
        if (runner == null) {
            return;
        }
        if (h == 1) {
            processNode(runner);
        }
        levelOrder(runner.leftChild, h-1);
        levelOrder(runner.rightChild, h-1);
    }

    private void inOrder(Node node) {
        if(node == null) {
            return;
        }
        inOrder(node.leftChild);
        processNode(node);
        inOrder(node.rightChild);
    }
    private void preOrder(Node node) {
        if(node == null) {
            return;
        }
        processNode(node);
        preOrder(node.leftChild);
        preOrder(node.rightChild);
    }
    private void postOrder(Node node) {
        if(node == null) {
            return;
        }
        postOrder(node.leftChild);
        postOrder(node.rightChild);
        processNode(node);
    }

    private void processNode(Node node) {
        System.out.print(node.key + " ");
    }
}
