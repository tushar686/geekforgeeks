package stringarraysmatrix;

/**
 * Created by ts250370 on 8/15/17.
 */
public class Power {

    public static void main(String[] args) {
        Power power = new Power();
        System.out.println(power.pow(3, 18));
    }

    private long pow(long x, long y) {
        if ( y == 1)
            return x;

        y = y / 2;
        x = x * x;

        long ans = pow(x, y);
        if( y != 1 && y % 2 != 0) {
            ans = ans * x;
        }
        return ans;
    }
}
