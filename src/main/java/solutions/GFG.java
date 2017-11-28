package solutions;

import java.util.*;

public class GFG {
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
        for (int i=0; i<T; i++) {
            getPairsOfPositiveAndNegative_WithHash(input[i]);
        }
    }

    static void getPairsOfPositiveAndNegative_WithHash(int[] input) {
        int[] hash = new int[1001];
        boolean found = false;
        for (int i=0; i<input.length; i++) {
            int currentEle = input[i];
            int absCurrentEle = Math.abs(currentEle);
            if (hash[absCurrentEle] + currentEle == 0) {
                found = true;
                System.out.format("%d %d ", absCurrentEle, -absCurrentEle);
            }
            hash[absCurrentEle] = currentEle;
        }
        if (!found)
            System.out.print("0");
        System.out.println();    
    }

    static Set<Integer> getPairsOfPositiveAndNegative_WithArray(int[] input) {
        Set<Integer> pairs = new HashSet();
        int[] pair = new int[1001];

        for (int i=0; i<input.length; i++) {
            int currentEle = input[i];
            if (currentEle > 0) {
                if (pair[currentEle] < 0) {
                    pairs.add(currentEle);
                }
                pair[currentEle] = 1; 
            } else {
                if (pair[-currentEle] > 0) {
                    pairs.add(-currentEle);
                }
                pair[-currentEle] = -1; 
            }
        }

        return pairs;
    }

}