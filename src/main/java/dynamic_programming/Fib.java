package dynamic_programming;

/**
 * Created by ts250370 on 7/31/17.
 */
public class Fib {
    int[] cache = new int[75];

    public static void main(String[] args) {
        Fib fib = new Fib();
        fib.initialize();
        long start = System.currentTimeMillis();
//        fib.fibWithoutCache(45);
        fib.fib(70);
        System.out.println("\n" + (System.currentTimeMillis()-start)/1000);
    }

    private int fibWithoutCache(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int seq = fibWithoutCache(n-1) + fibWithoutCache(n-2);
//        System.out.print(seq + " ");
        return seq;
    }

    private void initialize() {
        cache[0] = 0;
        cache[1] = 1;

        for(int i=2; i<75; i++) {
            cache[i] = -1;
        }
    }

    private int fib(int n) {
        if (cache[n] != -1)
            return cache[n];
        cache[n] = fib(n-1) + fib(n-2);
        return cache[n];
    }

}
