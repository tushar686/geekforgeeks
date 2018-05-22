package stringarraysmatrix;

public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("abcba"));
        System.out.println(isPalindrome("abba"));
        System.out.println(isPalindrome("aa"));
        System.out.println(isPalindrome("aba"));
        System.out.println(isPalindrome("a"));
        System.out.println(isPalindrome("abcab"));
        System.out.println(isPalindrome("abab"));
    }

    static boolean isPalindrome(String input) {
        if (input.length() == 1) {
            return true;
        } else {
            int mid = input.length() / 2;
            if (input.length() % 2 == 0) {
                for (int i=0; i<mid; i++) {
                    if (input.charAt(mid + i) != input.charAt(mid - (i + 1))  ){
                        return false;
                    }
                }
            } else {
                for (int i=1; i<mid; i++) {
                    if (input.charAt(mid + i) != input.charAt(mid - i) ){
                        return false;
                    }
                }
            }
        }

        return true;
    }
}