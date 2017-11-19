package stringarraysmatrix;

public class ZArrayPatternMatching {
    public static void main(String[] args) {
        ZArrayPatternMatching zArrayPatternMatching = new ZArrayPatternMatching();
        int [] zArray = zArrayPatternMatching.buildZArrayUsingBruteForce("aabxaabxcaabxaabxay");
        System.out.println();
        System.out.println();
//        zArray = zArrayPatternMatching.buildZArrayInLinearTime("aabxaabxcaabxaabxay");
        zArray = zArrayPatternMatching.buildZArrayInLinearTime("YX$XXY");
        // zArray = zArrayPatternMatching.buildZArrayUsingBruteForce("abababab");
        // zArray = zArrayPatternMatching.buildZArrayUsingBruteForce("aaaaaa");
        // zArray = zArrayPatternMatching.buildZArrayUsingBruteForce("aabaacd");
    }

    int [] buildZArrayInLinearTime(String pattern) {
        int noOfComparisions = 0;
        int [] zArray = new int[pattern.length()];
        zArray[0] = -1;

        int l = 0;
        int r = 0;
        for (int k=1; k<pattern.length(); k++ ) {
                if (k > r) {
                    while (pattern.charAt(k + (r-l))  == pattern.charAt(r)) {
                        r = r + 1;
                    }
                    zArray[k] = r - l;
                    if ( (r-l) > 1) {
                        r = k + (r-l) - 1;
                        l = k;
                    } else {
                        l = 0;
                        r = 0;
                    }
                } else {
                    // 0       4       0 9          13 13              17
                    // 0       0 4     0 0          9  13              13
                    // 0 0 0 0 7       0 16         16 17
                    // 0 0 0 0 0 7     0 0          16 16              17
                    // a a b x a a b x c a a  b  x  a      a  b  x     a      y
                    // 0 1 2 3 4 5 6 7 8 9 10 11 12 13     14 15 16    17     18
                    // 0 1 0 0 4 1 0 0 0 8 1  0  0  -1
                    //

                    int prevZArrayValue = zArray[k-l];
                    if ( k+prevZArrayValue > r ) {
                        l = 0;
                        r = r - k + 1; //set r to char next of already matched prefix
                        k = k - 1;   //we have not processed this index so lets start iteration from it
                    } else {
                        zArray[k] = prevZArrayValue;
                        if (k == r) {
                            l = 0;
                            r = 0;
                        }
                    }
                }
        }
        System.out.println("No Of Comparisions: " + noOfComparisions);
        printZArray(zArray, pattern);
        return zArray;
    }

    int [] buildZArrayUsingBruteForce(String pattern) {
        int [] zArray = new int[pattern.length()];

        zArray[0] = -1;
        int noOfComparisions = 0;
        for (int i=1; i<pattern.length(); i++) {
            int longestPrefixLength = 0;
            int startPosition = 0;
            for (int j=i; j<pattern.length(); j++) {
               noOfComparisions++;
               if (pattern.charAt(startPosition) == pattern.charAt(j)) {
                   startPosition++;
                   longestPrefixLength++;
               } else {
                   break;
               }
            }
            zArray[i] = longestPrefixLength;
        }
        System.out.println("No Of Comparisions: " + noOfComparisions);
        printZArray(zArray, pattern);
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