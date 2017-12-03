package stringarraysmatrix;

public class LongestPalindromicSubSequence {
    public static void main(String[] args) {
        int length = findLongestPalindromicSubSequence("agbdba");
        System.out.println(length);
    }

    static int findLongestPalindromicSubSequence(String input) {
        int n = input.length();
        int[][] lps = new int[n][n];
        for (int i=0; i<n; i++) {
            lps[i][i] = 1;
        }
        int maxLen = 1;
        for (int len=1; len<n; len++) {
            for (int i=0; i<n-len; i++) {
                int start = i;
                int end = i+len;
                if (input.charAt(start) == input.charAt(end)) {
                    lps[start][end] = 2 + lps[start+1][end-1];
                    if (maxLen < lps[start][end]) {
                        maxLen = lps[start][end];
                    }
                } else {
                    lps[start][end] = Math.max(lps[start][end-1], lps[start+1][end]);
                }
            }
        }
        return maxLen;
    }
}