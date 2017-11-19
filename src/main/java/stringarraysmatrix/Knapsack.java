package stringarraysmatrix;

/**
 * Created by ts250370 on 8/15/17.
 */
public class Knapsack {

    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        knapsack.knapsack(new int[] {11, 4, 8, 6, 7, 5}, 20);
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
