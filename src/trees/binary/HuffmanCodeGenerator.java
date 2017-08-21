package trees.binary;

/**
 * Created by ts250370 on 8/20/17.
 */
public class HuffmanCodeGenerator {
    Tree [] frequency = new Tree[27];
    String [] codesTable = new String[27];
    HuffmanHeap heap = new HuffmanHeap();
    Tree huffmanCodeTree;

    public static void main(String[] args) {
        String message = "A SUSIE SAYS IT IS EASY";

        HuffmanCodeGenerator codeGenerator = new HuffmanCodeGenerator();
        codeGenerator.calculateFrequency(message);
        codeGenerator.insertAllTreesIntoHeap();
        codeGenerator.createHuffmanCodeTree();
        codeGenerator.createCodesTable();
        codeGenerator.printCodesTable();

        System.out.println(message);
        String coded = codeGenerator.code(message);
        System.out.println(coded);
        String decoded = codeGenerator.decode(coded);
        System.out.println(decoded);
    }

    private String code(String message) {
        String code = "";
        for (char ch : message.toCharArray()) {
            if (ch == 32) {
                code += codesTable[26];
            } else {
                code += codesTable[ch-65];
            }
        }
        return code;
    }

    private String decode(String code) {
        String decode = "";
        Node node = huffmanCodeTree.root;
        for (char ch : code.toCharArray()) {
            if (ch == '0') {
                node = node.leftChild;
            } else {
                node = node.righChild;
            }
            if (node.data != null) {
                decode += node.data;
                node = huffmanCodeTree.root;
            }
        }

        return decode;
    }

    private void printCodesTable() {
        for (int i=0; i<codesTable.length; i++) {
            if (codesTable[i] != null)
                System.out.println(((Character) (char)(i+65)) + " = " + 
                    frequency[i].root.key + " = " + codesTable[i]);
        }
    }
    private void createCodesTable() {
        Node start = huffmanCodeTree.root;
        preOrder(start, "");
    }

    private void preOrder(Node node, String code) {
        if(node == null) {
            return;
        }

        if (node.data != null) {
            char ch = (char) node.data;
            if (ch == 32) {
                codesTable[26] = code;
            } else {
                codesTable[ch - 65] = code;
            }
        }

        preOrder(node.leftChild, code.concat("0"));
        preOrder(node.righChild, code.concat("1"));
    }


    private void createHuffmanCodeTree() {
        Tree min_1 = heap.deleteMin();
        Tree min_2 = heap.deleteMin();
        while (min_1 != null && min_2 != null) {
            Tree newTree = mergeTrees(min_1, min_2);
            heap.insert(newTree);
            min_1 = heap.deleteMin();
            min_2 = heap.deleteMin();
        }
        huffmanCodeTree = min_1;
    }

    private Tree mergeTrees(Tree tree1, Tree tree2) {
        Tree newTree = new Tree();
        newTree.insert(null, tree1.root.key + tree2.root.key);

        newTree.root.leftChild = tree1.root;
        newTree.root.righChild = tree2.root;

        return newTree;
    }

    private void calculateFrequency(String message) {
        for (char ch : message.toCharArray()) {
            if (ch == 32) {
                createOrUpdateFrequencyTree(26, ch);
            } else {
                createOrUpdateFrequencyTree(ch-65, ch);
            }
        }
    }

    private void createOrUpdateFrequencyTree(int pos, char ch) {
        Tree tree;
        if (frequency[pos] == null) {
            tree = new Tree();
            tree.root = new Node(ch);
            tree.root.key = 1;
        } else {
            tree = frequency[pos];
            tree.root.key += 1;
        }
        frequency[pos] = tree;
    }

    private void insertAllTreesIntoHeap() {
        for (Tree tree: frequency) {
            if (tree != null) {
                heap.insert(tree);
            }
        }
    }
}
