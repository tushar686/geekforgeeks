package stack_queus;

/**
 * Created by ts250370 on 9/11/17.
 */
public class Node {

    Object data;
    Node next;

    public Node(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
