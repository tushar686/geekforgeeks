package sort;

import java.util.*;

/**
 * Created by ts250370 on 7/23/17.
 */
public class QuickSort {

    private static int INPUT_SIZE = 10;
    int [] input = new int[INPUT_SIZE];

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        quickSort.initializeInput();
        quickSort.print(quickSort.input, 0, INPUT_SIZE);
        quickSort.sort(quickSort.input, 0, INPUT_SIZE-1);
        System.out.println("");
        quickSort.print(quickSort.input, 0, INPUT_SIZE);
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
        if(low >= high) {
            return;
        }
        System.out.printf("\n:::::low and high::::::%d %d", low, high);

        int p = partition(arr, low, high);
        sort(arr, low, p-1);
        sort(arr, p+1, high);
    }

    private int partition(int[] arr, int low, int high) {
        int pivotal = high;
        int firstHigh = low;

        for (int i=low; i<high; i++) {
            if(arr[i] < arr[pivotal]) {
                swap(arr, i, firstHigh);
                firstHigh++;
            }
        }
        swap(arr, firstHigh, pivotal);

        System.out.printf("\n\n%d %d %d\n", low, high, firstHigh);
        return firstHigh;
    }

    private void swap(int [] arr, int i, int j) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

}
