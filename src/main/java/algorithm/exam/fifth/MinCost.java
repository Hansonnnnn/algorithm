package algorithm.exam.fifth;

import java.util.Scanner;

public class MinCost {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNum = Integer.parseInt(scanner.nextLine());
        while (caseNum-->0) {
            int size = Integer.parseInt(scanner.nextLine());
            String[] elements = scanner.nextLine().split("\\s");
            int[][] grid = new int[size][size];
            for (int i = 0;i < size;i++) {
                for (int j = 0;j < size;j++) {
                    grid[i][j] = Integer.parseInt(elements[i*size+j]);
                }
            }
            System.out.println(minCost(grid, size));
        }
    }

    private static int minCost(int[][] grid, int size) {
        int[][] dp = new int[size][size];
        for (int i = 0;i < size;i++) {
            dp[i][0] = i == 0 ? grid[0][0] : (dp[i-1][0] + grid[i][0]);
        }
        for (int j = 0;j < size;j++) {
            dp[0][j] = j == 0 ? grid[0][0] : (dp[0][j-1] + grid[0][j]);
        }
        for (int i = 1;i < size;i++) {
            for (int j = 1;j < size;j++) {
                dp[i][j] = dp[i-1][j] < dp[i][j-1] ? (dp[i-1][j] + grid[i][j]) : (dp[i][j-1] + grid[i][j]);
            }
        }
        return dp[size-1][size-1];
    }
}
