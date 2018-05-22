package bits;

/**
 * Created by ts250370 on 2/16/18.
 */
public class NextPowerOfTwo {

    public static void main(String[] args) {
//        usingLog(5);
//        usingShift(5);
        usingSettingAllBitsPlusOne(5);
    }

    private static void usingSettingAllBitsPlusOne(int n) {
        int nLessOne = n - 1; //flip all bits after right most 1 (inclusive)

        int nLessOneComplement = ~nLessOne;

        n = nLessOne | nLessOneComplement;

        System.out.println(n + 1);

    }

    private static void usingShift(int n) {
        int p = 1;
        while ( p < n ) {
            p = p << 1;
        }
        System.out.println(p);
    }

    private static void usingLog(int n) {
        double pos = Math.ceil( Math.log(n) / Math.log(2) );

        System.out.println(Math.pow(2, pos));

    }
}
