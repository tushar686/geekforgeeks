package solutions;

import java.util.Calendar;

/**
 * Created by ts250370 on 2/2/18.
 */
public class EggDropProblem {
    static long count = 0;
    public static void main(String[] args) {
        int eggs = 2;
        int floors = 100;

        long start = Calendar.getInstance().getTimeInMillis();
        int minTries = eggDrop(eggs, floors, new int[1000][1000]);
        System.out.println(minTries);
        System.out.println(count);
        System.out.println("Time taken: " + (Calendar.getInstance().getTimeInMillis() - start) / 1000);
    }

    private static int eggDrop(int eggs, int floors, int[][] mem) {
        if (eggs == 1) {
            return floors;
        }
        if (floors == 1 || floors == 0) {
            return floors;
        }
        if (mem[eggs][floors] != 0) {
            return mem[eggs][floors];
        }

        count++;

        int min = Integer.MAX_VALUE;

        for (int x=1; x<=floors; x++) {
            int max = Math.max(
                            eggDrop(eggs - 1, x - 1, mem),
                            eggDrop(eggs, floors - x, mem)
                        );
            if (max < min) {
                min = max;
            }
        }
        mem[eggs][floors] = min + 1;
        return min + 1;
    }
}
