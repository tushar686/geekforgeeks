package bits;

public class Bits {
    public static void main(String[] args) {
        System.out.println(-3 >> 1);        
    }

    public String convertDecToBase(long number, int base) {
        String result = "";

        long quotient = number;
        
        while (quotient > 0) {
            result = quotient % base + result;
            quotient = quotient / base;
        }

        return result;
    }
}