package string;

import java.util.*;

// // Given a array
// [ {"abc", 1}, {"shdkcs", 10}, {"car", 2}, {"club", 6} .... ]

// // Input c

// "car", 2
// "club", 6


// char priority
// Map
// Set<char>, priority :

// set - words
// set.contains(c); o(1)
// hashset

// c
// o(n)
// nlong

// group by starting char
//   order by priority

// map
// a
// b
// scan
// sort by priority - > nlogn
// same priority sorting on the words -> nlogn
// query o(1) pull map
public class GroupByPriority {
    class WordPriority implements Comparator {

        String word;
        int priority;

        WordPriority(String word, int priority) {
            this.word = word;
            this.priority = priority;
        }

        @Override
        public int compare(Object word_1, Object word_2) {
            if (word_1 == null || word_2 == null) {
                return 0;
            }
            return ((String)word_1).compareTo((String)word_2);
        }
    }

    public static void main(String[] args) {
        GroupByPriority groupByPriority = new GroupByPriority();

        List<WordPriority> inputList = groupByPriority.getCreateWordPriorityList();
        List<WordPriority> outputList = groupByPriority.orderByPriorityContainingChar("sh", inputList);

        for (WordPriority wordPriority : outputList) {
            System.out.println(wordPriority.priority + " " + wordPriority.word);
        }
    }

    public List<WordPriority> getCreateWordPriorityList() {
        List<WordPriority> result = new ArrayList<WordPriority>() {
            {
                add(new WordPriority("shard", 1));
                add(new WordPriority("showcase", 1));
                add(new WordPriority("shark", 1));
                add(new WordPriority("share", 1));
                add(new WordPriority("test", 2));
                add(new WordPriority("neet", 3));
            }
        };

        return result;
    }

    public List<WordPriority> orderByPriorityContainingChar(String input, List<WordPriority> wordPriorityList) {

        List<WordPriority> result = new LinkedList();

        if (input == null || input.length() == 0 || wordPriorityList == null || wordPriorityList.size() == 0) {
            return result;
        }


        Map<Integer, List<WordPriority>> wordPriorityMap = new TreeMap<>();

        for (WordPriority wordPriority: wordPriorityList) {
            if (wordPriority != null && wordPriority.word != null
                    && wordPriority.word.contains(input)) {

                List<WordPriority> wordList = wordPriorityMap.get(wordPriority.priority);
                if (wordList == null) {
                    wordList = new ArrayList<>();
                }
                wordList.add(wordPriority);


                wordPriorityMap.put(wordPriority.priority, wordList);
            }
        }


        for (Integer priority : wordPriorityMap.keySet()) {
            List<WordPriority> wordList = wordPriorityMap.get(priority);
            if (wordList.size() > 1) { // atleast contains 2 ele
                Collections.sort(wordList, (wp1, wp2) -> wp1.word.compareTo(wp2.word));
            }
        }


        for (Integer priority : wordPriorityMap.keySet()) {
            result.addAll(wordPriorityMap.get(priority));
        }

        return result;
    }

}
