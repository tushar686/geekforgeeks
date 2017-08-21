package trees.binary;

/**
 * Created by ts250370 on 8/17/17.
 */
public class Tree {

    Node root;

    public void insert(Object data, int key) {
        if (root == null) {
            root = createNewNode(data, key);
        } else {
            insertNewNode(root, createNewNode(data, key));
        }
    }

    private void insertNewNode(Node current, Node newNode) {
        if (current == null) {
            return;
        }
        if (newNode.key <= current.key) {
            insertNewNode(current.leftChild, newNode);
            if (newNode.parent == null) {
                current.leftChild = newNode;
            }
        } else {
            insertNewNode(current.righChild, newNode);
            if (newNode.parent == null) {
                current.righChild = newNode;
            }
        }
        if (newNode.parent == null) {
            newNode.parent = current;
        }
    }

    private Node createNewNode(Object data, int key) {
        Node node = new Node(data);
        node.key = key;
        return node;
    }

    public Node find(int key) {
        return find(key, root);
    }

    private Node find(int key, Node node) {
        if (node == null) {
            return null;
        }
        if(key == node.key) {
            return node;
        }
        if (key <= node.key) {
            return find(key, node.leftChild);
        } else {
            return find(key, node.righChild);
        }
    }

    public boolean delete(int key) {
        Node node = find(key);
        if (node != null) {
            if (isLeafNode(node) && isRootNode(node)) { //Tree with only root node
                root = null;
                return true;
            }

            if (isLeafNode(node)) { //no child
                detachFromParent(node);
                return true;
            }

            if (node.leftChild == null || node.righChild == null) { //single child (left or right); each may have their own subtree
                Node child;
                if (node.leftChild == null) {
                    child = node.righChild;
                } else {
                    child = node.leftChild;
                }

                reArrangeSingleChild(node, child);
                return true;
            }

            Node successor = successor(node);   //Have both child; each may have their own subtree
            reArrangeSuccesor(node, successor);

        }
        return false;
    }


    private void reArrangeSuccesor(Node node, Node successor) {
        if (successor.righChild == null) {
            if (node.parent == null) { //for root node
                root = successor;
                root.parent = null;
            } else {
                node.key = successor.key;
                node.data = successor.data;
                if (isOnLeftOfParent(successor)) {
                    successor.parent.leftChild = null;
                } else {
                    successor.parent.righChild = null;
                }
            }
        } else {
            node.key = successor.key;
            node.data = successor.data;   
            reArrangeSingleChild(successor, successor.righChild);
        }
    }

    private void reArrangeSingleChild(Node node, Node child) {
        if (node.parent == null) { //for root node
            root = child;
            root.parent = null;
        } else {   
            if (isOnLeftOfParent(node)) {
                node.parent.leftChild = child;
            } else {
                node.parent.righChild = child;
            }
            child.parent = node.parent;
        }
    }

    private boolean isOnLeftOfParent(Node node) {
        return node.parent.leftChild.equals(node);
    }

    private void detachFromParent(Node node) {
        if (node.parent.leftChild.equals(node)) {
            node.parent.leftChild = null;
        } else {
            node.parent.righChild = null;
        }
    }

    private boolean isRootNode(Node node) {
        return root.equals(node.parent);
    }

    private boolean isLeafNode(Node node) {
        return node.leftChild == null && node.righChild == null;
    }

    public Node successor(Node node) {
        Node right = node.righChild;
        Node parent = right;
        Node leftOfRight = right.leftChild;
        while (leftOfRight != null) {
            parent = leftOfRight;
            leftOfRight = leftOfRight.leftChild;
        }

        return parent;
    }
}
