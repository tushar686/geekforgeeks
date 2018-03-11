package graphs;

import java.util.*;

/**
 * Created by ts250370 on 2/5/18.
 */

class DisjointSet {
    int[] parent;

    DisjointSet(int maxSlots) {
        parent = new int[maxSlots+1];

        for (int i=0; i<= maxSlots; i++) {
            parent[i] = i;
        }
    }

    int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        return find(parent[i]);
    }

    public void union(int availableSlot, int i) {
        parent[availableSlot] = i;
    }
}


class Job implements Comparator<Job> {
    char id;
    int deadLine;
    int profit;

    Job() {

    }

    Job(char id, int deadLine, int profit) {
        this.id = id;
        this.deadLine = deadLine;
        this.profit = profit;
    }


    public static void printJobScheduling(ArrayList<Job> arr) {
        Collections.sort(arr, new Job());

        OptionalInt max = arr.stream().mapToInt(j -> j.deadLine).max();
        int maxDeadline = max.getAsInt();

        DisjointSet disjointSet = new DisjointSet(maxDeadline);

        for (Job j: arr) {
            int availableSlot = disjointSet.find(j.deadLine);

            if (availableSlot > 0) {
                disjointSet.union(availableSlot, availableSlot - 1);

                System.out.println(j.id);
            }
        }

    }

    @Override
    public int compare(Job j1, Job j2) {
        return j2.profit > j1.profit ? 1 : -1;
    }
}

public class JobSequencing {

    public static void main(String[] args) {
        ArrayList<Job> arr=new ArrayList<Job>();
        arr.add(new Job('a',2,100));
        arr.add(new Job('b',1,19));
        arr.add(new Job('c',2,27));
        arr.add(new Job('d',1,25));
        arr.add(new Job('e',3,15));
        System.out.println("Following jobs need to be " +
                "executed for maximum profit");
        Job.printJobScheduling(arr);
    }
}
