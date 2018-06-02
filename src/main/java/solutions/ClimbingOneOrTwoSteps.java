package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ts250370 on 6/2/18.
 */
public class ClimbingOneOrTwoSteps {

    public static void main(String[] args) {
        ClimbingOneOrTwoSteps climbingOneOrTwoSteps = new ClimbingOneOrTwoSteps();
        climbingOneOrTwoSteps.climbStairs(44);
    }

    public int climbStairs(int n) {
        int result = climbSteps(n, 0, new HashMap());
        System.out.println(result);
        return result;
    }

    private int climbSteps(int n, int steps, Map<Integer, Integer> sol) {
        if (sol.get(steps) != null) {
            return sol.get(steps);
        }
        if (steps == n) {
            return 1;
        }
        if (steps > n) {
            return 0;
        }

        int result =  climbSteps(n, steps + 1, sol) + climbSteps(n, steps + 2, sol);
        sol.put(steps, result);
        return result;
    }

}
