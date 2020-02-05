package algorithm.exam.dp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecurrenceMatrix {
    public static void main (String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int cr[]={1,0,1,0,0,1,1};
        int tr=Integer.parseInt(br.readLine());
        for(int tt=0;tt<tr;tt++){
            int n=Integer.parseInt(br.readLine());
            int z=0;
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    z=z+cr[cal(i*j)];
                }
            }
            System.out.println(z);
        }
    }
    public static int cal(int a){
        int x=a%7;
        x=(x*x*x)%7;
        return x;
    }
}
