package dynamic_programming;

public class LongestIncreasingSumSubArra {

    public static void main (String[] args) {
        LongestIncreasingSumSubArra lis = new LongestIncreasingSumSubArra();
        lis.find(new int[] {2, 6, 3, 4, 1, 2, 9, 5, 8});
    }

    void find(int [] array) {
        int[] DP = new int[array.length];
        int[] prev = new int[array.length];
        int maxLength = 1, bestEnd = 0;

        DP[0] = 1;
        prev[0] = -1;

        for (int i = 1; i < array.length; i++){
            DP[i] = 1;
            prev[i] = -1;

            for (int j = i - 1; j >= 0; j--)
                if (DP[j] + 1 > DP[i] && array[j] < array[i]) {
                    DP[i] = DP[j] + 1;
                    prev[i] = j;
                }

            if (DP[i] > maxLength) {
                bestEnd = i;
                maxLength = DP[i];
            }
        }

        int i = bestEnd;
        while(i != -1) {
            System.out.print(array[i] + "==>");
            i = prev[i];
        }
    }
}