package stringarraysmatrix;

public class KMPPatternMatching {

    public static void main(String[] args) {
        KMPPatternMatching kmpPatternMatching = new KMPPatternMatching();
        kmpPatternMatching.search("AAAA", "AAAAA");
        kmpPatternMatching.search("ABCDABD", "ABC ABCDAB ABCDABCDABDE");
        kmpPatternMatching.search("ABCDABD", "ABCABCDABD ABCDABCDABDE");
        kmpPatternMatching.search("ABCDE", "AABBABCDETUSH");
        // kmpPatternMatching.search("AABAACAABAA", "");
        // kmpPatternMatching.search("AAACAAAAAC", "");
        // kmpPatternMatching.search("AAABAAA", "");
    }

    public void search(String pattern, String text) {
        int[] lps = preProcessPattern(pattern);
        int m = 0;
        int i = 0;

        while(m < text.length() && (text.length() > m + i) ) {

            if (pattern.charAt(i) != text.charAt(m + i)) {
                int prefixLength = 0;
                if (i != 0) {
                    prefixLength = lps[i-1];
                }
                if (prefixLength == 0) {
                    if (i == 0) {
                        m = m + 1;
                    }
                    m = m + i;
                    i = 0;
                } else {
                    m = m + i - prefixLength;
                    i = prefixLength;
                }

            } else {
                i++;
            }

            if (i == pattern.length()) {
                System.out.println("\nPattern found at " + m);
                int prefixLength = lps[i-1];
                i = prefixLength;
                m = m + 1;
            }
        }

    }

    public int[] preProcessPattern(String pattern) {
        int[] lps = new int[pattern.length()];
        lps[0] = 0;
        int j = 0;
        for (int i=1; i<pattern.length(); i++) {
            while (j >= 0) {
                if (pattern.charAt(i) == pattern.charAt(j)) {
                    j = j + 1;
                    lps[i] = j;
                    break;
                } else {
                    if (j == 0) {
                        lps[i] = 0;
                        break;
                    }
                    j = lps[j-1];
                }
            }
        }

        printLPS(lps, pattern);
        return lps;
    }

    public void printLPS(int[] lps, String pattern) {
        System.out.println();
        for (char ch : pattern.toCharArray()) {
            System.out.print(ch + " ");
        }
        System.out.println();
        for (int ele : lps) {
            System.out.print(ele + " ");
        }
    }

}