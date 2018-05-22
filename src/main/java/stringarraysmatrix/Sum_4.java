package stringarraysmatrix;

import java.util.*;

/**
 * Created by ts250370 on 4/18/18.
 */
public class Sum_4 {


    public static void main(String[] args) {
        Sum_4 sum_4 = new Sum_4();

//        Set<List<Integer>> result = sum_4.find3Sum(new int[]{-1, 0, 1, 2, 0, 0, -1, -4}, 0);
        List<List<Integer>> result = sum_4.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        System.out.println(result);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> resultSet = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];
            Set<List<Integer>> sol = find3Sum(Arrays.copyOfRange(nums, i, nums.length), remaining);
            for (List<Integer> temp: sol) {
                temp.add(i);
            }
            resultSet.addAll(sol);
        }

        List<List<Integer>> resultList = new ArrayList<>();
        resultList.addAll(resultSet);

        return resultList;
    }

    public Set<List<Integer>> find3Sum(int[] nums, int target) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int l = i +1;
            int r = nums.length - 1;

            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == target) {
                    List<Integer> sol = new ArrayList<>();
                    sol.add(nums[i]);
                    sol.add(nums[l]);
                    sol.add(nums[r]);
                    result.add(sol);
                    l++; r--;
                } else if (nums[i] + nums[l] + nums[r] < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return result;
    }

}
