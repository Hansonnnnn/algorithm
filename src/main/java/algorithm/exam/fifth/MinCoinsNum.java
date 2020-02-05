package algorithm.exam.fifth;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class MinCoinsNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNum = Integer.parseInt(scanner.nextLine());
        while (caseNum-->0) {
            String[] typesAndAmount = scanner.nextLine().split("\\s");
            int types = Integer.parseInt(typesAndAmount[0]);
            int amount = Integer.parseInt(typesAndAmount[1]);
            String[] vs = scanner.nextLine().split("\\s");
            int[] values = new int[types];
            for (int i = 0;i < types;i++) {
                values[i] = Integer.parseInt(vs[i]);
            }
            System.out.println(minCoin(values, amount));
        }
    }

    private static int minCoinNumWrongAnswer(int[] values, int amount) {
        int num = 0;
        Arrays.sort(values);
        int fromMaxCoinIndex = values.length-1;
        int index = fromMaxCoinIndex;
        while (amount > 0 && fromMaxCoinIndex >= 0) {
            while (amount > 0 && index >= 0) {
                int curMaxCoin = values[index];
                if (amount - curMaxCoin >= 0) {
                    amount -= curMaxCoin;
                    num++;
                } else {
                    index--;
                }
            }
            fromMaxCoinIndex--;
            index = fromMaxCoinIndex;
        }
        if (amount != 0) {return -1;}
        return num;
    }


    private static int minCoin(int[] values, int amount) {
        int num = 0;
        Arrays.sort(values);
        int index = values.length-1;
        Stack<Integer> stack = new Stack<>();
        while (amount > 0) {
            while (amount > 0 && index >= 0) {
                int curCoinValue = values[index];
                if (amount - curCoinValue >= 0) {
                    stack.push(index);
                    amount -= curCoinValue;
                    num++;
                } else {
                    index--;
                }
            }
            //amount > 0 && index < 0
            if (amount == 0) return num;
            int lastIndex = stack.pop();
            amount += values[lastIndex];
            num--;
            index = lastIndex-1;
            if (stack.isEmpty()) return -1;
        }
        if (amount != 0) return -1;
        return num;
    }
}
