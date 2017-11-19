package hackerrank;

import java.util.Scanner;

class InterLeavedStrict {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] input = new String[T];
        sc.nextLine();
        for (int i=0; i<T; i++) {
            input[i] = sc.nextLine();
        }

        for (int i=0; i<T; i++) {
            String str1 = input[i].split("\\s+")[0];
            String str2 = input[i].split("\\s+")[1];
            String mainStr = input[i].split("\\s+")[2];
            if (mainStr.length() >= str1.length() && mainStr.length() >= str2.length()) {
                boolean interleaved = buildZArrayInLinearTime(str1 + "$" + mainStr, str1);
                if (interleaved) {
                    interleaved = buildZArrayInLinearTime(str2 + "$" + mainStr, str2);
                    if (interleaved) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                } else {
                    System.out.println(0);
                }
            } else {
                System.out.println(0);
            }
        }

    }

    public boolean isInterLeave(String a,String b,String c) {
        if (c.length() >= a.length() && c.length() >= b.length()) {
            boolean interleaved = buildZArrayInLinearTime(a + "$" + c, a);
            if (interleaved) {
                return buildZArrayInLinearTime(b + "$" + c, b);
            }
        }
        return false;
    }



    static boolean buildZArrayInLinearTime(String input, String pattern) {
        int [] zArray = new int[input.length()];
        zArray[0] = -1;

        int l = 0;
        int r = 0;
        for (int k=1; k<input.length(); k++ ) {
            if (k > r) {
                while (k + (r-l) < input.length() && r < input.length() && input.charAt(k + (r-l))  == input.charAt(r)) {
                    r = r + 1;
                }
                zArray[k] = r - l;
                if (zArray[k] == pattern.length()) {
                    return true;
                }
                if ( (r-l) > 1) {
                    r = k + (r-l) - 1;
                    l = k;
                } else {
                    l = 0;
                    r = 0;
                }
            } else {
                int prevZArrayValue = zArray[k-l];
                if ( k+prevZArrayValue > r ) {
                    l = 0;
                    r = r - k + 1; //set r to char next of already matched prefix
                    k = k - 1;   //we have not processed this index so lets start iteration from it
                } else {
                    zArray[k] = prevZArrayValue;
                    if (zArray[k] == pattern.length()) {
                        return true;
                    }
                    if (k == r) {
                        l = 0;
                        r = 0;
                    }
                }
            }
        }
        return false;
    }

}