package dynamic_programming;

public class LongestRepeatedSubsequence {

    public static void main(String[] args) {
        String str = "AABEBCDD";

        LongestRepeatedSubsequence longestRepeatedSubsequence = new LongestRepeatedSubsequence();

        int lrs = longestRepeatedSubsequence.findLongestRepeatedSequence(str, str, str.length(), str.length());
        System.out.println(lrs);
        lrs = longestRepeatedSubsequence.findLongestRepeatedSequence_DiffIndexes(str, str, str.length(), str.length());
        System.out.println(lrs);
    }

    private int findLongestRepeatedSequence_DiffIndexes(String s1, String s2, int m, int n) {
        int[][] lrs = new int[m+1][n+1];

        for (int i=0; i<m; i++) {
            for (int j=0; j<m; j++) {
                if (s1.charAt(i) == s2.charAt(j) && i != j) {
                    lrs[i+1][j+1] = lrs[i][j] + 1;
                } else {
                    lrs[i+1][j+1] = Math.max(lrs[i][j+1], lrs[i+1][j]);
                }
            }
        }

        return lrs[n][n];
    } 

    private int findLongestRepeatedSequence(String s1, String s2, int m, int n) {
        int[][] lrs = new int[m+1][n+1];

        for (int i=0; i<=m; i++) {
            for (int j=0; j<=m; j++) {
                if (i == 0 || j == 0) {
                    lrs[i][j] = 0;
                } else if (s1.charAt(i-1) == s2.charAt(j-1) && i != j) {
                    lrs[i][j] = lrs[i-1][j-1] + 1;
                } else {
                    lrs[i][j] = Math.max(lrs[i-1][j], lrs[i][j-1]);
                }
            }
        }

        return lrs[n][n];
    }   

}