package solutions;


import java.util.*;

public class Solution {

    public static void main(String[] args) {
        long start = Calendar.getInstance().getTimeInMillis();
        Solution solution = new Solution();
        boolean r = solution.isPalindrome(1221);
        System.out.println(r);
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int len = -1;
        int num = x;
        while (num != 0) {
            num = num / 10;
            len++;
        }
        System.out.println(len);

        num = x;
        int limit = len;
        while (len > 0) {
            int left = num  / ((int) Math.pow(10, len));
            int right = num % 10;
            System.out.println("num: " + num);
            System.out.println("\tleft: " + left + " right: " + right);
            if (left != right) {
                return false;
            }
            num = num - (((int) Math.pow(10, len)) * left) ;
            System.out.println(num);
            num = num / 10;
            System.out.println(num);
            len = len - 2;
        }


        return true;
    }
}