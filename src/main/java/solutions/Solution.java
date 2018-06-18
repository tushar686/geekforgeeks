package solutions;


import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths(7, 3));
    }

    public int uniquePaths(int m, int n) {
        return calculatePaths(0, 0, m, n);
    }

    int calculatePaths(int i, int j, int m, int n) {
        if (i == m-1 && j == n-1) {
            return 1;
        }
        if (i == m || j == n || i > m || j > n) {
            return 0;
        }


        return calculatePaths(i+1, j, m, n) + calculatePaths(i, j+1, m, n);
    }


}