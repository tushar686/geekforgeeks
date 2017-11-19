package solutions;

import java.util.*;

class GFG {

    public static void main (String[] args) {
       Scanner sc = new Scanner(System.in);
       int T = sc.nextInt();
       sc.nextLine();
       String[][] input = new String[T][];
       String[] s = new String[1000];
       for (int i=0; i<T; i++) {
           int n = sc.nextInt();
           sc.nextLine();
           input[i] = sc.nextLine().split("\\s+");
           s[i] = sc.nextLine();
       }

        for (int i=0; i<T; i++) {
//            System.out.println(isWordBreak(input[i], s[i]));
//            System.out.println(isWordBreak_Prefixes(input[i], s[i]));
            System.out.println(isWordBreak_Prefixes_DP(input[i], s[i]));
        }
    }

    static int isWordBreak_Prefixes(String[] dict, String word) {
        if (word.length() == 0) {
            return 1;
        }

        for (int i=1; i<=word.length(); i++) {
            if (isDictnoryContrainsWord(dict, word.substring(0, i)) &&
                    1 == isWordBreak_Prefixes(dict, word.substring(i, word.length()))){
                return 1;
            }
        }

        return 0;
    }

    static int isWordBreak_Prefixes_DP(String[] dict, String word) {
        if (word.length() == 0) {
            return 1;
        }

        boolean[] w = new boolean[word.length()+1];

        for (int i=1; i<=word.length(); i++) {

            if (!w[i-1] && isDictnoryContrainsWord(dict, word.substring(0, i))){
                w[i-1] = true;
            }
            if (w[i-1] && i == word.length()) {
                return 1;
            }

            if (w[i-1]) {
                for (int j=i; j<=word.length(); j++) {
                    if (!w[j-1] && isDictnoryContrainsWord(dict, word.substring(i, j))){
                        w[j-1] = true;
                    }
                    if (w[j-1] && j == word.length()) {
                        return 1;
                    }
                }
            }

        }

        return 0;
    }

    static boolean isDictnoryContrainsWord(String[] dict, String word) {
        for (int i=0; i<dict.length; i++) {
            if (dict[i].equals(word))
                return true;
        }
        return false;
    }

    static int isWordBreak(String[] dict, String word) {

        sortDictByLength(dict);
        
        int i = 0;
        while (word.length() > 0 && i < dict.length) {
            if (word.contains(dict[i])) {
                word = word.replaceAll(dict[i],"");
            }
            i++;
        }
        if (word.length() == 0) {
            return 1;
        }

        return 0;
    }

    static void sortDictByLength(String[] dict) {
        for (int i=0; i<dict.length; i++) {
            int maxLengthIndex = i;
            int maxLength = dict[i].length();
            for (int j=i+1; j<dict.length; j++) {
                if (maxLength < dict[j].length()) {
                    maxLengthIndex = j;
                    maxLength = dict[j].length();
                }
            }
            if (maxLengthIndex != i) {
                String bringMeFront = dict[maxLengthIndex];
                dict[maxLengthIndex] = dict[i];
                dict[i] = bringMeFront;
            }
        }
    }
}