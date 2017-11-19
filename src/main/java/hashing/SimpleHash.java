package hashing;

import linkedlist.LinkedList;

import java.util.Scanner;

/**
 * Created by ts250370 on 8/17/17.
 */
public class SimpleHash {
    int SIZE = 10;
    Object [] hashTable = new Object[SIZE];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleHash simpleHash = new SimpleHash();

        while (true) {
            int input = sc.nextInt();
            if (input == 0) {
                simpleHash.put(sc.next());
            } else {
                int hashPos = simpleHash.get(sc.next());
                System.out.println(hashPos);
            }
        }
    }

    private void put(String input) {
        int hashPos = calculateHash(input);
        System.out.println("Hash Position " + hashPos);

        LinkedList list;
        if(hashTable[hashPos] == null) {
            list = new LinkedList();
            list.insertAtEndOfList(input);
            hashTable[hashPos] = list;
        } else {
            list = (LinkedList) hashTable[hashPos];
            list.insertAtEndOfList(input);
        }
    }

    private int get(String input) {
        int hashPos = calculateHash(input);

        if (hashTable[hashPos] != null) {
            LinkedList list = (LinkedList) hashTable[hashPos];
            for (int i=0; i<list.size(); i++) {
                if (input.equals(list.getAt(i))) {
                    return hashPos;
                }
            }
        }

        return -1;
    }

    private int calculateHash(String input) {
        int hash = 0;
        for(char ch : input.toCharArray()) {
            hash += ch; 
        }

        while(hash >= SIZE) {
            hash = Math.floorMod(hash, 7);
        }

        return hash;
    }

}
