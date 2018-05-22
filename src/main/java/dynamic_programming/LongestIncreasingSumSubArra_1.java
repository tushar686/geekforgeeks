package dynamic_programming;

public class LongestIncreasingSumSubArra_1 {

    public static void main(String[] args) {
        LongestIncreasingSumSubArra_1 lis = new LongestIncreasingSumSubArra_1();

        lis.find(new int [] {2, 6, 3, 4, 1, 9, 5, 8});
    }

    private void find(int[] array) {
        int [] DP = new int[array.length];
        int [] prev = new int[array.length];

        DP[0] = 1;
        prev[0] = -1;
        int maxLength = 1;
        int bestEnd = 0;

        for(int i=1; i<array.length; i++) {
            DP[i] = 1;
            prev[i] = i-1;
            for(int j=i-1; j>=0; j--) {
                if(DP[j] + 1 > DP[i] && array[i] > array[j]) {
                    DP[i] = DP[j]+1;
                    prev[i] = j;
                }
            }
            if(DP[i] >  maxLength) {
                maxLength = DP[i];
                bestEnd = i;
            }
        }

        System.out.println(bestEnd);
        while(bestEnd != -1) {
            System.out.print("===>" + array[bestEnd]);
            bestEnd = prev[bestEnd];
        }
        System.out.println();
        
    }
}