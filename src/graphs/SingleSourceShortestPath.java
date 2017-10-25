//public class SingleSourceShortestPath {
//
//    class HeapData {
//        int priority;
//        Object data;
//
//        HeapData(int priority, Object data) {
//            this.priority = priority;
//            this.data = data;
//        }
//
//    }
//
//    public static void main(String[] args) {
//        int [] vertices = new int[] {0, 1, 2, 3, 4};
//        List<Integer>[] outAdj = new ArrayList<>()[vertice.length];
//        outAdj[0].add(1);
//        outAdj[0].add(2);
//        outAdj[1].add(2);
//        outAdj[1].add(4);
//        outAdj[2].add(3);
//        outAdj[3].add(4);
//
//        Map<String, Double> edges = new HashMap<>();
//        edges.put("0-1", 1.1);
//        edges.put("0-2", 0.5);
//        edges.put("1-2", 1);
//        edges.put("1-4", 2.5);
//        edges.put("2-3", 2);
//        edges.put("3-4", 0.1);
//
//        int[] path = new int[vertices.length];
//        int lastMinIndex = findSingleSourceShortesPath();
//        //path will contain shortest path starting from lastMinIndex; iterate and stop when path[i] = source
//    }
//
//    public int findSingleSourceShortesPath(int[] vertices, List<Integer> outAdj, Map<String, Integer> edges) {
//        Heap heap = new Heap();
//        int[] distance = new int[vertices.length];
//
//        for (int i=0; i<distance.length; i++) {
//            distance[i] = Integer.MAX_VALUE;
//            HeapData heapData = new heapData(distance[i], i);
//            heap.insert(distance[i], heapData);
//        }
//
//        distance[0] = 0;
//        HeapData heapData = new heapData(distance[0], 0);
//        heap.decreasePriority(heapData);
//
//        return findShortestPath(heap, distance, path, outAdj, edges, 0);
//    }
//
//    private int findShortestPath(Heap heap, int[] distance, int[] path, List<Integer> outAdj, Map<String, Double> edges, int lastMinIndex) {
//        HeapData heapData = heap.getMin(); //Assuming getMin also deletes
//        if (heapData == null) {
//            return lastMinIndex;
//        }
//
//        int minIndex = Integer(heapData.data).getInt();
//        lastMinIndex = minIndex;
//
//        for(int i=0; i<outAdj[minIndex].size; i++) {
//            int otherEndOfEdge = outAdj[i];
//            String edge = minIndex + "-" + otherEndOfEdge;
//            int newDistance = Math.min(distance[otherEndOfEdge], distance[minIndex] + map.get(edge));
//
//            if (newDistance != distance[otherEndOfEdge]) {
//                path[otherEndOfEdge] = minIndex;
//                HeapData newHeapData = new heapData(newDistance, otherEndOfEdge);
//                heap.decreasePriority(newHeapData);
//            }
//        }
//
//        return findShortestPath(heap, distance, path, outAdj, edges, lastMinIndex);
//    }
//
//}