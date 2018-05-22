package trees.binary;

import java.util.Objects;

/**
 * Created by ts250370 on 8/17/17.
 */
public class Node {
    public Object data;
    public int key;
    public Node leftChild;
    public Node rightChild;
    public Node parent;

    public Node(Object data) {
        this.data = data;
    }

    public boolean equals (Object o) {
        if (o == this) {
             return true;
        }

        if (!(o instanceof Node)) {
            return false;
        }

        Node anotherNode = (Node) o;

        if (this.key == anotherNode.key) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = 17;
        return 31 * result + this.key;
    }

    public String toString() {
        return "[" + key + " (" + data + ") ]";
    }
}
