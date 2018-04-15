package solutions;

/**
 * Created by ts250370 on 4/12/18.
 */
public class MinWindow {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        String minWindow = findMinWindow(s, t);
        System.out.println(minWindow);
    }

    private static String findMinWindow(String s, String t) {
        int[] tChar = new int[128];

        for (char ch: t.toCharArray()) {
            tChar[ch] += 1;
        }

        int start = 0; int end = 0;
        int counter = t.length();

        int minLength = Integer.MAX_VALUE; int minStart = 0;

        while (end < s.length()) {
            if (tChar[s.charAt(end)] > 0 ) {
                counter--;  //counter
            } else {
                tChar[ s.charAt(end) ] -= 1; //for non t char this will become negative
            }

            while (counter == 0) { //we found valid window now let narrow it using start
                if (minLength > (end - start) ) {
                    minLength = end - start;
                    minStart = start;
                }
                tChar[ s.charAt(start) ] += 1;
                if (tChar[ s.charAt(start) ] > 0 ) {
                    counter++;
                }
                start++;
            }

            end++;
        }

        if (minLength != Integer.MAX_VALUE)
            return s.substring(minStart, minStart + minLength + 1);
        return "";
    }
}
