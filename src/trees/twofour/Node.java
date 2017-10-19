package trees.twofour;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ts250370 on 8/17/17.
 */
public class Node {
    int countOfSubNodes = 0;
    int countOfChildren = 0;
    SubNode [] subNodes;
    public Node [] children;

    public Node parent;
    public Node leftSibling;
    public Node rightSibling;

    public Node(int maxNoOfChildren) {
        children = new Node[maxNoOfChildren];
        subNodes = new SubNode[maxNoOfChildren-1];
    }

    public String toString() {
        StringBuilder stringBuilder =  new StringBuilder();
        for(SubNode subNode: subNodes) {
            stringBuilder.append(subNode + " ");
        }
        return stringBuilder.toString();
    }

    public void sortSubNodes() {
        Arrays.sort(subNodes, new Comparator<SubNode>() {
            @Override
            public int compare(SubNode subNode_1, SubNode subNode_2) {
                if (subNode_1 == null || subNode_2 == null) {
                    return 0;
                }
                return Integer.compare(subNode_1.key, subNode_2.key);
            }
        });
    }
}

class SubNode {
    int key;
    Object data;

    SubNode(int key, Object data) {
        this.key = key;
        this.data = data;
    }

    @Override
    public String toString() {
        if (data != null) {
            return key + " : " + data.toString();
        } else {
            return String.valueOf(key);
        }
    }
}