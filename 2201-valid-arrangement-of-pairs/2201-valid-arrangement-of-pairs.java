import java.util.*;

class Solution {
    private Map<Integer, List<Integer>> adj = new HashMap<>();
    private Map<Integer, Integer> inDegree = new HashMap<>();
    private Map<Integer, Integer> outDegree = new HashMap<>();

    private int getStartNode() {
        int startNode = -1;
        for (Map.Entry<Integer, Integer> entry : outDegree.entrySet()) {
            int node = entry.getKey();
            int outDeg = entry.getValue();
            int inDeg = inDegree.getOrDefault(node, 0);

            if (outDeg - inDeg == 1) {
                return node;
            }
            if (startNode == -1 && outDeg > 0) {
                startNode = node;
            }
        }
        return startNode;
    }

    private void findEulerianPath(int node, List<Integer> path) {
        while (outDegree.getOrDefault(node, 0) > 0) {
            int nextIndex = outDegree.get(node) - 1;
            int nextNode = adj.get(node).get(nextIndex);
            outDegree.put(node, nextIndex);
            findEulerianPath(nextNode, path);
        }
        path.add(node);
    }

    public int[][] validArrangement(int[][] pairs) {
        for (int[] pair : pairs) {
            int from = pair[0], to = pair[1];
            adj.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            outDegree.put(from, outDegree.getOrDefault(from, 0) + 1);
            inDegree.put(to, inDegree.getOrDefault(to, 0) + 1);
        }

        int startNode = getStartNode();
        List<Integer> eulerianPath = new ArrayList<>();
        findEulerianPath(startNode, eulerianPath);

        int[][] result = new int[pairs.length][2];
        for (int i = eulerianPath.size() - 1, idx = 0; i > 0; i--, idx++) {
            result[idx][0] = eulerianPath.get(i);
            result[idx][1] = eulerianPath.get(i - 1);
        }

        return result;
    }
}
