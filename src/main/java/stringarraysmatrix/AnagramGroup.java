package stringarraysmatrix;
// # Group a list of words into a list of lists of words by anagrams
// # Anagram - a word, phrase, or name formed by rearranging the letters of another, such as cinema, formed from iceman.
// # Input: 'dog', 'elvis', 'forest', 'fortes', 'foster', 'goat', 'god', 'heros', 'horse', 'lives', 'shore', 'softer'
// # Output: [
// #  ['elvis', 'lives'],
// #  ['forest', 'fortes', 'foster', 'softer'],
// #  ['heros', 'horse', 'shore'],
// #  ['dog', 'god'],
// #  ['goat']
// #]

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AnagramGroup {
    public static void main(String args[] ) throws Exception {
        String [] input = new String[] {"dog", "elvis", "forest", "fortes", "foster", "goat", "god", "heros", "horse", "lives", "shore", "softer"};
        AnagramGroup solution = new AnagramGroup();
        List<List<String>> result  = solution.groupByAnagram(input);
        for (List anagramGroup : result) {
            System.out.println(anagramGroup);
            
        }
    }
    
    public List<List<String>> groupByAnagram(String[] input) {
        List<List<String>> result = new ArrayList<>();
        Map<Long, List<String>> hashToWord = new HashMap<>();
        
        if (input == null || input.length == 0) {
            return result;
        }
        
        for (int i=0; i < input.length; i++) {
            String current = input[i].toLowerCase();
            //replace hash with more allowable range
            long currentHash = 0;
            // http://www.unit-conversion.info/texttools/ascii/
            for (char ch: current.toCharArray()) {
                int shiftBy = ch - 65;
                currentHash = currentHash | (1 << shiftBy);
            }
            List<String> existingGroup = hashToWord.get(currentHash);
            if (existingGroup == null) {
                existingGroup = new ArrayList<>();
            }
            existingGroup.add(input[i]);
            hashToWord.put(currentHash, existingGroup);
        }
        
        for (List<String> anagramList : hashToWord.values()) {
            result.add(anagramList);
        }
        
        return result;
    }
}
