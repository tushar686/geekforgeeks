package solutions;

import java.util.Arrays;
import java.util.Scanner;

public class LargestFibSeq {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][] input = new int[T][];
        for (int i=0; i<T; i++) {
            int n = sc.nextInt();
            input[i] = new int[n];
            for (int j=0; j<n; j++) {
                input[i][j] = sc.nextInt();
            }
        }

        int[] fib = calculateFib();

        for (int i=0; i<T; i++) {
            largestFibSeq(fib, input[i]);
            System.out.println();
        }
    }

    static void largestFibSeq(int[] fib, int[] input) {
        for (int i=0; i<input.length; i++) {
            if (fib[input[i]] != -1) {
                System.out.print(input[i] + " ");
            }
        }
    }

    static int[] calculateFib() {
        int[] fib = new int[1001];
        Arrays.fill(fib, -1);
        fib[0] = 0;
        fib[1] = 1;
        int first = 0;
        int second = 1;
        for (int i=2; i<90; i++) {
             int fibSeq = first + second;
             if (fibSeq > 1000) {
                 break;
             }
             first = second;
             second = fibSeq;
             fib[fibSeq] = fibSeq;
        }
        return fib;
    }

}