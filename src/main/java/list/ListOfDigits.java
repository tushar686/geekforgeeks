package list;

/**
 * Created by ts250370 on 9/9/17.
 */
public class ListOfDigits {

    public static void main(String[] args) {
        LinkedList list_1 = new LinkedList();
        list_1.insertAtEndOfList(3);
        list_1.insertAtEndOfList(1);
        list_1.insertAtEndOfList(5);

        LinkedList list_2 = new LinkedList();
        list_2.insertAtEndOfList(5);
        list_2.insertAtEndOfList(9);
        list_2.insertAtEndOfList(2);

        if (list_1.size() > list_2.size() ) {
            suffixSmallerListWithZeros(list_2, list_1.size() - list_2.size());
        } else {
            suffixSmallerListWithZeros(list_1, list_2.size() - list_1.size());
        }

        list_1.print();
        System.out.println();
        list_2.print();

        LinkedList list_3 = addRecursively(list_1, list_2);
        System.out.println();
        list_3.print();
    }

    private static LinkedList addRecursively(LinkedList list_1, LinkedList list_2) {
        LinkedList list_3 = new LinkedList();
        add(list_1.head, list_2.head, 0, list_3);
        return list_3;
    }

    private static LinkedList add(LinkedList.Node l1, LinkedList.Node l2, int carryOver, LinkedList list_3) {
        if (l1 == null) {
            return list_3;
        }
        int result = carryOver + Integer.parseInt(l1.item.toString()) + Integer.parseInt(l2.item.toString());
        carryOver = 0;
        if (result > 9) {
            carryOver = 1;
            result = result % 10;
        }
        list_3.insertAtEndOfList(result);

        return add(l1.next, l2.next, carryOver, list_3);

    }


    private static LinkedList add(LinkedList list_1, LinkedList list_2) {
        LinkedList list_3 = new LinkedList();

        LinkedList.Node currentList_1 = list_1.head;
        LinkedList.Node currentList_2 = list_2.head;
        int carryOver = 0;
        while (currentList_1 != null) {
            int result = carryOver + Integer.parseInt(currentList_1.item.toString()) + Integer.parseInt(currentList_2.item.toString());
            carryOver = 0;
            if (result > 9) {
                carryOver = 1;
                result -= 10;
            }

            list_3.insertAtEndOfList(result);

            currentList_2 = currentList_2.next;
            currentList_1 = currentList_1.next;
        }


        return list_3;
    }

    private static void suffixSmallerListWithZeros(LinkedList smallerList, int smallerBy) {
        for (int i=0; i < smallerBy; i++) {
            smallerList.insertAtEndOfList(0);
        }
    }
}
