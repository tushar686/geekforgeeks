package stringarraysmatrix;

public class LCP {

     public static void main(String []args){
        int lcp = findLongestPalindromeSubsequence("agbdba");
        System.out.println(lcp);
     }
     
    static int findLongestPalindromeSubsequence(String s) {
        int maxLen = 0;
        int [][] LCP = new int[s.length()][s.length()];
        for (int i=0; i<s.length(); i++) {
		LCP[i][i] = 1;        
        }

	int n = s.length();
        for (int l=1; l<n; l++) {
        	for (int j=0; j<n-l; j++) {
        		if (s.charAt(j) == s.charAt(j+l)) {
        			LCP[j][j+l] = 2 + LCP[j+1][j+l-1];
        		} else {	
        			LCP[j][j+l] = Math.max( LCP[j][j+l-1], LCP[j+1][j+l] );
        		}
        		if (LCP[j][j+l] > maxLen) {
	        		maxLen = LCP[j][j+l];
        		}
        	}
        }
        
        return maxLen;
    }
     
}