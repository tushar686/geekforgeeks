package sort;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by ts250370 on 7/23/17.
 */
public class HeapSort {

    private static int INPUT_SIZE = 10;
    int [] input = new int[INPUT_SIZE+1];

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        heapSort.initializeInput();
        heapSort.print(1, INPUT_SIZE);
        heapSort.sort();
    }

    private void initializeInput() {
        Random random = new Random(50);
        for (int i=0; i<INPUT_SIZE; i++) {
            input[i] = random.nextInt(50) + 1;
        }
    }

    private void print(int i, int size) {
        if(i > size) {
            System.out.println();
            return;
        }
        System.out.print(input[i] + " ");
        print(i+1, size);
    }

    private void sort() {
        int noOfNodes = INPUT_SIZE;
        int heapRoot = 1;
        System.out.printf("%d=%d\n", heapRoot, input[heapRoot]);

//        print(1, noOfNodes);
//        for (int i=noOfNodes; i>heapRoot; i -= 1) {
//            bubbleUp(i, heapRoot, noOfNodes);
//        }
//        print(1, noOfNodes);

        print(1, noOfNodes);
        for (int i=1; i<=Math.floorDiv(noOfNodes, 2); i += 1) {
            bubbleDown(i, heapRoot, noOfNodes);
        }
        print(1, noOfNodes);
    }

    private void bubbleUp(int eleIndex, int heapRoot, int noOfNodes) {
        int eleRootIndex = Math.floorDiv(eleIndex, 2);

        if ( (eleRootIndex*2 > heapRoot) && input[eleRootIndex] > input[eleRootIndex*2]) {
            swap(eleRootIndex, eleRootIndex * 2);
        } else if ((eleRootIndex*2+1)<= noOfNodes && input[eleRootIndex] > input[eleRootIndex*2+1]) {
            swap(eleRootIndex, eleRootIndex * 2+1);
        }
    }

    private void bubbleDown(int eleIndex, int heapRoot, int noOfNodes) {
        int eleRootIndex = Math.floorDiv(eleIndex, 2) == 0 ? 1 : Math.floorDiv(eleIndex, 2);
//        System.out.printf("root of %d=%d\n", eleIndex, eleRootIndex);

        if ( (eleRootIndex*2 <= noOfNodes) && input[eleRootIndex] > input[eleRootIndex*2]) {
            swap(eleRootIndex, eleRootIndex * 2);
        } else if ((eleRootIndex*2+1)<= noOfNodes && input[eleRootIndex] > input[eleRootIndex*2+1]) {
            swap(eleRootIndex, eleRootIndex * 2+1);
        }
    }

    private int getMin(int noOfNodes) {
        return input[Math.floorDiv(noOfNodes,2)];
    }


    private void swap(int i, int j) {
        int temp;
        temp = input[i];
        input[i] = input[j];
        input[j] = temp;

    }


























}
