package stack_queus;

/**
 * Created by ts250370 on 9/11/17.
 */
public class Queue {

    Node first, last;

    public void enQueue(Object data) {
        Node node = new Node(data);

        if (last == null) {
            first = node;
        } else {
            last.next = node;
        }
        last = node;
    }

    public Node deQueuq() {
        Node node = null;
        if (first != null) {
            node = first;
            first = first.next;
        }

        return node;
    }


    public static void main(String[] args) {
        Queue stack = new Queue();
        stack.enQueue("1");
        stack.enQueue("2");
        stack.enQueue("3");
        stack.enQueue("4");
        stack.enQueue("5");
        stack.enQueue("6");

        System.out.println(stack.deQueuq());
        System.out.println(stack.deQueuq());
        System.out.println(stack.deQueuq());
        System.out.println(stack.deQueuq());
        System.out.println(stack.deQueuq());
        System.out.println(stack.deQueuq());
        System.out.println(stack.deQueuq());
    }
}
