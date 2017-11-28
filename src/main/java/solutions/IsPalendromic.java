package solutions;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class IsPalendromic {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        String[] input = new String[T];
        for (int i=0; i<T; i++) {
            input[i] = sc.nextLine();
        }
        for (int i=0; i<T; i++) {
            if (isPalindromic(input[i])) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static boolean isPalindromic(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<input.length(); i++) {
            if (input.charAt(i) != ' ') {
                stack.push(input.charAt(i));
            }
        }
        int j = input.length()-1;
        for (int i=0; i<input.length(); i++) {
            if (input.charAt(i) != ' ') {
                if (stack.isEmpty() || (input.charAt(i) != stack.pop())) {
                    return false;
                }
            }
        }
        return true;
    }

}