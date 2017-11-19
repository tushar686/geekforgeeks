
package hackerrank;

import java.util.*;
import java.util.Map.Entry;
import java.lang.*;
import java.io.*;

class JumpingNumbers {
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
        int numberOfDigits = findNumberOfDigits(input);
        Set<String> set = new LinkedHashSet<>();
        for (int i = 1; i < 10 && i<=input; i++) {
            generateAllPermutations(i - 1, i, numberOfDigits, input, set);
        }
        System.out.print(0 + " ");
        for (String ele: set) {
            System.out.print(ele + " ");
        }
    }

    static void generateAllPermutations(int prevInt, int currentInt, int numberOfDigits, int input, Set<String> set) {
        for (int i=1; i<numberOfDigits; i++) {
            int j = i;
            String jumpingNumber = "" + prevInt;
            int lastAppendedNumber = prevInt;
            while(j > 0 && prevInt > 0) {
                if (lastAppendedNumber == prevInt) {
                    jumpingNumber = jumpingNumber + currentInt;
                    lastAppendedNumber = currentInt;
                } else {
                    jumpingNumber = jumpingNumber + prevInt;
                    lastAppendedNumber = prevInt;
                }
                if (Integer.parseInt(jumpingNumber) <= input) {
                    set.add(jumpingNumber);
                } else {
                    break;
                }
                j--;
            }

            if (currentInt <= input) {
                set.add("" + currentInt);
            }
            j = i;
            jumpingNumber = "" + currentInt;
            lastAppendedNumber = currentInt;
            while(j > 0) {
                if (lastAppendedNumber == prevInt) {
                    jumpingNumber = jumpingNumber + currentInt;
                    lastAppendedNumber = currentInt;
                } else {
                    jumpingNumber = jumpingNumber + prevInt;
                    lastAppendedNumber = prevInt;
                }
                if (Integer.parseInt(jumpingNumber) <= input) {
                    set.add(jumpingNumber);
                } else {
                    break;
                }
                j--;
            }
        }
    }

    static int findNumberOfDigits(int n) {
        int count = 0;
        while (n / 10 > 0) {
            n = n / 10;
            count++;
        }
        count++;
        return count;
    }



}