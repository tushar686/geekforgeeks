package solutions;


import java.util.Calendar;

public class RoateStringToMatchWithAnother {

    public static void main(String[] args) {
        long start = Calendar.getInstance().getTimeInMillis();
        RoateStringToMatchWithAnother solution = new RoateStringToMatchWithAnother();

        boolean result = solution.rotateString("abcde", "cdeab");
        System.out.println(result);
        result = solution.rotateString("abcde", "abced");
        System.out.println(result);
        result = solution.rotateString("abcde", "cdehb");
        System.out.println(result);
        result = solution.rotateString("amcde", "cdeab");
        System.out.println(result);
    }

    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }

        int[] charsA = new int[128];

        for (char c: A.toCharArray()) {
            charsA[c] = charsA[c] + 1;
        }
        for (char c: B.toCharArray()) {
            if (charsA[c] > 0) {
                charsA[c] = charsA[c] - 1;
            } else {
                return false;
            }
        }
        for (int countOfCharA: charsA) {
            if (countOfCharA > 0) {
                return false;
            }
        }
        return rotateAndCompare(A, B, 0);
    }

    private boolean rotateAndCompare(String A, String B, int rotatedTimes) {

        if (A.equals(B)) {
            return true;
        }
        if (rotatedTimes == A.length()) {
            return A.equals(B);
        }

        A = A.substring(1, A.length()) + A.substring(0, 1);
        return rotateAndCompare(A, B, ++rotatedTimes);
    }

}