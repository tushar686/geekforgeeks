package solutions;

import java.util.Scanner;

class ReArrangeStrings {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        String[] input = new String[T];
        for (int i=0; i<T; i++) {
            input[i] = sc.nextLine();
        }

        for (int i=0; i<T; i++) {
            System.out.println(reArrange(input[i]));
        }
    }


    static String reArrange(String input) {
        int[] counts = new int[36];

        StringBuilder result = new StringBuilder("");
        for (int i=0; i<input.length(); i++) {
            char ch = input.charAt(i);
            if (ch < 58) {
                counts[ch - 48 + 26] += 1;
            } else {
                counts[ch - 65] += 1;
            }
        }

        for (int i=0; i<26; i++) {
            if (counts[i] > 0) {
                while (counts[i] > 0) {
                    result.append((char) (i + 65));
                    counts[i] -= 1;
                }
            }
        }

        int sum = 0;
        for (int i=26; i<36; i++) {
            if (counts[i] > 0) {
                while (counts[i] > 0) {
                    sum += i - 26;
                    counts[i] -= 1;
                }
            }
        }

        result.append(sum);

        return result.toString();
    }
}