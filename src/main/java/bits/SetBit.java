package bits;

/**
 * Created by ts250370 on 9/14/17.
 */
public class SetBit {

    public static void main(String[] args) {
//        System.out.println(3^(1<<0));

        int max = ~0;
//        printBinary(max);
//        printBinary((1 << 3));
//        printBinary( ((1 << 3)) -1);
//        printBinary(max - (((1 << 3)) - 1));
        int i=2; int j=6;
//        printBinary(max - (((1 << j)) - 1));
//        printBinary(((1 << i))-1);
//        printBinary( (max - (((1 << j)) - 1)) | (((1 << i))-1) );
//        setSubBits(2560, 160, 4, 7);
//        setSubBits(1024, 84, 2, 6);
//          setSubBits_Better(2560, 160, 4, 7);
          setSubBits_Better(1024, 84, 2, 6);

    }

    static void printBinary(int x) {
        System.out.println(Integer.toBinaryString(x));
    }

    static void setSubBits_Better(int N, int M, int start, int end) {

        int max = ~0;

        int left = max - ((1 << end) -1);
        int right = ((1 << start) - 1);
        int mask = left | right;
        printBinary(left);
        printBinary(right);
        printBinary(mask);

        printBinary(N);
        N = N & mask;
        printBinary(N);
        printBinary(N | M);
        System.out.println(N | M);
    }

    static void setSubBits(int N, int M, int start, int end) {
        for (int i=start; i<=end; i++) {
            int n = N & (1 << i);
            int m = M & (1 << i);

            if (m > 0) {
                N = N | m;
            } else {
                if (n == 0) {
                    N = N ^ 0;
                } else {
                    N = N ^ 1;
                }
            }

        }

        System.out.println(N);
    }
}
