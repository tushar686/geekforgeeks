package arrays;

class ArrayContainsSubArrayForGivenSum {

    public static void main (String[] args) {
        int[] set = {3, 34, 4, 12, 5, 2};
        System.out.println(isSubsetSum(set, set.length - 1, 27));
    }

    static boolean isSubsetSum(int[] set, int n, int sum) {
        if (sum == 0) {
            return true;
        }
        if (n < 0 && sum != 0) {
            return false;
        }

        return isSubsetSum(set, n - 1, sum) || isSubsetSum(set, n-1, sum - set[n]);
    }

}