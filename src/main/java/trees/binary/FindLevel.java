package trees.binary;

public class FindLevel {
    public static void main(String[] args) {
            Tree tree = new Tree();
            tree.insert(null, 18);
            tree.insert(null, 16);
            tree.insert(null, 15);
            tree.insert(null, 17);
            tree.insert(null, 24);
            tree.insert(null, 19);
            tree.insert(null, 29);
            tree.insert(null, 26);
            tree.insert(null, 28);
            tree.insert(null, 35);
            tree.insert(null, 33);
            tree.insert(null, 31);
            tree.insert(null, 32);
            tree.insert(null, 34);
            tree.insert(null, 37);
            tree.insert(null, 36);

            FindLevel findLevel = new FindLevel();
            System.out.println(findLevel.findLevel(80, tree.root, 0));
    }

    private int findLevel(int key, Node runner, int level) {
        if (runner == null) {
            return -1;
        }
        if (runner.key == key) {
            return level;
        }

        int lLevel = findLevel(key, runner.leftChild, level+1);
        if (lLevel != -1) {
            return lLevel;
        }
        int rLevel = findLevel(key, runner.rightChild, level+1);
        if (rLevel != -1) {
            return rLevel;
        }
        return -1;
    }
}