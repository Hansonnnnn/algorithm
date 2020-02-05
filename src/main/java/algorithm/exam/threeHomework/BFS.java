package algorithm.exam.threeHomework;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    private static int[][] edges;
    private static boolean[] visited;
    private static Queue<Integer> queue = new ArrayDeque<>();
    private static String trace = "";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNum = Integer.parseInt(scanner.nextLine());
        while (caseNum-->0) {
            String[] nodeNumAndStartNode = scanner.nextLine().split("\\s");
            int nodeNum = Integer.parseInt(nodeNumAndStartNode[0]);
            int startNode = nodeNumAndStartNode[1].charAt(0) - 'a';
            scanner.nextLine();//ignore nodes' name
            edges = new int[nodeNum][nodeNum];
            visited = new boolean[nodeNum];
            int edgesIndex = 0;
            while (nodeNum -- >0) {
                String[] values = scanner.nextLine().split("\\s");
                for (int i = 1;i < values.length;i++) {
                    edges[edgesIndex][i-1] = Integer.parseInt(values[i]);
                }
                edgesIndex++;
            }
            bfs(startNode);
            System.out.println(trace.trim());
            trace = "";
        }
    }
    private static void bfs(int node) {
        queue.offer(node);
        visited[node] = true;
        while (!queue.isEmpty()) {
            node = queue.poll();
            trace += (char)(node + 'a') + " ";
            int[] values = edges[node];
            for (int i = 0;i < values.length;i++) {
                if (values[i] == 1 && (!visited[i])) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
