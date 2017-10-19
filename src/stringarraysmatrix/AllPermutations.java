package stringarraysmatrix;

import graphs.Vertex;

import java.util.Arrays;

/**
 * Created by ts250370 on 8/30/17.
 */
public class AllPermutations {

    public static void main(String[] args) {
        AllPermutations allPermutations = new AllPermutations();
        String input = "ABC";
        Vertex [] vertices = new Vertex[input.length()];
        for (int i=0; i<input.length(); i++) {
            vertices[i] = new Vertex(input.charAt(i));
        }
//        allPermutations.DFSPermutation(vertices, new char[vertices.length], 0);
//        allPermutations.permutation(input);
        allPermutations.allPermutations(input, 0, 0, new char[3]);
//        allPermutations.DFSCombination(vertices, new char[vertices.length], 0);
    }

    public void allPermutations(String input, int startId, int numElem, char [] branch) {

        if (numElem == input.length()) {
            System.out.println(String.valueOf(branch));
            return;
        }

        for (int i=0; i<input.length(); ++i) {
            branch[numElem++] = input.charAt(i);
            allPermutations(input, ++startId, numElem, branch);
            numElem--;
        }
    }

    void combine(char[] arr, int k, int startId, char[] branch, int numElem) {
        if (numElem == k)
        {
            System.out.println(Arrays.toString(branch));
            return;
        }

        for (int i = startId; i < arr.length; ++i)
        {
            branch[numElem++] = arr[i];
            combine(arr, k, ++startId, branch, numElem);
            --numElem;
        }
    }

    public void permutation(String input) {
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

    public void DFSPermutation(Vertex[] vertices, char[] output, int depth) {
        if (depth == vertices.length) {
            System.out.println();
            System.out.println("printing " + depth);
            for (int i=0; i<output.length; i++) {
                System.out.print((char)output[i]);
            }
            System.out.println();
            return;
        }

        for (int i=0; i<vertices.length; i++) {
            if (!vertices[i].discovered) {
                System.out.println();
                System.out.print("Before_1: " + i + " " + depth + " ");
                vertices[i].discovered = true;
                output[depth] = (char) vertices[i].label;
                depth++;
                System.out.print("Before_2: " + i + " " + depth + " ");
                DFSPermutation(vertices, output, depth);
                System.out.println();
                System.out.print("After_1: " + i + " " + depth + " ");
                vertices[i].discovered = false;
                depth--;
                System.out.print("After_2: " + i + " " + depth + " ");
            }
        }

    }

    public void DFSCombination(Vertex[] vertices, char[] output, int depth) {
        if (depth == vertices.length) {
            return;
        }

        for (int i=0; i<vertices.length; i++) {
            if (!vertices[i].discovered) {
                vertices[i].discovered = true;
                System.out.print((char) vertices[i].label);
                depth++;
                DFSCombination(vertices, output, depth);
                vertices[i].discovered = false;
                depth--;
            }
        }

    }

}
