package algorithm;

public class Hanota {
    public int hanota(int n) {
        if (n==1) {return 2;}
        return 2 + hanota(n-1);
    }

    public static void main(String[] args) {
        System.out.println(new Hanota().hanota(2)                                                 );
    }

}
