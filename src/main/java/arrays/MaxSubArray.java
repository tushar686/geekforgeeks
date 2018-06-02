package arrays;

/**
 * Created by ts250370 on 6/1/18.
 */
public class MaxSubArray {

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); //6
        System.out.println(maxSubArray.maxSubArray(new int[]{1, 2})); //3
        System.out.println(maxSubArray.maxSubArray(new int[]{-1, -2})); //-2
        System.out.println(maxSubArray.maxSubArray(new int[]{8,-19,5,-4,20})); //21
        System.out.println(maxSubArray.maxSubArray(new int[]{-1, 1, 2, 1})); //4
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            currentSum += current;

            if (currentSum <= 0 || currentSum < current) {
                currentSum = current;
            }

            maxSum = currentSum > maxSum ? currentSum : maxSum;

        }

        return maxSum;
    }
}
