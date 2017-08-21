package trees.binary;

import java.util.Scanner;

/**
 * Created by ts250370 on 8/17/17.
 */
public class TreeApp {

    public static void main(String[] args) {
        class Data {
            private final String name;
            private final String address;

            public Data(String name, String address) {
                this.name = name;
                this.address = address;
            }

            public String toString() {
                return this.name + " " + this.address;
            }

        }

        Tree tree = new Tree();

//        Scanner sc = new Scanner(System.in);
//        int input = sc.nextInt();
//
//        while(input != -1) {
//            tree.insert(null, input);
//            input = sc.nextInt();
//        }

        tree.insert(null, 18);
        tree.insert(null, 16);
        tree.insert(null, 15);
        tree.insert(null, 17);
        tree.insert(null, 24);
        tree.insert(null, 19);
        tree.insert(null, 29);
        tree.insert(new Data("Tushar", "Sunnyvale"), 27);
        tree.insert(null, 26);
        tree.insert(null, 28);
        tree.insert(null, 35);
        tree.insert(null, 33);
        tree.insert(null, 31);
        tree.insert(null, 32);
        tree.insert(null, 34);
        tree.insert(null, 37);
        tree.insert(null, 36);
        tree.insert(null, 38);

        //Traversal
        Traversal traversal = new Traversal(tree);
        System.out.println();
        traversal.doPreOrder();
        System.out.println();
        traversal.doInOrder();
        System.out.println();
        traversal.doPostOrder();
        System.out.println();

        //find
        Node found = tree.find(11); System.out.println(found != null ? found.data : "key not found");
        found = tree.find(18); System.out.println(found != null ? found.data : "key not found");
        found = tree.find(27); System.out.println(found != null ? found.data : "key not found");

        //Successor
        System.out.println("29's successor "  + tree.successor(tree.find(29)));

        //Delete
        System.out.println(tree.delete(27));
        System.out.println();
        traversal.doInOrder();

    }
}
