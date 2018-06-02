package string;

class PowerSet {

    public static void main (String[] args) {
        char[] s = {'a', 'b', 'c'};
        printPowerSet(s);
    }

    static void printPowerSet(char[] s) {
        double powSize = Math.pow(2, s.length);

        for (int counter=0; counter<powSize; counter++) {
            System.out.print("{");
            for (int i=0; i<s.length; i++) {
//                System.out.println(counter + " " + i + " " + (counter & (1<<i)));
                if ( (counter & (1<<i)) != 0) {
                    System.out.print(s[i]);
                }
            }
            System.out.println("}");
        }

    }

}