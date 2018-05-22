package stack_queus;

/**
 * Created by ts250370 on 9/11/17.
 */
public class MultipleStackInSingleArray {

    int stackSize = 10;
    int noOfStacks = 3;

    public MultipleStackInSingleArray(int noOfStacks, int stackSize) {
        this.noOfStacks = noOfStacks;
        this.stackSize = stackSize;
    }

    int [] buffer = new int[stackSize * noOfStacks];
    int [] stackCounters = new int[noOfStacks];

    public void push(int stackNumber, int value) {
        int index = stackNumber * stackSize + stackCounters[stackNumber];
        buffer[index] = value;
        stackCounters[stackNumber] += 1;
    }

    public int pop(int stackNumber) {
        int index = stackNumber * stackSize + stackCounters[stackNumber]-1;
        stackCounters[stackNumber] -= 1;

        return buffer[index];
    }

    public static void main(String[] args) {
        MultipleStackInSingleArray stk = new MultipleStackInSingleArray(3, 10);

        stk.push(0, 1);
        stk.push(0, 2);
        stk.push(0, 3);
        stk.push(0, 4);

        stk.push(1, 11);
        stk.push(1, 12);
        stk.push(1, 13);
        stk.push(1, 14);

        stk.push(2, 21);
        stk.push(2, 22);
        stk.push(2, 23);
        stk.push(2, 24);

        System.out.println(stk.pop(0));
        System.out.println(stk.pop(0));
        System.out.println(stk.pop(0));
        System.out.println(stk.pop(0));
        System.out.println();

        System.out.println(stk.pop(1));
        System.out.println(stk.pop(1));
        System.out.println(stk.pop(1));
        System.out.println(stk.pop(1));
        System.out.println();

        System.out.println(stk.pop(2));
        System.out.println(stk.pop(2));
        System.out.println(stk.pop(2));
        System.out.println(stk.pop(2));

    }
}
