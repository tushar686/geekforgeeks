package stringarraysmatrix;

public class ZArrayPatternMatching {
    public static void main(String[] args) {
        ZArrayPatternMatching zArrayPatternMatching = new ZArrayPatternMatching();
        int [] zArray = zArrayPatternMatching.buildZArrayUsingBruteForce("abababab");
        zArray = zArrayPatternMatching.buildZArrayUsingBruteForce("aaaaaa");
        zArray = zArrayPatternMatching.buildZArrayUsingBruteForce("aabaacd");
    }

    int [] buildZArrayUsingBruteForce(String pattern) {
        int [] zArray = new int[pattern.length()];

        zArray[0] = -1;
        for (int i=1; i<pattern.length(); i++) {
            int longestPrefixLength = 0;
            int startPosition = 0;
            for (int j=i; j<pattern.length(); j++) {
               if (pattern.charAt(startPosition) == pattern.charAt(j)) {
                   startPosition++;
                   longestPrefixLength++;
               } else {
                   break;
               }
            }
            zArray[i] = longestPrefixLength;
        }

        printZArray( zArray, pattern);
        return zArray;
    }

    void printZArray(int[] zArray, String pattern) {
        System.out.println();
        for (int i=0; i<pattern.length(); i++) {
            System.out.print(pattern.charAt(i) + " ");
        }
        System.out.println();
        for (int ele : zArray) {
            System.out.print(ele + " ");
        }
    }
}