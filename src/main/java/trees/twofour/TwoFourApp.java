package trees.twofour;

/**
 * Created by ts250370 on 8/23/17.
 */
public class TwoFourApp {

    public static void main(String[] args) {
        TwoFourTree twoFourTree = new TwoFourTree();

        twoFourTree.insert(18, null);
        twoFourTree.insert(1, null);
        twoFourTree.insert(25, null);

        twoFourTree.insert(20, null);

        twoFourTree.insert(22, null);
        twoFourTree.insert(28, null);
        twoFourTree.insert(30, null);
        twoFourTree.insert(2, null);

        System.out.println("\n\nTraversing");
        twoFourTree.traverse();
    }
}
