package string;

import java.util.Scanner;

public class UniqueChar {

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

//        System.out.println("Is " + input + " a unique? " + isUniqueCharString(input));
        System.out.println("Is " + input + " a unique? " + isUniqueCharStringWithBinary(input));
    }

    private static boolean isUniqueCharString(String input) {
        boolean [] alphabets = new boolean[26];
        for(int i=0; i<input.length(); i++) {
            int ch = input.charAt(i) - 96;
            if(alphabets[ch]) {
                return false;
            }
            alphabets[ch] = true;
        }

        return true;
    }

    private static boolean isUniqueCharStringWithBinary(String input) {
        int flag = 0;
        for(int i=0; i<input.length(); i++) {
            int ch = input.charAt(i) - 96;
            if( (flag & (1 << ch)) > 0 ) //(1 << ch) => get the '1' bit at position between 0 to 26. flag & => comapre if the flag at the bit position is already set
                return false;
            flag |= (1 << ch);
        }

        return true;
    }
}
