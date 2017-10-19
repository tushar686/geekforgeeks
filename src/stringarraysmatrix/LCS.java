package stringarraysmatrix;

public class LCS {

     public static void main(String []args){
        int lcs = findLongestCommonSubsequence("abcdaf", "acbcf");
        System.out.println(lcs);
     }
     
    static int findLongestCommonSubsequence(String s1, String s2) {
	int[][] LCS = new int[s1.length()+1][s2.length()+1];
	
	for (int i=0; i<s1.length(); i++) {
		LCS[0][i] = 0;
	}
	for (int i=0; i<s2.length(); i++) {
		LCS[i][0] = 0;
	}
	
	int maxLen = 0;
	for (int i=0; i<s1.length(); i++) {
		for (int j=0; j<s2.length(); j++) {
			if (s1.charAt(i) == s2.charAt(j)) {
				LCS[i+1][j+1] = 1 + LCS[i][j];
			} else {
				LCS[i+1][j+1] = Math.max(LCS[i+1][j], LCS[i][j+1]);
			}
			
			if (maxLen < LCS[i+1][j+1] ) {
				maxLen = LCS[i+1] [j+1];
			}
		}
	}
	return maxLen;
    }
}