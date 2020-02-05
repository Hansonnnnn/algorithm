package algorithm.exam.dp;

import java.lang.*;
import java.io.*;
public class GFG {
    public static void main (String[] args) throws IOException {
        //code
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int caseNum =Integer.parseInt(br.readLine());
        while(caseNum-->0)
        {
            String s[]=br.readLine().split("\\s");
            int n=Integer.parseInt(s[0]);
            int h=Integer.parseInt(s[1]);
            int p=Integer.parseInt(s[2]);
            int[] weight=new int[n];
            int[] value=new int[n];
            for(int i=0;i<n;i++)
            {
                s=br.readLine().split("\\s");
                weight[i]=Integer.parseInt(s[0]);
                value[i]=Integer.parseInt(s[1]);
            }
            fn(weight,value,h,n,p);

        }
    }
    static void fn(int[] weight, int[] value, int W, int n,int p)
    {
        int[][] dp=new int[n+1][W+1];
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=W;j++)
            {
                if(weight[i-1]<=j)
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]]+value[i-1]);
                else
                    dp[i][j]=dp[i-1][j];

            }
        }
        if(dp[n][W]<p)
            System.out.println("NO");
        else
            System.out.println("YES "+backtrack(dp,weight,value,n,W));
    }
    static int backtrack(int[][] dp, int[] weight, int[] value, int n, int W)
    {
        int res=dp[n][W];
        int ans=0;
        int i=n, j=W;
        while(i>0 && j>0)
        {
            if(res==dp[i-1][j])
                i--;
            else
            {
                ans+=weight[i-1];
                j-=weight[i-1];
                res-=value[i-1];
                i--;
            }
        }
        return ans;
    }
}
