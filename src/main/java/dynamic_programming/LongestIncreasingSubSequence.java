package dynamic_programming;

public class LongestIncreasingSubSequence {
    
    public static void main(String[] args) {
        LongestIncreasingSubSequence longestIncreasingSubSequence = new LongestIncreasingSubSequence();
        
        int lis = longestIncreasingSubSequence.findLongestIncreasingSubsequence(new int[] {10, 22, 9, 33, 21, 50, 41, 60, 80});
        System.out.println("Longest Increasing Subsequence is: " + lis);
    }

    int findLongestIncreasingSubsequence(int[] arr) {
        int[] lis = new int[arr.length];
        int[] parent = new int[arr.length];
        int maxLength = 1;
        int maxLengthIndexEnd = 0;

        for (int i=0; i<arr.length; i++) {
            lis[i] = 1;
            for (int j=i-1; j>=0 && arr[i] > arr[j]; j--) {
                if (arr[i] > arr[j] && lis[j] + 1 > lis[i]) {
                    lis[i] = lis[j] + 1;
                    parent[i] = j;
                    if (maxLength < lis[i]) {
                        maxLength = lis[i];
                        maxLengthIndexEnd = i;
                    }
                }
            }
        }

        for (int i=0; i<maxLength; i++) {
            System.out.print(arr[maxLengthIndexEnd] + " => ");
            maxLengthIndexEnd = parent[maxLengthIndexEnd];
        }
        System.out.println();            
        return maxLength;
    }
}