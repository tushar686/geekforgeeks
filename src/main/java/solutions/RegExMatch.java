package solutions;


import java.util.Calendar;

public class RegExMatch {

    public static void main(String[] args) {
        long start = Calendar.getInstance().getTimeInMillis();
        RegExMatch solution = new RegExMatch();
        solution.isMatch("", "");

    }

    public boolean isMatch(String s, String p) {
        // s = "aab"; p="c*a*b";
        s = "aaa"; p="ab*a*c*a";
        boolean[][] sol = new boolean[s.length()+1][p.length()+1];
        sol[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt( i - 1) == '*') {
                sol[0][i] = sol[0][i-2];
            } else {
                sol[0][i] = false;
            }
        }
        for (int i = 1; i <= s.length(); i++) {
            sol[i][0] = false;
        }

        for (int r = 1; r <= s.length(); r++) {
            for (int c = 1; c <= p.length(); c++) {
                if (s.charAt(r - 1) == p.charAt(c -1) || p.charAt(c -1) == '.') {
                    sol[r][c] = sol[r - 1][c - 1];
                } else if (p.charAt(c -1) == '*') {
                    if (sol[r][c-2]) {  //does it match with zero char of a*
                        sol[r][c] = true;
                    } else if (s.charAt(r - 1) == p.charAt(c - 2) || p.charAt(c -2) == '.') {
                        sol[r][c] = sol[r - 1][c];
                    } else {
                        sol[r][c] = false;
                    }
                } else {
                    sol[r][c] = false;
                }
            }
        }

        return sol[s.length()][p.length()];
    }
}