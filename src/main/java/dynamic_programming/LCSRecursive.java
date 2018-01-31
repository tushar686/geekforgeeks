package dynamic_programming;

public class LCSRecursive{

     public static void main(String []args){
        int len = findLongestCommonSubsequence("abcdaf", "acbcf", 0);
        System.out.println(len);
     }
     
     static int findLongestCommonSubsequence(String s1, String s2, int len) {
         if (s1.length() == 0 || s2.length() == 0) {
             return len;
         }
         if (s1.charAt(0) == s2.charAt(0)) {
             return findLongestCommonSubsequence(s1.substring(1), s2.substring(1), ++len);
         } else {
             return Math.max(
                    findLongestCommonSubsequence(s1.substring(1), s2, len)
                 ,
                    findLongestCommonSubsequence(s1, s2.substring(1), len)
                 );
         }
     }
     
     
}