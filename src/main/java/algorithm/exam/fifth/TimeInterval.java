package algorithm.exam.fifth;

import java.util.Scanner;

public class TimeInterval {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNum = Integer.parseInt(scanner.nextLine());
        while (caseNum-->0) {
            int trainNum = Integer.parseInt(scanner.nextLine().trim());
            String[] aStr = scanner.nextLine().split("\\s");
            String[] dStr = scanner.nextLine().split("\\s");
            int[] a = new int[trainNum];
            int[] d = new int[trainNum];
            for (int i = 0;i < trainNum;i++) {
                a[i] = Integer.parseInt(aStr[i]);
                d[i] = Integer.parseInt(dStr[i]);
            }
            System.out.println(minPlatforms(a, d, trainNum));
        }
    }

    private static int minPlatforms(int[] a, int[] d, int trainNum) {
        int n = 1;
        int[] platformFreeTime = new int[trainNum];
        platformFreeTime[0] = d[0];
        boolean needNewPlatform = true;
        for (int i = 1;i < trainNum;i++) {
            for (int freeTrainNum = 0;freeTrainNum < n;freeTrainNum++) {
                if (a[i] > platformFreeTime[freeTrainNum]) {
                    platformFreeTime[freeTrainNum] = d[i];
                    needNewPlatform = false;
                    break;
                }
            }
            //遍历完目前所有站，发现没停下，新加一个站
            if (needNewPlatform) {
                platformFreeTime[n++] = d[i];
            }
            needNewPlatform = true;
        }
        return n;
    }
}
