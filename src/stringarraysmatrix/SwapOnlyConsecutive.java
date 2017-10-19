package stringarraysmatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ts250370 on 10/2/17.
 */
public class SwapOnlyConsecutive {
    public static void main(String[] args) {
        permutation("123456", 0);
    }

    public static void permutation(String s, int start) {
        if(start < s.length()-1) {
            int end = start+1;
            String swapped = swap(s.toCharArray(), start, end);
            System.out.println(swapped);
            if ( (end + 2) < s.length()) {
                permutation(swapped, end+1) ;
            }
        }

        if(start < s.length()-1) {
            permutation(s, start + 1);
        }

    }

    private static String swap(char [] s, int start, int end) {
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        return String.valueOf(s);
    }

}
