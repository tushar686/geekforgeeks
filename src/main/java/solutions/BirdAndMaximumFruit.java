package solutions;

import java.util.Scanner;

class BirdAndMaximumFruit {

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
//        int maxSum = findMax(maxTrees, values.split("\\s"));
//        int maxSum = circularArray(maxTrees, values.split("\\s"));
        int maxSum = circularArray_Efficient(maxTrees, values.split("\\s"));

        return maxSum;
    }

    static int circularArray_Efficient_Even_Better(int windowSize, String[] values) {
        int maxSumSoFar = 0;

        for (int i=0; i<windowSize && i<values.length; i++) {
            maxSumSoFar += Integer.parseInt(values[i]);
        }

        for (int i=1; i<values.length; i++) {
            int pos = (i + windowSize) % values.length;

            int sum = maxSumSoFar - Integer.parseInt(values[i-1]) + Integer.parseInt(values[pos]);


            if (sum > maxSumSoFar) {
                maxSumSoFar = sum;
            }

        }

        return maxSumSoFar;
    }

    static int circularArray_Efficient_DP(int windowSize, String[] values) {
        int maxSumSoFar = 0;

        int[] sum = new int[values.length];
        sum[0] = Integer.parseInt(values[0]);
        for (int i=1; i<values.length; i++) {
            sum[i] = sum[i-1] + Integer.parseInt(values[i]);
        }

        int currentMaxSum = windowSize-1 > values.length ? sum[windowSize-1] : sum[sum.length-1] ;
        maxSumSoFar = currentMaxSum;

        int startIndex = 0;
        for (int i=1; i<values.length; i++, startIndex++) {
            int pos = (i + windowSize) % values.length;

            currentMaxSum = currentMaxSum - Integer.parseInt(values[startIndex]) + Integer.parseInt(values[pos]);

            if (currentMaxSum > maxSumSoFar) {
                maxSumSoFar = currentMaxSum;
            }

        }

        return maxSumSoFar;
    }

    static int circularArray_Efficient(int windowSize, String[] values) {
        int maxSumSoFar = 0;

        for (int i=0; i<values.length; i++) {
            int currentMaxSum = 0;
            for (int j=0; j<windowSize ; j++) {
                int pos = (i + j) % values.length;
                currentMaxSum +=  Integer.parseInt(values[pos]);
            }

            if (currentMaxSum > maxSumSoFar) {
                maxSumSoFar = currentMaxSum;
            }
        }

        return maxSumSoFar;
    }

    static int circularArray(int n, String[] values) {
        int maxSum = 0;

        for (int i=0; i<values.length; i++) {
            int currentMaxValue = 0;
            int ki = i;
            int kj = 0;
            for (int j=0; j<n; j++, kj++) {
                if (ki + kj >= values.length) {
                    ki = 0;
                    kj = 0;
                }
                currentMaxValue += Integer.parseInt(values[ki+kj]);
            }

            if (currentMaxValue > maxSum) {
                maxSum = currentMaxValue;
            }
        }

        return maxSum;
    }

    static int findMax(int n, String[] values) {
        if (n == 0 || n >= values.length) {
            return 0;
        }
        return  Math.max(Integer.parseInt(values[n]) + findMax(n - 1, values), findMax(n - 1, values));
    }

}