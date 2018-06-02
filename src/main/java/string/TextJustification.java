package string;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ts250370 on 5/27/18.
 */
public class TextJustification {

    public static void main(String[] args) {
//        String [] words = {"What","must","be","acknowledgment","shall","be"};
//        int maxWidth = 16;

//        String [] words = {"Science","is","what","we","understand","well","enough","to","explain",
//                "to","a","computer.","Art","is","everything","else","we","do"};
//        int maxWidth = 20;

        String [] words = {"Tushar", "Roy", "likes", "to", "code"};
        int maxWidth = 10;


        TextJustification textJustification = new TextJustification();
        List<String> result = textJustification.fullJustify(words, maxWidth);
        System.out.println(result);

    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        //build cost matrix; cost = square(unOccupied spaces to the right);
        int[][] cost = buildCostArray(words, maxWidth);

        //start i, j at last word
        int[] result = new int[words.length];
        int[] splittedAt = new int[words.length];

        for (int i = 0; i < words.length; i++) {

            if ( cost[0][i] != Integer.MAX_VALUE) {
                result[i] = cost[0][i];
                splittedAt[i] = i + 1;
            } else {
                int minCost = getMinCostByTryingToSplitAtEveryPosFrom0ToI(cost, result, splittedAt, i);
                result[i] = minCost;
            }
        }


        List<String> lines = new LinkedList<>();


        return lines;
    }

    private int getMinCostByTryingToSplitAtEveryPosFrom0ToI(int[][] cost, int[] result, int[] splittedAt, int i) {
        int j = 0;
        int minCost = Integer.MAX_VALUE;
        while (j + 1 <= i) {
            if ( cost[j+1][i] != Integer.MAX_VALUE) {
                int costOfSplitAtJ = result[j] + cost[j+1][i] ;
                if (costOfSplitAtJ < minCost) {
                    minCost = costOfSplitAtJ;
                    splittedAt[i] = j + 1;
                }
            }
            j += 1;
        }
        return minCost;
    }

    public List<String> fullJustifyFromEnd(String[] words, int maxWidth) {
        //build cost matrix; cost = square(unOccupied spaces to the right);
        int[][] cost = buildCostArray(words, maxWidth);

        //start i, j at last word
        int[] result = new int[words.length];
        int[] splittedAt = new int[words.length];

        for (int i = words.length - 1; i >= 0; i--) {
            int j = words.length - 1;

            if ( cost[i][j] != Integer.MAX_VALUE) {
                result[i] = cost[i][j];
                splittedAt[i] = j + 1;
            } else {
                int minCost = getMinCostByTryingToSplitAtEveryPosFromIToJ(cost[i], result, splittedAt, i, j);
                result[i] = minCost;
            }
        }


        List<String> lines = new LinkedList<>();
        int start = 0;
        for (int i = 0; i < splittedAt.length; i++) {
            int end = splittedAt[i];

            if (start != end) {
                int wordsIdx = start;
                String line = "";
                while (wordsIdx < end) {
                    if (wordsIdx > start) {
                        line += " ";
                    }
                    line += words[wordsIdx];
                    wordsIdx++;
                }
                lines.add(line);
            }

            start = end;
        }

        return lines;
    }

    private int getMinCostByTryingToSplitAtEveryPosFromIToJ(int[] ints, int[] result, int[] splittedAt, int i, int j) {
        int splitAt = i;
        int minCost = Integer.MAX_VALUE;
        while (splitAt <= j) {
            if ( ints[splitAt] != Integer.MAX_VALUE) {
                int costOfAtSplitAt = ints[splitAt] + result[splitAt+1];
                if (costOfAtSplitAt < minCost) {
                    minCost = costOfAtSplitAt;
                    splittedAt[i] = splitAt + 1;
                }
            }
            splitAt += 1;
        }
        return minCost;
    }

    private int[][] buildCostArray(String[] words, int maxWidth) {
        int[][] cost = new int[words.length][words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                int lengthOfWords = getLengthOfWords(words, i, j);
                if (lengthOfWords > maxWidth) {
                    cost[i][j] = Integer.MAX_VALUE;
                } else {
                    cost[i][j] = (maxWidth - lengthOfWords) * (maxWidth - lengthOfWords) * (maxWidth - lengthOfWords); //exaggerate the cost
                }
            }
        }
        return cost;
    }

    private int getLengthOfWords(String[] words, int start, int end) {
        int length = 0;

        int count = start;
        while (count <= end) {
            length += words[count].length();

            if (count > start) {
                length += 1; //add space between words
            }

            count++;
        }

        return length;
    }

}
