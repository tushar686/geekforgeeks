package arrays;

import java.util.*;

/**
 * Created by ts250370 on 4/18/18.
 */
public class Sum_4 {


    public static void main(String[] args) {
        Sum_4 sum_4 = new Sum_4();

//        Set<List<Integer>> result = sum_4.find3Sum(new int[]{-1, 0, 1, 2, 0, 0, -1, -4}, 0);
//        List<List<Integer>> result = sum_4.fourSum(new int[]{0, 0, 0, 1, 0}, 1);
//        List<List<Integer>> result = sum_4.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        List<List<Integer>> result = sum_4.fourSum(new int[]{-5,5,4,-3,0,0,4,-2}, 4);
        System.out.println(result);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> resultSet = new HashSet<>();

        Map<Integer, List<List<Integer>>> pairMap = buildPairMap(nums);

        Iterator<Map.Entry<Integer, List<List<Integer>>>> iter = pairMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Integer, List<List<Integer>>> pairs = iter.next();
            if (pairs.getKey() == 0) { //hash 0 and -0 is same so map.get(0)/map.get(-0) returns same value
                if (target == 0) {
                    Set<List<Integer>> quadraplesFromThesePairs = buildQuadraples(pairs.getValue(), null, nums);
                    resultSet.addAll(quadraplesFromThesePairs);
                }
            } else {
                List<List<Integer>> oppPairs = pairMap.get(target - pairs.getKey());
                if (oppPairs != null) {
                    Set<List<Integer>> quadraplesFromThesePairs = buildQuadraples(pairs.getValue(), oppPairs, nums);
                    resultSet.addAll(quadraplesFromThesePairs);
                }
            }

        }

        return new LinkedList<>(resultSet);
    }

    private Set<List<Integer>> buildQuadraples(List<List<Integer>> pairs, List<List<Integer>> oppPairs, int[] nums) {
        Set<List<Integer>> quadraplesFromThesePairs = new HashSet<>();

        if (oppPairs != null) {
            for (List<Integer> pair : pairs) {
                for (List<Integer> oppPair : oppPairs) {
                    Set<Integer> quadrapleSet = new HashSet<>();
                    quadrapleSet.add(pair.get(0));
                    quadrapleSet.add(pair.get(1));
                    quadrapleSet.add(oppPair.get(0));
                    quadrapleSet.add(oppPair.get(1));
                    if (quadrapleSet.size() > 3) {
                        List<Integer> quadrapleList = new ArrayList<>();
                        for (Integer index : quadrapleSet) {
                            quadrapleList.add(nums[index]);
                        }
                        Collections.sort(quadrapleList);
                        quadraplesFromThesePairs.add(quadrapleList);
                    }
                }
            }
        } else {
            for (int i = 0; i < pairs.size(); i++) {
                for (int j = i + 1; j < pairs.size(); j++) {
                    Set<Integer> quadrapleSet = new HashSet<>();
                    quadrapleSet.add(pairs.get(i).get(0));
                    quadrapleSet.add(pairs.get(i).get(1));
                    quadrapleSet.add(pairs.get(j).get(0));
                    quadrapleSet.add(pairs.get(j).get(1));
                    if (quadrapleSet.size() > 3) {
                        List<Integer> quadrapleList = new ArrayList<>();
                        for (Integer index : quadrapleSet) {
                            quadrapleList.add(nums[index]);
                        }
                        Collections.sort(quadrapleList);
                        quadraplesFromThesePairs.add(quadrapleList);
                    }
                }
            }
        }

        return quadraplesFromThesePairs;
    }

    public Map<Integer, List<List<Integer>>> buildPairMap(int[] nums) {
        Map<Integer, List<List<Integer>>> pairMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int pairSum = nums[i] + nums[j];
                List<List<Integer>> pairs = pairMap.get(pairSum);
                if (pairs == null) {
                    pairs = new LinkedList<>();
                    pairMap.put(pairSum, pairs);
                }

                List<Integer> pair = new ArrayList<>();
                pair.add(i);
                pair.add(j);
                pairs.add(pair);
            }
        }

        return pairMap;
    }

}
