package stringarraysmatrix;

import java.util.*;

public class SuffixTrie {

    class Node {
        Map<Character, Node> children;
        boolean endWord;
    }
    Node root = new Node();

     public static void main(String []args){
         String [] words = new String[] {
           "abcd"
         };
         //, "abc", "lmn", "abgl"  
         
         SuffixTrie suffixTrie = new SuffixTrie();
         for (String word : words) {
             suffixTrie.insert(word);
         }
        
        System.out.println(suffixTrie.searchWholeWord("lmn"));
     }
     
     void insert(String word) {
         
         Node lastNode = root;
         int countOfChars = 1;
         for (char ch: word.toCharArray()) {
             Node runner = lastNode;
             while (runner.children != null && runner.children.containsKey(ch)) {
                 countOfChars++;
                 runner = runner.children.get(ch);
                 lastNode = runner;
             }
             System.out.println();
             if (lastNode.children == null) {
                lastNode.children = new HashMap<>();
             } 

             countOfChars++;
             Node emptyNode = new Node();
             lastNode.children.put(ch, emptyNode);
             if (countOfChars == word.length()) {
                emptyNode.endWord = true;
            }
         }
         System.out.println(root.children);
     }

     
     boolean searchWholeWord(String word) {
         Node runner = root; 
         Node lastSearchedNode = runner;
         
         char[] charsOfWord = word.toCharArray();
         int matchedCharCount = 0; 
         for (char ch: charsOfWord) {
             if (runner.children != null && runner.children.containsKey(ch)) {
                 runner = runner.children.get(ch);
                 lastSearchedNode = runner;
                 matchedCharCount++;
             }
         }
         
        System.out.println(matchedCharCount);
         return lastSearchedNode.endWord && matchedCharCount == word.length();
     }
}