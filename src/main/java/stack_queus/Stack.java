package stack_queus;

/**
 * Created by ts250370 on 9/11/17.
 */
public class Stack {

    Node top;

    public void push(Object data) {
        Node node = new Node(data);
        if (top != null) {
            node.next = top;
        }
        top = node;
    }

    public Node pop() {
        Node node = null;
        if (top != null) {
            node = top;
            top = top.next;
        }
        return node;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        stack.push("6");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
