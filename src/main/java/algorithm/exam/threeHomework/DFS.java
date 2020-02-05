package algorithm.exam.threeHomework;

import java.util.Scanner;
import java.util.Stack;

public class DFS {
    private static int[][] edges;
    private static boolean[] visited;
    private static Stack<Integer> stack = new Stack<>();
    private static int maxLength = 0;
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
            dfs(startNode);
            System.out.println(maxLength);
        }
    }

    private static void dfs(int node) {
        stack.push(node);
        visited[node] = true;
        int[] values = edges[node];
        for (int i = 0;i < values.length;i++) {
            if (values[i] == 1 && (!visited[i])) {
                dfs(i);
            }
        }
        if (stack.size() > maxLength) {
            maxLength = stack.size();
        }
        stack.pop();
    }
}
