package algorithm.exam.two;

import java.util.*;

public class LongestCommonSequence {
    public static void main(String[] args) {
        LongestCommonSequence longestCommonSequence = new LongestCommonSequence();
        Scanner scanner = new Scanner(System.in);
        int testCaseNum = Integer.parseInt(scanner.nextLine());
        while(testCaseNum > 0) {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            longestCommonSequence.longestCommonSequence(s1, s2);
            testCaseNum--;
        }
    }

    private void longestCommonSequence(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n+1][m+1];
        char[][] trace = new char[n+1][m+1];
        for(int i = 0;i < n+1;i++) {
            for(int j = 0;j < m+1;j++) {
                dp[i][j] = 0;
            }
        }
        for(int i = 1;i < n+1;i++) {
            for(int j = 1;j < m+1;j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    trace[i][j] = '↖';
                }else if(dp[i-1][j] > dp[i][j-1]){
                    dp[i][j] = dp[i-1][j];
                    trace[i][j] = '↑';
                }else if(dp[i-1][j] < dp[i][j-1]) {
                    dp[i][j] = dp[i][j-1];
                    trace[i][j] = '←';
                }else{
                    dp[i][j] = dp[i][j-1];
                    trace[i][j] = '┘';
                }
            }
        }
        String lcs = "";
        Set<String> results = new TreeSet<>();
        backTrace(s1,s2,lcs,trace,n,m,results,dp[n][m]);

        for(String s : results) {
            System.out.println(s);
        }
    }

    private void backTrace(String s1, String s2, String lcs, char[][] trace,int i, int j, Set<String> results, int maxSubLength) {
        if(i==0 || j==0) {
            if(lcs.length() == maxSubLength) {
                StringBuilder sb = new StringBuilder(lcs);
                lcs = sb.reverse().toString();
                //可能会提前出来，只有长度等于最长公共子序列长度的串才能被加入
                results.add(lcs);
            }
        }
        switch(trace[i][j]) {
            case '↖':
                lcs += s1.charAt(i-1);
                backTrace(s1,s2,lcs,trace,i-1,j-1,results,maxSubLength);
                break;
            case '↑':
                backTrace(s1,s2,lcs,trace,i-1,j,results,maxSubLength);
                break;
            case '←':
                backTrace(s1,s2,lcs,trace,i,j-1,results,maxSubLength);
                break;
            case '┘':
                backTrace(s1,s2,lcs,trace,i,j-1,results,maxSubLength);
                backTrace(s1,s2,lcs,trace,i-1,j,results,maxSubLength);
                break;
        }
    }
}
