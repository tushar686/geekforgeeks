package trees.binary;

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

    private void inOrder(Node node) {
        if(node == null) {
            return;
        }
        inOrder(node.leftChild);
        processNode(node);
        inOrder(node.righChild);
    }
    private void preOrder(Node node) {
        if(node == null) {
            return;
        }
        processNode(node);
        preOrder(node.leftChild);
        preOrder(node.righChild);
    }
    private void postOrder(Node node) {
        if(node == null) {
            return;
        }
        postOrder(node.leftChild);
        postOrder(node.righChild);
        processNode(node);
    }

    private void processNode(Node node) {
        System.out.print(node.key + " ");
    }
}
