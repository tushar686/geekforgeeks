package solutions;


import java.util.*;

public class IsIntPalindrome {

    public static void main(String[] args) {
        long start = Calendar.getInstance().getTimeInMillis();
        IsIntPalindrome solution = new IsIntPalindrome();
        int r = solution.threeSumClosest(new int[]{1, 2}, 100);
        System.out.println(r);
    }

    public int threeSumClosest(int[] nums, int target) {
        // nums = new int[]{0, 1, 2};
        // target = 3;
        // nums = new int[]{0, 0, 0};
        // target = 1;
        // nums = new int[]{1, 1, 1, 0};
        // target = 100;
//        nums = new int[]{1, 1, 1, 0};
//        target = -100;
        nums = new int[]{0, 2, 1, -3};
        target = 1;
        int closetSoFar = 0;
        if (nums.length > 2) {
            Arrays.sort(nums);
            closetSoFar = nums[0] + nums[1] + nums[2];
            for (int i = 0; i < nums.length - 2; i++) {
                int l = i + 1;
                int r = nums.length - 1;

                while (l < r) {
                    int currentSum = (nums[i] + nums[l] + nums[r]);
                    if (currentSum  == target ) {
                        closetSoFar = currentSum;
                        l++;
                        r--;
                    } else if ( Math.abs(target - currentSum) < Math.abs(target)) {
                        if ( Math.abs(target - currentSum) < Math.abs(target - closetSoFar)) {
                            closetSoFar = currentSum;
                        }
                        l++;
                    } else {
                        if ( Math.abs(target - currentSum) < Math.abs(target - closetSoFar)) {
                            closetSoFar = currentSum;
                        }
                        r--;
                    }
                }
            }

        }

        return closetSoFar;
    }
}