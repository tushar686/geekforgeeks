package stringarraysmatrix;

/**
 * Created by ts250370 on 8/15/17.
 */
public class Knapsack {

    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        // knapsack.knapsack(new int[] {11, 4, 8, 6, 7, 5}, 20);
        int[] weights = new int[] {10, 20, 30};
        int[] values = new int[] {120, 220, 80};
        knapsack.knapsack(weights, values, weights.length, 50);
    }

    public int knapsack(int [] weights, int[] values, int currentWeightIdx, int capacity) {
        if (currentWeightIdx == 0 || capacity == 0) {
            return 0;
        }
        if (weights[currentWeightIdx-1] > capacity) {
            return knapsack(weights, values, currentWeightIdx-1, capacity);
        }

        return Math.max(
            values[currentWeightIdx-1] + knapsack(weights, values, currentWeightIdx-1,  capacity-weights[currentWeightIdx-1]),
            knapsack(weights, values, currentWeightIdx-1, capacity)
        );
    }

    public int knapsack(int [] weights, int[] values, int currentWeightIdx, int capacity, int[][] memoization) {
        if (memoization[currentWeightIdx][capacity] != 0) {
            return memoization[currentWeightIdx][capacity];
        }
        if (currentWeightIdx == 0 || capacity == 0) {
            return 0;
        }
        if (weights[currentWeightIdx-1] > capacity) {
            return knapsack(weights, values, currentWeightIdx-1, capacity);
        }

        int include = values[currentWeightIdx-1] + knapsack(weights, values, currentWeightIdx-1,  capacity-weights[currentWeightIdx-1]);
        int exclude = knapsack(weights, values, currentWeightIdx-1, capacity);
        int result = Math.max(include, exclude);
        memoization[currentWeightIdx][capacity] = result;
        return result;
    }

    public void knapsack(int [] weights, int[] values, int capacity) {
        int[][] k = new int[weights.length+1][capacity+1];

        for (int i=0; i<weights.length; i++) {
            for (int w=0; w<capacity+1; w++) {
                if (i == 0 || w == 0) {
                    k[i][w] = 0;
                }
                if (k[i-1][0] <= capacity) {
                    k[i][w] = Math.max(values[i-1] + k[i-1][w - weights[i]], k[i-1][w]);
                } else {
                    k[i][w] = k[i-1][w];
                }
            }
        }
    }

    public void knapsack(int [] weights, int target) {
        knapsack(0, 1, false, weights, target);
    }

    private boolean knapsack(int startIndex, int secondIndex, boolean foundAnswer, int [] weights, int target) {
        if (startIndex >= weights.length || foundAnswer)
            return foundAnswer;

        int firstWeight = weights[startIndex];
        System.out.print("\nWeights: " + firstWeight);

        if (firstWeight == target) {
            System.out.print(" ::: Answer");
            return true;
        }

        for (int i=secondIndex; i<weights.length; i++) {
            System.out.print(" " + weights[i]);
            firstWeight += weights[i];
            if (firstWeight == target) {
                System.out.print(" ::: Answer");
                foundAnswer = true;
                break;
            }

            if (firstWeight > target) {
                System.out.print(" ::: No");
                return knapsack(startIndex, ++secondIndex, foundAnswer, weights, target);
            }
        }

        if (firstWeight < 20) {
            System.out.print(" ::: No");
        }

        ++startIndex;
        return knapsack(startIndex, startIndex + 1, foundAnswer, weights, target);
    }
}
