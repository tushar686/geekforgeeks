package algobook.sort;

import java.util.Scanner;

/**
 * Created by ts250370 on 7/23/17.
 */
public class Insertion_Selection_Sort {

    public static final int INPUT_SIZE = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] input = new int[INPUT_SIZE];
        int i = 0;
        while(i<INPUT_SIZE) {
            input[i] = sc.nextInt();
            i++;
        }
        selectionSort(input);

        for(int ele : input) {
            System.out.print(ele + " ");
        }
    }

    private static void selectionSort(int[] input) {
        for(int i=0; i<input.length; i++) {
            int min=i;
            for(int j=i+1;j<input.length; j++) {
                if(input[min] > input[j]) {
                    min = j;
                }
            }
            swap(input,i, min);
        }
    }

    private static void insertionSort(int[] input ) {
        for(int i=0; i<INPUT_SIZE; i++) {
            for(int j=i; j>0 && input[j] < input[j-1]; j--) {
                swap(input, j, j-1);
            }
        }
    }

    private static void swap(int[] input, int i, int j) {
        int temp;
        temp = input[i];
        input[i] = input[j];
        input[j] = temp;

    }
}
