package trees.twofour;

/**
 * Created by ts250370 on 8/23/17.
 */
public class TwoFourTree {
    Node root;

    public void insert(int key, Object data) {
        Node insertIntoThisNode;
        if (root == null) {
            root = new Node(4);
            insertIntoThisNode = root;
        } else {
            insertIntoThisNode = whereToInsert(key, root, null);
        }

        System.out.println(key);
        System.out.println("InsertInto: " + insertIntoThisNode);
        insertIntoNode(key, data, insertIntoThisNode);
        System.out.println("Inserted: " + insertIntoThisNode);
    }

    public void traverse() {
        traverse(root);
    }

    private void traverse(Node node) {
        if (node == null) {
            return;
        }
        traverse(node.children[0]);
        if (node.subNodes[0] != null)
            System.out.print(node.subNodes[0] + " ");
        traverse(node.children[1]);
        if (node.subNodes[1] != null)
            System.out.print(node.subNodes[1] + " ");
        traverse(node.children[2]);
        if (node.subNodes[2] != null)
            System.out.print(node.subNodes[2] + " ");
        traverse(node.children[3]);
    }

    private void insertIntoNode(int key, Object data, Node node) {
        node.subNodes[node.countOfSubNodes++] = new SubNode(key, data);
        node.sortSubNodes();
    }

    private Node whereToInsert(int key, Node node, Node parent) {
        if (node == null) {
            return parent;
        }
        if (isNodeFull(node)) {
            System.out.println("Node is Full " + node);
            System.out.println("Parent " + parent);
            node = splitNode(node, parent);
            System.out.println("start here " + node);
            parent = node.parent;
            System.out.println("Parent " + parent);
        }
        if (key < node.subNodes[0].key) {
            return whereToInsert(key, node.children[0], node);
        } else {
            Node child = null;
            if (isBetween(key, node.subNodes[0], node.subNodes[1])) {
                child = node.children[1];
            } else if (isBetween(key, node.subNodes[1], node.subNodes[2])) {
                child = node.children[2];
            } else if (key > node.subNodes[2].key) {
                child = node.children[3];
            }
            return whereToInsert(key, child, node);
        }
    }

    private Node splitNode(Node node, Node parent) {
        Node newNode = new Node(4);
        node.rightSibling = newNode;
        newNode.leftSibling = node;

        //C to new node
        newNode.subNodes[newNode.countOfSubNodes++] = node.subNodes[2]; 
        node.subNodes[2] = null;
        node.countOfSubNodes--;

        //move B to parent of node beign split
        if (parent == null) { //create new root
            Node newRoot = new Node(4);
            newRoot.children[newRoot.countOfChildren++] = node;
            node.parent = newRoot;
            root = newRoot;
            parent = newRoot;
        } 
        parent.subNodes[parent.countOfSubNodes++] = node.subNodes[1];
        node.subNodes[1] = null;
        node.countOfSubNodes--;

        parent.children[parent.countOfChildren++] = newNode;
        newNode.parent = parent;

        //keep A to orignal node
        //nothing to do; A is already at right place in node beign split

        parent.sortSubNodes();

        return parent;
    }

    private boolean isNodeFull(Node node) {
        if (node != null && node.countOfSubNodes == 3) { // all subnodes are occupied; there is no space in this node
            return true;
        }
        return false;
    }

    private boolean isBetween(int key, SubNode subnode_1, SubNode subNode_2) {
        if (key > subnode_1.key && (subNode_2 == null || key < subNode_2.key)) {
            return true;
        }
        return false;
    }

}
