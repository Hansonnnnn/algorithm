package algorithm.exam.fifth;

import java.util.Scanner;

//为什么是贪婪？？因为在相等之前哪条路上的球的和最大就用谁的
//并且每一次在相等之后都是一次新的开始，将之前的最大值保留，然后再按照和之前一样的方法继续往前走
public class CollectBalls {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNum = Integer.parseInt(scanner.nextLine());
        while(caseNum-->0) {
            String[] nm = scanner.nextLine().split("\\s");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            String[] nBucketsStr = scanner.nextLine().split("\\s");
            String[] mBucketsStr = scanner.nextLine().split("\\s");
            int[] roadA = new int[nBucketsStr.length];
            int[] roadB = new int[mBucketsStr.length];
            for (int i = 0;i < roadA.length;i++) {
                roadA[i] = Integer.parseInt(nBucketsStr[i]);
            }
            for (int j = 0;j < roadB.length;j++) {
                roadB[j] = Integer.parseInt(mBucketsStr[j]);
            }
            System.out.println(maxBallsNum(roadA, roadB, n, m));
        }
    }

    private static int maxBallsNum(int[] roadA, int[] roadB, int n, int m) {
        int i = 0, j = 0;
        int sum1 = 0, sum2 = 0, res = 0;
        while(i < n && j < m) {
            if (roadA[i] < roadB[j]) {
                sum1 += roadA[i++];
            } else if (roadA[i] > roadB[j]) {
                sum2 += roadB[j++];
            } else {
                //等
                res += Math.max(sum1, sum2) + roadA[i];
                //如果有多个相等的值，全部加起来
                int equalValue = roadA[i];
                i++;
                j++;
                sum1 = 0;
                sum2 = 0;
                while (i < n && roadA[i] == equalValue) {
                    sum1+=roadA[i++];
                }
                while (j < m && roadB[j] == equalValue) {
                    sum2+=roadB[j++];
                }
            }
        }
        while (i < n) {
            res += roadA[i++];
        }
        while (j < m) {
            res += roadB[j++];
        }
        return res;
    }
}
