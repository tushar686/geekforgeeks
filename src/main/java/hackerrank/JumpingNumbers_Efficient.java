package hackerrank;

import java.util.ArrayDeque;
import java.util.Scanner;

class JumpingNumbers_Efficient {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] input = new int[T];
        for (int i=0; i<T; i++) {
            input[i] = sc.nextInt();
        }

        for (int i=0; i<T; i++) {
            printJumptingNumbers(input[i]);
            System.out.println();
        }
    }

    static void printJumptingNumbers(int input) {
        System.out.print(0 + " ");
        for (int i = 1; i < 10; i++) {
            generateAllPermutations(input, i);
        }
    }

    static void generateAllPermutations(int input, int currentInt) {
        java.util.Queue<Integer> q = new ArrayDeque<>();
        q.add(currentInt);

        while (!q.isEmpty()) {
            int ele = q.remove();
            if (ele <= input) {
                System.out.print(ele + " ");
                int lastDigit = ele % 10;
                if (lastDigit == 0) {           //from 0 we can only reach to 1
                    q.add(ele * 10 + (ele % 10) + 1);
                } else if (lastDigit == 8) {           //from 9 we can only reach to 8
                    q.add(ele * 10 + (ele % 10) - 1);
                } else {
                    q.add(ele * 10 + (ele % 10) - 1);
                    q.add(ele * 10 + (ele % 10) + 1);
                }
            }
        }
    }

}