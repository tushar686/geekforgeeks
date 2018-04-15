package bits;


import java.util.Calendar;

public class ReverseBits {

    public static void main(String[] args) {
        long start = Calendar.getInstance().getTimeInMillis();
        ReverseBits solution = new ReverseBits();
        int pos = solution.reverseBits(1); //43261596  -  964176192
        System.out.println(pos);
    }

    public int reverseBits(int n) {
        int result = 0;
        for (int i=1; i<33; i++) {
            int lastBit = n & 1;
            n = n >>> 1;
            if (lastBit == 1) {
                result = (result | ( 1 << (31 - (i- 1) ) ) );
            }
        }

        return result;
    }
}