package stringarraysmatrix;

import java.util.*;

/**
 * Created by ts250370 on 4/14/18.
 */
public class LongestConsequtiveSequence {

    public static void main(String[] args) {
        int[] in = new int[]{2, 1, 6, 9, 4, 3};
        int result = findLongestConsequtiveSeq(in);
        System.out.println(result);
    }


    private static int findLongestConsequtiveSeq(int[] in) {
        int maxLength = 0;

        Arrays.sort(in);

        int len = 1;
        for (int i = 0; i < in.length; i++) {
            if (i+1 < in.length) {
                if (in[i+1] - in[i] == 1) {
                    len++;
                } else {
                    len = 1;
                }
            } else {
                len = 1;
            }

            if (len > maxLength) {
                maxLength = len;
            }
        }

        return maxLength;
    }
}
