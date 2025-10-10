package Graphs;

import java.util.*;

public class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> rowOrder = topoSort(k, rowConditions);
        List<Integer> colOrder = topoSort(k, colConditions);

        if (rowOrder.isEmpty() || colOrder.isEmpty()) {
            return new int[0][0]; // Cycle detected
        }

        Map<Integer, Integer> rowPos = new HashMap<>();
        Map<Integer, Integer> colPos = new HashMap<>();

        for (int i = 0; i < k; i++) {
            rowPos.put(rowOrder.get(i), i);
            colPos.put(colOrder.get(i), i);
        }

        int[][] matrix = new int[k][k];
        for (int num = 1; num <= k; num++) {
            int r = rowPos.get(num);
            int c = colPos.get(num);
            matrix[r][c] = num;
        }

        return matrix;
    }

    private List<Integer> topoSort(int k, int[][] conditions) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[k + 1];
        for (int[] cond : conditions) {
            adj.get(cond[0]).add(cond[1]);
            indegree[cond[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> order = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            order.add(node);

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        return order.size() == k ? order : new ArrayList<>();
    }
}
