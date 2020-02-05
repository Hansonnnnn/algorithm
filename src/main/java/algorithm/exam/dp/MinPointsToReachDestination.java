package algorithm.exam.dp;

import java.util.Scanner;
import java.lang.*;

public class MinPointsToReachDestination {
    static int findMinSum(int[][] a,int m,int n){

        int[][] table=new int[m][n];

        table[m-1][n-1]=(a[m-1][n-1]>0?1:Math.abs(a[m-1][n-1])+1);

        for(int i=m-2;i>=0;i--)
            table[i][n-1]=Math.max(table[i+1][n-1]-a[i][n-1],1);

        for(int j=n-2;j>=0;j--)
            table[m-1][j]=Math.max(table[m-1][j+1]-a[m-1][j],1);

        for(int u=m-2;u>=0;u--){
            for(int v=n-2;v>=0;v--){
                int min_points=Math.min(table[u+1][v],table[u][v+1]);
                table[u][v]=Math.max(min_points-a[u][v],1);
            }
        }
        return table[0][0];
    }

    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        for(int q=0;q<t;q++){
            int m=scan.nextInt();
            int n=scan.nextInt();
            int[][] a=new int[m][n];
            for(int w=0;w<m;w++)
                for(int e=0;e<n;e++)
                    a[w][e]=scan.nextInt();

            System.out.println(findMinSum(a,m,n));
        }
    }
}
