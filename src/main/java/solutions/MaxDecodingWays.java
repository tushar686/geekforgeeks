package solutions;

import java.util.*;

public class MaxDecodingWays {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int T = sc.nextInt();
        // String[] input = new String[T];
        // for (int i=0; i<T; i+=1) {
        //     int n = sc.nextInt();
        //     input[i] = sc.next();
        // }

        // for (int i=0; i<T; i+=1) {
        //     int result = findMaxWaysToDecode(input[i], input[i].length());
        //     System.out.println(result);
        // }

        String input = "1210";
        int result = findMaxWaysToDecode(input, input.length());
        System.out.println(result);
    }

    static int findMaxWaysToDecode(String input, int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int result = 0;

        // If the last digit is not 0, then last digit must add to
        // the number of words
        if (input.charAt(n - 1) != '0')
            result = findMaxWaysToDecode(input, n - 1);

        // If the last two digits form a number smaller than or equal to 26,
        // then consider last two digits and recur
        if (input.charAt(n - 2) == '1' || (input.charAt(n - 2) == '2' && Integer.parseInt(Character.toString(input.charAt(n - 1))) < 7))
            result += findMaxWaysToDecode(input, n - 2);

        return result;
    }

    static int findMaxWaysToDecodeDP(String input, int n) {
        int[] count = new int[n + 1]; // A table to store results of subproblems
        count[0] = 1;
        count[1] = 1;

        for (int i = 2; i <= n; i++) {
            count[i] = 0;

            // If the last digit is not 0, then last digit must add to
            // the number of words
            if (input.charAt(i - 1) > '0')
                count[i] = count[i - 1];

            // If second last digit is smaller than 2 and last digit is
            // smaller than 7, then last two digits form a valid character
            if (input.charAt(i - 2) == '1' || (input.charAt(i - 2) == '2' && input.charAt(i - 1) < '7'))
                count[i] += count[i - 2];
        }
        return count[n];
    }
}