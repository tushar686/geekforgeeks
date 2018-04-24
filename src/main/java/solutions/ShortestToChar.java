package solutions;

import java.util.*;

/**
 * Created by ts250370 on 4/21/18.
 */
public class ShortestToChar {

    public static void main(String[] args) {
        ShortestToChar shortestToChar = new ShortestToChar();
        shortestToChar.shortestToChar("", 'a');
    }

    public int[] shortestToChar(String S, char C) {
        S = "loveleetcode"; C = 'e'; //3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0

        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int i=0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                map.put(i, 0);
                findShortestDistanceFrom(i, S, map, C);
            }
        }

        int[] result = new int[S.length()];
        int i = 0;
        System.out.println(map);
        for ( int j = 0; j < S.length(); j++ ) {
            result[i++] = map.get(j);
        }

        return result;
    }

    void findShortestDistanceFrom(int i, String S, Map<Integer, Integer> map, char C) {
        int right = i - 1;
        int dist = 1;
        while (right >= 0 && S.charAt(right) != C) {
            if ( map.get(right) != null ) {
                if (dist < map.get(right) ) {
                    map.put(right, dist);
                }
            } else {
                map.put(right, dist);
            }
            dist++;
            right--;
        }

        int left = i + 1;
        dist = 1;
        while ( left < S.length() && S.charAt(left) != C) {
            if ( map.get(left) != null ) {
                if (dist < map.get(left) ) {
                    map.put(left, dist);
                }
            } else {
                map.put(left, dist);
            }
            dist++;
            left++;
        }

    }
}
