package stringarraysmatrix;

public class LCStrRecursive {

     public static void main(String []args){
        int len = findLongestCommonSubstring("abcdaf", "abdf", 0);
        System.out.println(len);
     }
     
     static int findLongestCommonSubstring(String s1, String s2, int len) {
         if (s1.length() == 0 || s2.length() == 0) {
             return len;
         }
         if (s1.charAt(0) == s2.charAt(0)) {
             ++len;
         }
        return findLongestCommonSubstring(s1.substring(1), s2.substring(1), len);
     }
     
     
}