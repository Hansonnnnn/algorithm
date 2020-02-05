package algorithm.exam.dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class MaxSumOfSubset {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr=new int[n];
            for(int i=0;i<n;i++)
                arr[i]=Integer.parseInt(st.nextToken());
            int[][] dp=new int[n][1024];
            System.out.println(calc(0,0,dp,arr));
        }
    }
    public static int calc(int i,int j,int[][] dp,int[] arr)
    {
        if(i==arr.length)
            return 0;
        if(dp[i][j]!=0)
            return dp[i][j];
        int j1=j,temp,r;
        boolean flag=false;
        temp=arr[i];
        while(temp>0)
        {
            r=temp%10;
            if(((1<<r)&j)>0)
            {
                flag=true;
                break;
            }
            j1=j1|(1<<r);
            temp/=10;
        }
        if(flag)
            return dp[i][j]=calc(i+1,j,dp,arr);
        return dp[i][j]=Math.max(arr[i]+calc(i+1,j1,dp,arr),calc(i+1,j,dp,arr));

    }
}
