package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ts250370 on 3/1/18.
 */
public class CombinationOfElementsUsingBits {
    public static void main(String[] args) {
        CombinationOfElementsUsingBits solution = new CombinationOfElementsUsingBits();
        List<List<Integer>> result = solution.subsets(new int[]{1, 2, 3});

        System.out.println(result);
    }

    public List<List<Integer>> subsets(int[] nums) {

        Set<List<Integer>> resultSet = new HashSet<>();

        int n = nums.length;

        for (int i=0; i<Math.pow(2, n); i++) {
            List<Integer> combination = new ArrayList<>();
            if (i != 0) {
                int counter = 0;
                while (counter < n) {
                    if ( ((i >> counter) & 1) == 1) {
                        combination.add(nums[counter]);
                    }
                    counter++;
                }
            }
            resultSet.add(combination);
        }

        List<List<Integer>> result = new ArrayList<>();
        result.addAll(resultSet);

        return result;
    }
}
