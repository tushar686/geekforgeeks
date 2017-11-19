package hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class FindTriplets_WithSet {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        int[][] input = new int[T][];
        for (int i=0; i<T; i++) {
            int n = sc.nextInt();
            input[i] = new int[n];
            for (int j=0; j<n; j++) {
                input[i][j] = sc.nextInt();
            }
        }

         for (int i=0; i<T; i++) {
             System.out.println(isTripletZero(input[i]));
         }

    }

    static int isTripletZero(int[] input) {
        for (int i=0; i<input.length-1; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j=i+1; j<input.length; j++) {
                    int sumOfPair = input[i] + input[j];
                    if ( set.contains(-sumOfPair)) {
                        return 1;
                    } else {
                        set.add(input[j]);
                    }
                }
            }
        return 0;
    }

}