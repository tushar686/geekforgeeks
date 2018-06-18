package trees.binary;

import java.util.*;

/**
 * Created by ts250370 on 4/21/18.
 */
public class BinaryTreeWithFactors {

    public static void main(String[] args) {
        BinaryTreeWithFactors binaryTreeWithFactors = new BinaryTreeWithFactors();
//        int result = binaryTreeWithFactors.numFactoredBinaryTrees(new int[] {2, 4, 5, 10} ); // 7
        int result = binaryTreeWithFactors.numFactoredBinarydps(new int[] {18, 3, 6, 2} ); // 12
        System.out.println(result);
    }

    public int numFactoredBinarydps(int[] A) {
        long res = 0L, mod = (long) Math.pow(10, 9) + 7;
        Arrays.sort(A);
        HashMap<Integer, Long> dp = new HashMap<>();
        for (int i = 0; i < A.length; ++i) {
            dp.put(A[i], 1L);
            for (int j = 0; j < i; ++j)
                if (A[i] % A[j] == 0 && dp.containsKey(A[i] / A[j]))
                    dp.put(A[i], (dp.get(A[i]) + dp.get(A[j]) * dp.get(A[i] / A[j])) % mod);
        }
        for (long v : dp.values()) res = (res + v) % mod;
        return (int) res;
    }

    public int numFactoredBinaryTrees(int[] A) {
        long numberOfTrees = A.length;

        Map<Integer, Set<Integer>> factors = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int ele : A) {
            set.add(ele);
        }

        for (int ele : A) {
            Set<Integer> factorsOfEle = factors.get(ele);
            if (factorsOfEle == null) {
                factorsOfEle = getFactors(ele);
                factors.put(ele, factorsOfEle);
            }

            for (int oneChild : factorsOfEle) {
                if (set.contains(oneChild)) {
                    int anotherChild = ele / oneChild;
                    if (set.contains(anotherChild) || canBeFormedUsingFactors(factors, anotherChild, set)) {
                        numberOfTrees += 1; //4 2 2
                    }
                }
            }
        }

        return (int) ( numberOfTrees % ((int)(Math.pow(10, 9) + 7)) );
    }

    private boolean canBeFormedUsingFactors(Map<Integer, Set<Integer>> factors, int ele, Set<Integer> set) {
        Set<Integer> factorsOfEle = factors.get(ele);
        if (factorsOfEle == null) {
            factorsOfEle = getFactors(ele);
            factors.put(ele, factorsOfEle);
        }

        for (int oneChild : factorsOfEle) {
            if (set.contains(oneChild)) {
                int anotherChild = ele / oneChild;
                return (set.contains(anotherChild) || canBeFormedUsingFactors(factors, anotherChild, set));
            }
        }

        return false;
    }

    private Set<Integer> getFactors(int ele) {
        Set<Integer> factorsOfEle = new HashSet<>();
        for (int i=2; i <= Math.sqrt(ele); i++ ) {
            if (ele % i == 0) {
                if (i != ele)
                    factorsOfEle.add(i);
                if ( (ele/i) >= 2 && (ele/i) != ele )
                    factorsOfEle.add(ele/i);
            }
        }
        return factorsOfEle;
    }
}
