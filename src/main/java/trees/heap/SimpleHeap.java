package trees.heap;

/**
 * Created by ts250370 on 8/19/17.
 */
public class SimpleHeap {
    int INPUT_SIZE = 10;
    int count = 0;
    int [] heap = new int[INPUT_SIZE];

    public static void main(String[] args) {
        class Data {
            private final String name;
            private final String address;

            public Data(String name, String address) {
                this.name = name;
                this.address = address;
            }

            public String toString() {
                return this.name + " " + this.address;
            }

        }

        SimpleHeap heap = new SimpleHeap();
//        Scanner sc = new Scanner(System.in);
//        int input = sc.nextInt();
//
//        while(input != -1) {
//            heap.insert(input);
//            input = sc.nextInt();
//        }

        heap.insert(18);
        heap.insert(16);
        heap.insert(15);
        heap.insert(17);
        heap.insert(24);
        heap.insert(19);
        heap.insert(29);
        heap.insert(27);
        heap.insert(26);
        heap.insert(30);
        System.out.println(heap.getMin());

        for (int i=0; i<heap.INPUT_SIZE; i++) {
            System.out.print(heap.deleteMin() + " ");
            
        }
    }

    public int getMin() {
        return heap[0];
    }

    public int deleteMin() {
        count--;
        int min = heap[0];

        heap[0] = heap[count];
        heapifyTopDown(0);


        return min;
    }

    private void heapifyTopDown(int pos) {
        if (pos < count/2 && heap[pos] > Math.min(heap[2*pos + 1], heap[2*pos + 2])) {
            if (heap[2*pos + 1] < heap[2*pos + 2]) { 
                swap(pos, 2*pos + 1);
                heapifyTopDown(2*pos + 1);
            } else {
                swap(pos, 2*pos + 2);
                heapifyTopDown(2*pos + 2);
            }
        }
    }

    public void insert(int priority) {
        heap[count] = priority;
        heapifyBottomUp(priority, count);
        count++;
    }

    private void heapifyBottomUp(int priority, int pos) {
        heap[pos] = priority;
        int root = (pos-1)/2;

        if (heap[root] > priority) {
            swap(root, pos);
            heapifyBottomUp(heap[root], root);
        }

    }

    private void swap(int root, int count) {
        int temp = heap[root];
        heap[root] = heap[count];
        heap[count] = temp;    
    }
}
