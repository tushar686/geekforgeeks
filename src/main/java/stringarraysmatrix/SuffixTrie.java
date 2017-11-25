package stringarraysmatrix;

import java.util.*;

public class SuffixTrie {

    class Node {
        Map<Character, Node> children = new HashMap<>();
        boolean endWord;
    }
    Node root = new Node();

     public static void main(String []args){
         String [] words = new String[] {
           "ablmclmnd", "lmn"
         };
         //, "abc", "lmn", "abgl"  

         String word = "ablmclmnd";

         SuffixTrie suffixTrie = new SuffixTrie();
         for (int k=0; k<words.length; k++) {
             word = words[k];
             for (int i = -1; i < word.length(); i++) {
                 Node lastNode = suffixTrie.root;
                 for (int j = i + 1; j < word.length(); j++) {
                     lastNode = suffixTrie.insert(word.charAt(j), j == word.length() - 1, lastNode);
                 }
             }
         }
         System.out.println(suffixTrie.searchPattern("lmc"));
         System.out.println(suffixTrie.searchWholeWord("lmn"));
     }
     
     Node insert(char ch, boolean isWordEnd, Node lastNode) {
         if (lastNode.children.containsKey(ch)) {
             lastNode = lastNode.children.get(ch);
             if (isWordEnd) {
                 lastNode.endWord = isWordEnd;
             }
             return lastNode;
         }

         Node emptyNode = new Node();
         emptyNode.endWord = isWordEnd;
         lastNode.children.put(ch, emptyNode);
         return emptyNode;
     }

     
     boolean searchWholeWord(String word) {
         Node runner = root;
         Node lastSearchedNode = root;

         char[] charsOfWord = word.toCharArray();
         int matchedCharCount = 0;
         for (char ch: charsOfWord) {
             if (runner.children.containsKey(ch)) {
                 runner = runner.children.get(ch);
                 lastSearchedNode = runner;
                 matchedCharCount++;
             }
         }

         System.out.println(matchedCharCount);
         return lastSearchedNode.endWord && matchedCharCount == word.length();
     }

    boolean searchPattern(String word) {
        Node runner = root;

        char[] charsOfWord = word.toCharArray();
        int matchedCharCount = 0;
        for (char ch: charsOfWord) {
            if (runner.children.containsKey(ch)) {
                runner = runner.children.get(ch);
                matchedCharCount++;
            }
        }

        System.out.println(matchedCharCount);
        return matchedCharCount == word.length();
    }
}