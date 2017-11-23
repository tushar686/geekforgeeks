package solutions;

import java.util.Scanner;

class FindLargestWordInDictionary {

    public static void main (String[] args) {
       Scanner sc = new Scanner(System.in);
       int T = sc.nextInt();
       sc.nextLine();
       String[][] dict = new String[T][];
       String[] word = new String[T];
       for (int i=0; i<T; i++) {
           sc.nextLine();
           dict[i] = sc.nextLine().split("\\s+");
           word[i] = sc.nextLine();
       }

        for (int i=0; i<T; i++) {
            String longestDictWordFormed = findLongestSubsequence(word[i], dict[i]);
            System.out.println(longestDictWordFormed);
        }
    }

    static String findLongestSubsequence(String word, String[] dict) {
        String longestSubsequenceSoFar = "";
        for (int i=0; i<dict.length; i++) {
            String currentLongestSubSequence = getLongestSubSequence(word, dict[i]);
            if (currentLongestSubSequence.equals(dict[i])) {
                if (currentLongestSubSequence.length() > longestSubsequenceSoFar.length()) {
                    longestSubsequenceSoFar = currentLongestSubSequence;
                }
            }
        }

        return longestSubsequenceSoFar;
    }

    static String getLongestSubSequence(String word, String dictWord) {
        int[][] LCS = new int[word.length()+1][dictWord.length()+1];

        for (int i=0; i<word.length(); i++) {
            LCS[i][0] = 0;
        }
        for (int i=0; i<dictWord.length(); i++) {
            LCS[0][i] = 0;
        }

        int maxLen = 0;
        String longestString = "";
        for (int i=0; i<word.length(); i++) {
            for (int j=0; j<dictWord.length(); j++) {
                if (word.charAt(i) == dictWord.charAt(j)) {
                    LCS[i+1][j+1] = 1 + LCS[i][j];
                } else {
                    LCS[i+1][j+1] = Math.max(LCS[i+1][j], LCS[i][j+1]);
                }

                if (maxLen < LCS[i+1][j+1] ) {
                    maxLen = LCS[i+1] [j+1];
                }
            }
        }

        int i = LCS.length-1;
        int j = LCS[i].length-1;
//        System.out.println(word + " " + dictWord);
        while (i > 0 && j > 0) {
            if ((LCS[i - 1][j - 1] == LCS[i - 1][j]) && (LCS[i - 1][j - 1] == LCS[i][j - 1])) {
                longestString = word.charAt(i-1) + longestString;
                i--;
                j--;
            } else {
                if (LCS[i][j-1] > LCS[i-1][j]) {
                    j--;
                } else if (LCS[i-1][j] > LCS[i][j-1]) {
                    i--;
                }
            }

        }

        return longestString;
    }

    
}