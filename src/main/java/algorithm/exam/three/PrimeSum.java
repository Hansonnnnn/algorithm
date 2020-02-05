package algorithm.exam.three;

import java.util.Scanner;

public class PrimeSum {
    public static void main(String[] args) {
        PrimeSum primeSum = new PrimeSum();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        while(scanner.hasNext()) {
            int evenNum = Integer.valueOf(scanner.nextLine().trim());
            primeSum.getPrimePair(evenNum);
        }
    }

    private void getPrimePair(int num) {
        if(num < 3)return;
        boolean[] array = new boolean[num+1];
        for(int i = 2;i*i <= num;i++) {
            if(!array[i]) {
                for(int j = 2;j*i < array.length;j++) {
                    array[j*i] = true;
                }
            }
        }
        int i = 2;
        while(i < num) {
            if((!array[i]) && (!array[num-i])) {
                System.out.println(i + " " + (num-i));
                return;
            }
            i++;
        }

    }
}
