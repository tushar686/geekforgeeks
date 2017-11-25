package solutions;

import org.omg.CORBA.INTERNAL;

import java.util.Scanner;

class GFG {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        String[][] input = new String[T][];
        for (int i=0; i<T; i++) {
            input[i] = new String[]{sc.nextLine(), sc.nextLine()};
        }
//        2
//        7 3
//        2 1 3 5 0 1 4
//        6 2
//        1 6 2 5 3 4

        for (int i=0; i<T; i++) {
            int maxSum = getMaxSum(input[i][0], input[i][1]);
            System.out.println(maxSum);
        }
    }


    static int getMaxSum(String sizeSec, String values) {

        int maxTrees =  Integer.parseInt(sizeSec.split("\\s")[1]);
        int maxSum = findMax(maxTrees, values.split("\\s"));
//        int maxSum = knapSack(maxTrees, values.split("\\s"));

        return maxSum;
    }

    static int knapSack(int n, String[] values) {
        int[][] k = new int[values.length+1][n+1];

        for (int i=0; i<=values.length; i++) {
            for (int j=0; j<=n; j++) {
                if (i == 0 || j == 0) {
                    k[i][j] = 0;
                } else {
                    int currentValue = Integer.parseInt(values[i-1]);
                    int currentMaxValue = k[i-1][j-1] + currentValue;

                    if (currentMaxValue > k[i-1][j]) {
                        k[i][j] = currentMaxValue;
                    } else {
                        k[i][j] = k[i-1][j];
                    }
                }
            }
        }

        return k[values.length][n];
    }

    static int findMax(int n, String[] values) {
        if (n == 0 || n >= values.length) {
            return 0;
        }
        return  Math.max(Integer.parseInt(values[n]) + findMax(n - 1, values), findMax(n - 1, values));
    }

}