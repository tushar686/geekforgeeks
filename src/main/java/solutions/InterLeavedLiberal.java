package solutions;

import java.util.Scanner;

class InterLeavedLiberal {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] input = new String[T];
        sc.nextLine();
        for (int i=0; i<T; i++) {
            input[i] = sc.nextLine();
        }

        InterLeavedLiberal gfg = new InterLeavedLiberal();

        for (int i=0; i<T; i++) {
            String str1 = input[i].split("\\s+")[0];
            String str2 = input[i].split("\\s+")[1];
            String mainStr = input[i].split("\\s+")[2];
            boolean interleaved = gfg.isInterLeave(str1, str2, mainStr);
            if (interleaved) {
                    System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

    }

    public boolean isInterLeave(String a,String b,String c) {
        if (c.length() >= a.length() && c.length() >= b.length()) {
            boolean interleaved = findLongestCommonSubsequence(a, c);
            if (interleaved) {
                return findLongestCommonSubsequence(b, c);
            }
        }
        return false;
    }



    static boolean findLongestCommonSubsequence(String s1, String s2) {
        int maxSize = Math.max(s1.length(), s2.length());
        int[][] LCS = new int[maxSize+1][maxSize+1];

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
                if (maxLen == s1.length()) {
                    return true;
                }
            }
        }
        return false;
    }

}