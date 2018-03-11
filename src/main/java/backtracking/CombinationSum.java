package backtracking;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        long start = Calendar.getInstance().getTimeInMillis();
        CombinationSum solution = new CombinationSum();

//        List<List<Integer>> result = solution.combinationSum(new int[]{2, 3, 6, 7}, 7);
//        List<List<Integer>> result = solution.combinationSum(new int[]{1, 2}, 1);
        List<List<Integer>> result = solution.combinationSum(new int[]{2,3,5}, 8); //[[2,2,2,2],[2,3,3],[3,5]]
//        List<List<Integer>> result = solution.combinationSum(new int[]{7,3,2}, 18); //[[2,2,2,2,2,2,2,2,2],[2,2,2,2,2,2,3,3],[2,2,2,2,3,7],[2,2,2,3,3,3,3],[2,2,7,7],[2,3,3,3,7],[3,3,3,3,3,3]]
        System.out.println(result);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if(candidates == null || candidates.length == 0)
            return result;

        Arrays.sort(candidates);

        List<Integer> current = new ArrayList<Integer>();
        combinationSum(candidates, target, 0, current, result);

        return result;
    }

    public void combinationSum(int[] candidates, int target, int j, List<Integer> curr, List<List<Integer>> result){
        if(target == 0){
            ArrayList<Integer> temp = new ArrayList<Integer>(curr);
            result.add(temp);
            return;
        }

        for(int i=j; i<candidates.length; i++){
            if(target < candidates[i])
                return;

            curr.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], i, curr, result);
            curr.remove(curr.size()-1);
        }
    }
}