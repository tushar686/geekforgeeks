package trees.binary;

import java.util.ArrayList;
import java.util.List;

public class DistanceBT {

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

            DistanceBT distanceBT = new DistanceBT();
            Node lca = distanceBT.lca(tree.root, tree.find(32), tree.find(36));
            if (lca != null) {
                System.out.println(lca.key);
            }
    }

    public Node lca(Node root, Node n1, Node n2) {
        List<Node> path1 = new ArrayList<>();
        List<Node> path2 = new ArrayList<>();

        findPath(root, n1, path1);
        findPath(root, n2, path2);

        for (int i=0; i<path1.size() && i<path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                return path1.get(i-1);
            }
        }
        return null;
    }

    private boolean findPath(Node runner, Node n, List<Node> path) {
        path.add(runner);

        if (runner.key == n.key) {
            return true;
        }

        if(runner.leftChild != null && findPath(runner.leftChild, n, path)) {
            return true;
        }
        if(runner.rightChild != null && findPath(runner.rightChild, n, path)) {
            return true;
        }

        path.remove(path.size()-1);

        return false;
    }
}