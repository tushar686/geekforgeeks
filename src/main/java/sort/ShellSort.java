package sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String [] args) {
        ShellSort shellSort = new ShellSort();
        shellSort.sort(new int[] {8, 7, 5, 3, 9, 1, 2, 4, 6});
    }

    private void sort(int [] input) {
        int n = input.length;
        System.out.println("Input " + Arrays.toString(input));
        for(int gap = n/2; gap > 0; gap = gap/2) {
            for(int p=gap; p < n; p++) {
                int temp = input[p];
                int j=p;
                for(; j >= gap && temp < input[j-gap]; j = j-gap) {
                    input[j] = input[j-gap];
                }
                input[j] = temp;
            }    
        }
        System.out.println("Input " + Arrays.toString(input));
    }
}