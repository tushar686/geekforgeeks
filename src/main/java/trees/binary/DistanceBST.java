package trees.binary;

public class DistanceBST {
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

            DistanceBST distanceBST = new DistanceBST();
            Node lca = distanceBST.lca(tree.root, tree.find(32), tree.find(36));
            System.out.println(lca.key);
    }

    public Node lca(Node runner, Node n1, Node n2) {
        if (n1.key > runner.key && n2.key > runner.key) {
            return lca(runner.rightChild, n1, n2);
        } else if (n1.key < runner.key && n2.key < runner.key) {
            return lca(runner.leftChild, n1, n2);
        } else {
            return runner;
        }
    }
}