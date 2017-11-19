package hackerrank;

import java.util.Scanner;

class FindMaxIJForAiLessThanAj {
	public static void main (String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int T = sc.nextInt();
//		int[][] input = new int[T][];
//
//		for (int i=0; i<T; i++) {
//		    int size = sc.nextInt();
//		    input[i] = new int[size];
//
//		    for (int j=0; j<size; j++) {
//		        input[i][j] = sc.nextInt();
//		    }
//		}
//
//		for (int i=0; i<T; i++) {
//            System.out.println(findMaxJ_I(input[i]));
//		}

        System.out.println(findMaxJ_I_Efficient(new int[]{3, 5, 4, 2}));
        System.out.println(findMaxJ_I_Efficient(new int[]{34, 8, 10, 3, 2, 80, 30, 33, 1}));
        System.out.println(findMaxJ_I_Efficient(new int[]{9, 2, 3, 4, 5, 6, 7, 8, 18, 0}));
        System.out.println(findMaxJ_I_Efficient(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(findMaxJ_I_Efficient(new int[]{6, 5, 4, 3, 2, 1}));

	}
	
	static int findMaxJ_I(int[] input) {
        int maxDif = 0;
	    for (int i=0; i<input.length; i++) {
            for (int j=i+1; j<input.length; j++) {
                if (input[j] >= input[i] && maxDif < j -i ) {
                    maxDif = j - i;
                }
            }
	    }
        return maxDif;
	}

    static int findMaxJ_I_Efficient(int[] input) {
        int[] LMin = new int[input.length];
        int[] RMax = new int[input.length];

        LMin[0] = input[0];
        for (int i=1; i<input.length; i++) {
            if (LMin[i-1] >= input[i]) {
                LMin[i] = input[i];
            } else {
                LMin[i] = LMin[i-1];
            }
        }

        RMax[RMax.length-1] = input[RMax.length-1];
        for (int i=RMax.length-2; i>=0; i--) {
            if (RMax[i+1] <= input[i]) {
                RMax[i] = input[i];
            } else {
                RMax[i] = RMax[i+1];
            }
        }

        int maxDif = -1;
        int i = 0;
        int j = 0;
        while(i<input.length && j<input.length) {
            if (LMin[i] < RMax[j]) {
                if (maxDif < (j-i)) {
                    maxDif = j-i;
                }
                j++;
            } else {
                i++;
            }
        }

        return maxDif;
    }
}