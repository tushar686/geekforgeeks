package arrays;


import java.util.Calendar;

public class ZigzagConversion {

    public static void main(String[] args) {
        long start = Calendar.getInstance().getTimeInMillis();
        ZigzagConversion solution = new ZigzagConversion();
        solution.convert("PA", 2);
//        solution.convert("PAYPALISHIRING", 3);
//        solution.convert("PAYPALISHIRINGOK", 4);
//        solution.convert("PAYPALISHIRINGAISGOOD", 5);

//        P   A   H   N
//        A P L S I I G
//        Y   I   R

//        P       I       N
//        A    L  S    I  G
//        Y  A    H  R    O
//        P       I       K

//        P         H         S
//        A      S  I      I  G
//        Y    I    R    A    O
//        P  L      I  G      O
//        A         N         D
    }

    public String convert(String s, int numRows) {
        StringBuilder sd = new StringBuilder();
        if (numRows == 1) {
            sd.append(s);
            return sd.toString();
        }
        if (s == null || s.length() == 0) {
            return s;
        }

        int sl = numRows - 2;
        for (int row = 0; row < numRows; row++) {
            boolean goDown = row == numRows -1 ? false : true;
            for (int i = row; i < s.length();  ) {
                int skip = 0;
                if (goDown) {
                    int down = numRows - row;
                    int up = sl - row;
                    skip = down + up;
                } else {
                    int down = row;
                    int up = row;
                    skip = down + up;
                }

                goDown = row == 0 || row == numRows -1 ? goDown : !goDown;
                sd.append(s.charAt(i));

                i += skip;
            }
        }

        return sd.toString();
    }
}