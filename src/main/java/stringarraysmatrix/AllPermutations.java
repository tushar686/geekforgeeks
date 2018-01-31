package stringarraysmatrix;

import graphs.Vertex;

import java.util.Arrays;

/**
 * Created by ts250370 on 8/30/17.
 */
public class AllPermutations {

    public static void main(String[] args) {
        AllPermutations allPermutations = new AllPermutations();
        String input = "ABCD";
        Vertex [] vertices = new Vertex[input.length()];
        for (int i=0; i<input.length(); i++) {
            vertices[i] = new Vertex(input.charAt(i));
        }
//        allPermutations.permutations(input);
        System.out.println("==================");
        allPermutations.allPermutations(input, 0, new char[4], new int[] {1, 1, 1, 1});
        System.out.println("==================");
        allPermutations.DFSPermutations(vertices, new char[vertices.length], 0);
        
        //       allPermutations.allCombinations(input, 0, new char[3], new int[] {1, 1, 1});
        System.out.println("==================");
       allPermutations.DFSCombinations(vertices, 0, 0, new char[input.length()]);
    }

    public void allPermutations(String input, int depth, char [] output, int [] charCount) {

        if (depth == input.length()) {
            System.out.println(String.valueOf(output));
            return;
        }

        for (int i=0; i<input.length(); i++) {
            if (charCount[i] > 0) {
                output[depth] = input.charAt(i);
                charCount[i]--;
                allPermutations(input, depth+1, output, charCount);
                charCount[i]++;
            }
        }
    }

    public void allCombinations(String input, int depth, char [] output, int [] charCount) {
        if (depth == input.length()) {
            return;
        }

        for (int i=0; i<input.length(); ++i) {
            if (charCount[i] > 0) {
                output[depth] = input.charAt(i);
                for (int k=0; k<=depth; k++) {
                    System.out.print(output[k]);
                }
                System.out.println();
                depth++;
                charCount[i]--;
                allCombinations(input, depth, output, charCount);
                charCount[i]++;
                depth--;
            }
        }
    }

    public void permutations(String input) {
        for (char first : input.toCharArray()) {
            for (char second : input.toCharArray()) {
                for (char third : input.toCharArray()) {
                    if (third != first && third != second && second != first) {
                        System.out.println("" + first + second + third);
                    }
                }
            }
        }
    }

    public void DFSPermutations(Vertex[] vertices, char[] output, int depth) {
        if (depth == vertices.length) {
            System.out.println(String.valueOf(output));
            return;
        }

        for (int i=0; i<vertices.length; i++) {
            if (!vertices[i].discovered) {
                vertices[i].discovered = true;
                output[depth] = (char) vertices[i].label;
                depth++;
                DFSPermutations(vertices, output, depth);
                vertices[i].discovered = false;
                depth--;
            }
        }

    }

    public void DFSCombinations(Vertex[] vertices, int depth, int pos, char[] output) {
        if (depth == vertices.length) {
            return;
        }

        for (int i=pos; i<vertices.length; i++) {
            if (!vertices[i].discovered) {
                vertices[i].discovered = true;
                output[depth] = (char) vertices[i].label;
                for (int j=0; j<=depth; j++) {
                    System.out.print(output[j]);
                }
                System.out.println();
                DFSCombinations(vertices, depth+1, i+1, output);
                vertices[i].discovered = false;
            }
        }

    }

}
