package sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String [] args) {
        ShellSort shellSort = new ShellSort();
        // shellSort.sort(new int[] {8, 7, 5, 3, 9, 1, 2, 4, 6});
        shellSort.sort_1(new int[] {12, 34, 54, 2, 3});
    }

    private void sort(int [] input) {
        int n = input.length;
        System.out.println("Input " + Arrays.toString(input));
        for(int gap = n/2; gap > 0; gap = gap/2) {
            //12 34 54 2 3            
            for(int end=gap; end < n; end++) {
                int temp = input[end];
                int currentEnd = end;
                for(; currentEnd >= gap && temp < input[currentEnd-gap]; currentEnd = currentEnd-gap) {
                    input[currentEnd] = input[currentEnd-gap];
                }
                input[currentEnd] = temp;
            }    
        }
        System.out.println("Input " + Arrays.toString(input));
    }

    private void sort_1(int [] input) {
        int n = input.length;
        System.out.println("Input " + Arrays.toString(input));
        for (int gap = n/2; gap > 0; gap = gap/2) {
            for (int end=gap; end<n; end++) {
                int currentEnd = end;
                int temp = input[currentEnd];

                for (; currentEnd-gap >= 0 && input[currentEnd] < input[currentEnd-gap]; currentEnd-=gap) {
                    input[currentEnd] = input[currentEnd-gap];
                }
                input[currentEnd] = temp;
            }
        }
        System.out.println("Input " + Arrays.toString(input));
    }
}