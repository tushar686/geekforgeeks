package ds;

import java.util.Scanner;

/**
 * Created by ts250370 on 8/10/17.
 */
public class Queue {

    int front = 0;
    int rear = 0;
    int eleAdded = 0;
    int size = 2;
    int [] q = new int[size];

    public static void main(String[] args) {
        Queue q = new Queue();

        Scanner sc = new Scanner(System.in);

        while (true) {
            int addOrRemove = sc.nextInt();
            if( addOrRemove == 0) {
                int addElement = sc.nextInt();
                System.out.println(q.add(addElement));
            } else {
                System.out.println("======== " + q.remove());
            }
        }
    }

    private boolean add(int ele) {
        wrapRearfCan();
        wrapFrontIfCan();
        if (!isFull()) {
            eleAdded++;
            q[rear++] = ele;
            return true;
        }
        return false;
    }

    private int remove() {
        wrapFrontIfCan();
        wrapRearfCan();
        if (!isEmpty()) {
            eleAdded--;
            return q[front++];
        }
        return -1;
    }

    private boolean isEmpty() {
        return eleAdded == 0; //(front == 0 && rear == 0) || (front == rear && front != 0) ;
    }

    private boolean isFull() {
        return  eleAdded == size; //( (rear == size) || (rear == front && front != 0) );
    }

    private void wrapFrontIfCan() {
        if (front == size && rear != 0) {
            front = 0;
        }
    }

    private void wrapRearfCan() {
        if (rear == size && front != 0) {
            rear = 0;
        }
    }

}
