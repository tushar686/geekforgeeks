package algobook.sort;

import java.util.*;

/**
 * Created by ts250370 on 7/23/17.
 */
public class MergeSort {

    private static int INPUT_SIZE = 10;
    int [] input = new int[INPUT_SIZE];

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        mergeSort.initializeInput();
        mergeSort.print(mergeSort.input, 0, INPUT_SIZE);
        mergeSort.sort(mergeSort.input, 0, INPUT_SIZE);
        System.out.println("");
        mergeSort.print(mergeSort.input, 0, INPUT_SIZE);
    }

    private void initializeInput() {
        Random random = new Random(Calendar.getInstance().getTimeInMillis());
        for (int i=0; i<INPUT_SIZE; i++) {
            input[i] = random.nextInt(50) + 1;
        }
    }

    private void print(int[] arr, int i, int size) {
        if(i == size) {
            System.out.println();
            return;
        }
        System.out.print(arr[i] + " ");
        print(arr, i+1, size);
    }

    private void sort(int[] arr, int low, int high) {
//        System.out.printf("\n:::::low and high::::::%d %d", low, high);
        if(low == high) {
            return;
        }

        int middle = Math.floorDiv(low+high, 2);
        sort(arr, low, middle);
        sort(arr, middle+1, high);
        merge(arr, low, middle, high);
    }

    private void merge(int[] arr, int low, int middle, int high) {
        Queue<Integer> buffer = new ArrayDeque<>(high-low + 1);
        int firstStart = low;
        int firstEnd = middle + 1;
        int secondStart = middle + 1;
        int secondEnd = high+1;

//        System.out.printf("\n\n%d %d %d %d\n", low, middle, middle, high);
//        System.out.printf("%d %d %d %d\n", firstStart, firstEnd, secondStart, secondEnd);

        if(secondStart >= INPUT_SIZE) {
            return;
        }
        if (secondEnd >= INPUT_SIZE) {
            secondEnd = INPUT_SIZE;
        }
//        System.out.println("========array======");
//        print(arr, firstStart, firstEnd);
//        print(arr, secondStart, secondEnd);
//        System.out.println("===================");

        while ( (firstStart < firstEnd) && (secondStart < secondEnd) ) {
            if(arr[firstStart] <= arr[secondStart]) {
                buffer.add(arr[firstStart++]);
            } else {
                buffer.add(arr[secondStart++]);
            }
        }
//        printBuffer(buffer.iterator());

        if (firstStart < firstEnd) {
            while (firstStart < firstEnd) {
                buffer.add(arr[firstStart++]);
            }
        } else if (secondStart < secondEnd) {
            while (secondStart < secondEnd) {
                buffer.add(arr[secondStart++]);
            }
        }
//        printBuffer(buffer.iterator());

        firstStart = low;
        while (!buffer.isEmpty()) {
            arr[firstStart++] = buffer.remove();
        }
//        print(input, 0, INPUT_SIZE);

    }

    private void printBuffer(Iterator buffer) {
        System.out.println("-----buffer-----");
        while (buffer.hasNext()) {
            System.out.printf("%d ", buffer.next());
        }
        System.out.println("\n----------------");
    }
}
